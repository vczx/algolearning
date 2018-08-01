package leetcode;

public class RotatedDigits {

    public static void main(String[] args) {
        System.out.println("Count : " + rotatedDigits(250));
//        System.out.println(rotateNumber(250));
    }

    public static int rotatedDigits(int N) {
        int count = 0;
        for(int i=1;i<=N;i++){
            int rotatedNumber = rotateNumber(i);
            if(rotatedNumber != -1 && rotatedNumber != i){
                count++;
            };
        }
        return count;
    }

    private static int rotateNumber(int number ){
        int curNum = Integer.valueOf(number);
        System.out.println("Current Num is " + curNum);
        int curDigit = -1;
        int rotatedNum = 0;
        boolean isComplete = true;

        while(curNum!=0){
            curDigit = curNum % 10;
            //System.out.println("Current Digit : " + curDigit);
            int rotatedDigit = rotateDigit(curDigit);
            if(rotatedDigit<0){
                isComplete = false;
                break;
            }else{
                rotatedNum = rotatedNum*10 + rotatedDigit;
                if(rotatedNum*10 == 0){
                    isComplete = false;
                    break;
                }
            }
            curNum = curNum / 10;
        }

        if(isComplete){
            return rotatedNum;
        }

        return -1;
    }

    private static int rotateDigit(int digit){
        if(digit == 0 || digit == 1 || digit == 8){
            return digit;
        }else if(digit == 2){
            return 5;
        }else if(digit == 5){
            return 2;
        }else if(digit == 6){
            return 9;
        }else if(digit == 9){
            return 6;
        }
        return -1;
    }
}
