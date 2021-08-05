public class PerfectNumber {
    public static boolean isPerfectNumber(int number){
        if(number<1){
            return false;
        }else {
            int factor=0;
            int sum=0;
            int rem=0;
            for(int i =number;i>1;i--){
               factor=number/i;
               rem=number%i;
               if(rem==0)
               sum+=factor;
            }
            return sum == number;
        }
    }
}
