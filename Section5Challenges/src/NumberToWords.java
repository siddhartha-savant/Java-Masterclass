public class NumberToWords {
    public static void numberToWords(int number) {
        int newNumber = reverse(number);
        int newNumber2 = newNumber;
        if (newNumber < 0) {
            System.out.println("Invalid Value");
        } else {
            int rem;
            do {    //Here do while is written because for number=0. We can't use the usual while(number>0)
                rem = newNumber % 10;  //For number=0, this value won't be satisfied and loop won't be initiated
                newNumber /= 10;//We could also write this as while(true) and then break for condition(number==0)
                switch (rem) {
                    case 0:
                        System.out.println("Zero");
                        break;

                    case 1:
                        System.out.println("One");
                        break;

                    case 2:
                        System.out.println("Two");
                        break;

                    case 3:
                        System.out.println("Three");
                        break;

                    case 4:
                        System.out.println("Four");
                        break;

                    case 5:
                        System.out.println("Five");
                        break;

                    case 6:
                        System.out.println("Six");
                        break;

                    case 7:
                        System.out.println("Seven");
                        break;

                    case 8:
                        System.out.println("Eight");
                        break;

                    case 9:
                        System.out.println("Nine");
                        break;
                }
            } while (newNumber > 0);
        }
        if(getDigitCount(newNumber2) != getDigitCount(number)){
            for (int i=1;i<=(getDigitCount(number)-getDigitCount(newNumber2));i++){
                System.out.println("Zero");
            }
        }
    }
    public static int reverse(int number){
        int rem;
        int newNumber=0;
        do {
            rem = number % 10;                     //Similar is used for palindrome
            number /= 10;
            newNumber = (rem + newNumber) * 10;
        } while (number!=0);
        newNumber/=10;
        return newNumber;
    }
    public static int getDigitCount(int number){
        if(number<0){
            return -1;
        }else{
//            int count=0;
//            int mod=10;
//            int newNumber=0;
//            do {
//                newNumber=number%mod;  //This method was used in the digitSumChallenge project
//                mod*=10;
//                count++;
//            }while (newNumber!=number);
//            return count;
            int count =0;
            do{
                number/=10;
                count++;
            }while (number!=0);
            return count;
        }
    }
}
