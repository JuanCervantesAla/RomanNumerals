import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
@Author: Cervantes Emiliano
@Date: 16/08/23
@Assignment: Roman numerals
 */
public class Main {
    public static void main(String[] args) {

        //Objects
        Scanner scan = new Scanner(System.in);
        List<Character> firstNumeralList = new ArrayList<>();
        List<Character> secondNumeralList = new ArrayList<>();

        //Attributes
        String firstNumeral = "", secondNumeral = "", thirdNumeral = "";

        //Enter the data
        System.out.println("Enter the first Roman numeral");
        firstNumeral = scan.next();
        System.out.println("Enter the second Roman numeral");
        secondNumeral = scan.next();

        //Filling the list
        fillList(firstNumeralList,firstNumeral);
        fillList(secondNumeralList,secondNumeral);

        //Showing the list
        showList(firstNumeralList);
        showList(secondNumeralList);

        //Simplify phrase
        simplify(firstNumeralList);

    }

    public static void simplify(List numeralList){

        int limit = numeralList.size()-1 ;

        for( int counter = 0 ; counter < limit; counter++){

            if(order((Character) numeralList.get(counter)) < order((Character) numeralList.get(counter + 1))){

                switch ( eventCase( (Character) numeralList.get(counter) , (Character) numeralList.get(counter + 1) ) ){

                    case 6:
                        //Removing I
                        numeralList.remove(counter);
                        numeralList.remove(counter);

                        numeralList.add( counter  , 'V' );
                        numeralList.add( counter + 1 , 'I' );
                        numeralList.add( counter + 1 , 'I' );
                        numeralList.add( counter + 1 , 'I' );
                        numeralList.add( counter + 1 , 'I' );

                        showList(numeralList);

                        break;

                }

            }

        }

    }


    public static int eventCase (char first, char second ){

        if( first == 'I' && second == 'V'){
            return 6;
        }

        if( first == 'I' && second == 'X'){
            return 5;
        }

        if( first == 'X' && second == 'L'){
            return 4;
        }

        if( first == 'X' && second == 'C'){
            return 3;
        }

        if( first == 'C' && second == 'D'){
            return 2;
        }

        if( first == 'C' && second == 'M'){
            return 1;
        }

        return -1;

    }


    //Gets the order
    public static int order(char numeral){

        switch(numeral){

            case 'M':
                return 7;

            case 'D':
                return 6;

            case 'C':
                return 5;

            case 'L':
                return 4;

            case 'X':
                return 3;

            case 'V':
                return 2;

            case 'I':
                return 1;
        }

        return -1;

    }


    //Fill the list using the initial string
    public static void fillList(List numeralList,String numeral){

        for (char c : numeral.toCharArray()) {

            numeralList.add(c);

        }

    }

    //Shows the list using enchanced for
    public static void showList(List numeralList){
        for (Object c : numeralList) {

            System.out.print(c);

        }

        System.out.println();

    }


}