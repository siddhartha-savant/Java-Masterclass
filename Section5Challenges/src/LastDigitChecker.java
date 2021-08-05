public class LastDigitChecker {
    public static boolean hasSameLastDigit(int number1, int number2, int number3){
        if(isValid(number1) && isValid(number2) && isValid(number3)){
            int lastDigit1 = number1%10;
            int lastDigit2 = number2%10;
            int lastDigit3 = number3%10;
            return lastDigit1 == lastDigit2 || lastDigit1 == lastDigit3 || lastDigit2 == lastDigit3;
        }else{
            return false;
        }
    }
    public static boolean isValid(int number1){
        if(number1<10 || number1>1000){
            return false;
        }return true;
    }
}
