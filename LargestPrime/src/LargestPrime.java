public class LargestPrime {
    public static int getLargestPrime(int number) {
//        boolean prime = false;
//        for (int i = 2; i <= number / 2; i++) {
//            if (number % i == 0) {
//                prime = false;
//                break;
//            } else {
//                prime = true;
//            }
//        }
        if (number < 2) {
            return -1;
        } else {
            int factor = 0;
            int largestPrime = 0;
            for (int i = 1; i <= number; i++) {
                if (number % i == 0) {
                    factor = i;
                    for (int j = 2; j <= factor; j++) {
                        if (factor % j == 0 && factor == j) {
                            largestPrime = factor;
                            break;
                        } else if (factor % j == 0) {
                            break;
                        }
                    }
                }
            }
            return largestPrime;
        }
    }
}
//    public static boolean primeNumber(int number){
//        for(int i=2;i<=number/2;i++){
//            if(number%i==0){
//                return false;
//            }
//        }return true;
//    }
//}
