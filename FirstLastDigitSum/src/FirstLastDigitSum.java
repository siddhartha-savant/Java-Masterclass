public class FirstLastDigitSum {
    public static int sumFirstAndLastDigit(int number){
        if(number<0){
            return -1;
        }else{
            int lastDigit=0;
            int firstDigit=0;
            while (number>0){
                lastDigit=number%10;
                do {
                    firstDigit = number % 10;  //Can also be done using while(true) and then a conditional statement
                    number /= 10;             //for break;
                } while (number != 0);
            }return firstDigit+lastDigit;
        }
    }
}
