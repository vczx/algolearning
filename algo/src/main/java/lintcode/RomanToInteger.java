package lintcode;

import java.util.Hashtable;

public class RomanToInteger {
    private static Hashtable<String,Integer> romanToIntegerTable = new Hashtable<>();
    private static int sum = 0;
    public static void main(String[] args) {
        String put = "MCMXCIV";
        initTable();
        for(int i=0;i<put.length();i++){
            Character curr = put.charAt(i);

            if(curr == 'I' && i+1 <put.length()){
                Character next = put.charAt(i+1);
                if(next == 'V' | next == 'X'){
                    subtraction(curr.toString() + next.toString());
                    i +=1;

                }else {
                    addition(String.valueOf(put.charAt(i)));
                }

            }else if(curr == 'X' && i+1 <put.length()){
                Character next = put.charAt(i+1);
                if(next == 'L' | next == 'C'){
                    subtraction(curr.toString() + next.toString());
                    i +=1;
                }else {
                    addition(String.valueOf(put.charAt(i)));
                }

            }else if(curr == 'C' && i+1 <put.length()){
                Character next = put.charAt(i+1);
                if(next == 'D' | next == 'M'){
                    subtraction(curr.toString() + next.toString());
                    i +=1;
                }else {
                    addition(String.valueOf(put.charAt(i)));
                }

            }else {
                addition(String.valueOf(put.charAt(i)));
            }


        }
        System.out.println("sum is : "+ sum);
    }

    private static void initTable(){
        romanToIntegerTable.put("I", 1);
        romanToIntegerTable.put("V", 5);
        romanToIntegerTable.put("X", 10);
        romanToIntegerTable.put("L", 50);
        romanToIntegerTable.put("C", 100);
        romanToIntegerTable.put("D", 500);
        romanToIntegerTable.put("M", 1000);
        //
        romanToIntegerTable.put("IV", 4);
        romanToIntegerTable.put("IX", 9);
        romanToIntegerTable.put("XL", 40);
        romanToIntegerTable.put("XC", 90);
        romanToIntegerTable.put("CD", 400);
        romanToIntegerTable.put("CM", 900);
    }

    private static void addition(String s){

        if(romanToIntegerTable.containsKey(s)){
            sum += romanToIntegerTable.get(s);
        }
    }

    private static void subtraction(String pair){
        if(romanToIntegerTable.containsKey(pair)){
            sum += romanToIntegerTable.get(pair);
        }
    }

    //better solution

    // If a letter is immediately followed by one of equal or lesser value, the two values are added;
    // If a letter is immediately followed by one of greater value, the first is subtracted from the second.
    public int romanToInt(String s) {
        int total = 0;
        int prevValue = romanValue(s.charAt(0));

        // loop through the rest of the string
        for (int i = 1; i < s.length(); i++) {
            int curValue = romanValue(s.charAt(i));

            // if the current value is <= previous, we add
            // in the previous, saving current to maybe be
            // subtracted next time
            if (curValue <= prevValue)
                total += prevValue;
                // else we are subtracting prevValue from current
                // which is really just subtracting from the total
            else
                total -= prevValue;
            prevValue = curValue;
        }

        // the last value is always added
        total += prevValue;


        return total;
    }

    private int romanValue(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }

        return 0;
    }
}
