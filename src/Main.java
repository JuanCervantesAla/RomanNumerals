import java.util.*;

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
        List<Character> finalNumeralList = new ArrayList<>();


        //Attributes
        String firstNumeral = "", secondNumeral = "", thirdNumeral = "";
        String concatNumerals="";


        //Enter the data
        System.out.println("Enter the first Roman numeral");
        firstNumeral = scan.next();
        System.out.println("Enter the second Roman numeral");
        secondNumeral = scan.next();


        //Filling the list
        fillList(firstNumeralList,firstNumeral);
        fillList(secondNumeralList,secondNumeral);

        //Simplify phrase
        simplify(firstNumeralList);
        simplify(secondNumeralList);

        //Creates an array
        concatNumerals = firstNumeralList.toString().replace("[", "").replace("]", "").replace("," , "").replace(" " , "")
                + secondNumeralList.toString().replace("[", "").replace("]", "").replace("," , "").replace(" " , "") ;
        fillList(finalNumeralList , concatNumerals);

        selectionSort(finalNumeralList);
        group(finalNumeralList);
        showList(finalNumeralList);


    }

    public static void group(List numeralList){

        int counter = 0;
        int howMany = 0;
        int listSize= numeralList.size()-1;
        Character current='M';

        while((Character)numeralList.get(counter) == 'M'){
            counter++;
        }

        do{
            if(counter <= numeralList.size()-1){
                current = (Character)numeralList.get(counter);
            }

            while( (Character)numeralList.get(counter) == current ){
                numeralList.remove(counter);
                howMany++;
            }

            switch (current){

                case 'C':
                    if(howMany == 4){
                        numeralList.add(counter , 'C');
                        numeralList.add(counter ,'D');
                    }
                    if(howMany == 5){
                        numeralList.add(counter ,'D');
                    }
                    break;

                case 'X':
                    if(howMany == 4){
                        numeralList.add(counter ,'X');
                        numeralList.add(counter ,'L');
                    }
                    if(howMany == 5){
                        numeralList.add(counter ,'L');
                    }
                    break;

                case 'I':
                    if(howMany == 4){
                        numeralList.add(counter ,'I');
                        numeralList.add(counter ,'V');
                    }
                    if(howMany == 5){
                        numeralList.add(counter ,'V');
                    }
                    break;

            }

            howMany=0;
            counter++;

            System.out.print("Result: ");
            showList(numeralList);

        }while (counter <= numeralList.size()-1);


    }


    public static void selectionSort(List numeralList) {

        int listSize = numeralList.size();

        for (int i = 0; i < listSize-1; i++) {

            int minimum = i;

            for (int j = i+1; j < listSize; j++) {
                if (order((Character) numeralList.get(j)) > order((Character) numeralList.get(minimum)) )
                    minimum = j;
            }

            Collections.swap(numeralList, minimum, i);
        }
    }


    public static void simplify(List numeralList){

        int limit = numeralList.size()-1 ;
        for( int counter = 0 ; counter < limit; counter++){
            if(order((Character) numeralList.get(counter)) < order((Character) numeralList.get(counter + 1))){

                switch ( eventCase( (Character) numeralList.get(counter) , (Character) numeralList.get(counter + 1) ) ){

                    case 6://IV
                        numeralList.remove(counter);

                        numeralList.add( counter + 1 , 'I' );
                        numeralList.add( counter + 1 , 'I' );
                        numeralList.add( counter + 1 , 'I' );
                        numeralList.add( counter + 1 , 'I' );
                        break;


                    case 5://IX
                        numeralList.remove(counter);
                        numeralList.remove(counter);

                        numeralList.add( counter  , 'V' );
                        numeralList.add( counter + 1 , 'I' );
                        numeralList.add( counter + 1 , 'I' );
                        numeralList.add( counter + 1 , 'I' );
                        numeralList.add( counter + 1 , 'I' );
                        break;


                    case 4://XL
                        numeralList.remove(counter);
                        numeralList.remove(counter);

                        numeralList.add( counter + 1 , 'X' );
                        numeralList.add( counter + 1 , 'X' );
                        numeralList.add( counter + 1 , 'X' );
                        numeralList.add( counter + 1 , 'X' );
                        break;

                    case 3://XC
                        numeralList.remove(counter);
                        numeralList.remove(counter);

                        numeralList.add( counter  , 'L' );
                        numeralList.add( counter + 1 , 'X' );
                        numeralList.add( counter + 1 , 'X' );
                        numeralList.add( counter + 1 , 'X' );
                        numeralList.add( counter + 1 , 'X' );
                        break;


                    case 2://CD
                        numeralList.remove(counter);

                        numeralList.add( counter + 1 , 'C' );
                        numeralList.add( counter + 1 , 'C' );
                        numeralList.add( counter + 1 , 'C' );
                        numeralList.add( counter + 1 , 'C' );
                        break;

                    case 1://CM
                        numeralList.remove(counter);
                        numeralList.remove(counter);

                        numeralList.add( counter  , 'D' );
                        numeralList.add( counter + 1 , 'C' );
                        numeralList.add( counter + 1 , 'C' );
                        numeralList.add( counter + 1 , 'C' );
                        numeralList.add( counter + 1 , 'C' );
                        break;

                }

            }

            limit = numeralList.size()-1;

        }

        System.out.print("Simplified list: ");
        showList(numeralList);

    }

    //Choose which pair is occurring
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
