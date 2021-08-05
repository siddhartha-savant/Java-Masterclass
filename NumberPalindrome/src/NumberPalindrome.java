public class NumberPalindrome {
    public static boolean isPalindrome(int number){
        int mod;
        int mod2=0;
        int number2 = number;
        while (true){    //Here i cannot write while(number>0) because we are then not considering negative no.
            mod=number%10;   // Negative no. can also be palindrome.
            number/=10;
            mod2=(mod2+mod)*10;
            if(number==0) {
                mod2 /= 10;
                break;
            }
        }
        return mod2 == number2;
    }
}
