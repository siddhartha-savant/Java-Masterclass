import java.util.Scanner;

public class InputCalculator {
    public static void inputThenPrintSumAndAverage() {
        int sum = 0;
        int count = 0;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            boolean isThisInt = scanner.hasNextInt();
            if (isThisInt) {
                int number = scanner.nextInt();
                sum += number;
                count++;
            } else {
                long average = Math.round((double) sum / count);
                System.out.println("SUM = " + sum + " AVG = " + average);
                break;
            }
            scanner.nextLine();
        }scanner.close();
    }
}
