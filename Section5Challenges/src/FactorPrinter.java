public class FactorPrinter {
    public static void printFactors(int number){
        if(number<1){
            System.out.println("Invalid Value");
        }else{
            int factor=0;
            int divisor=number;
            int rem;
            while(divisor>=1){
                factor=number/divisor;
                rem=number%divisor;
                divisor--;
                if(rem==0){
                    System.out.println(factor);
                }
            }
        }
    }
}
