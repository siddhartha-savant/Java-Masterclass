public class EvenDigitSum {
    public static int getEvenDigitSum(int number){
        if(number<0){
            return -1;
        }else{
            int number2 =0;
            int number3=0;
            for(int i =number;number>0;){  //Can also be written through while(true) or while(number>0)
                number2=number%10;
                number/=10;
                if(number2%2==0){
                    number3+=number2;
                }
            }return number3;
        }
    }
}
