public class FirstLastDigitSum2 {
    public static int sumFirstAndLastDigit(int number) {
        if (number < 0) {
            return -1;
        } else {
            int firstDigit = 0;
            int lastDigit = 0;
            lastDigit = number % 10;
            while (number > 0) {
                firstDigit = number % 10;
                number /= 10;
                if (number == 0) {
                    return lastDigit + firstDigit;
                }
            }return -1;
        }
    }
}
