public class GreatestCommonDivisor {
    public static int getGreatestCommonDivisor(int first, int second) {
        if (first < 10 || second < 10) {
            return -1;
        } else {
            int a;
            int b;
            int divisor = 0;
            if (first < second) {
                for (int i = 2; i <= first; i++) {
                    a = first % i;
                    b = second % i;
                    if (a == 0 && b == 0) {
                        divisor = i;
                    }
                }
                return divisor;
            } else {
                for (int i = 2; i <= second; i++) {
                    a = first % i;
                    b = second % i;
                    if (a == 0 && b == 0) {
                        divisor = i;
                    }
                }
                return divisor;
            }
        }
    }
}