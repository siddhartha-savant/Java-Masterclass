public class DecimalComparator {
    public static boolean areEqualByThreeDecimalPlaces(double number1, double number2){
        number1 = (int) (number1*1000);
        System.out.println(number1);
        number2 = (int) (number2*1000);
        System.out.println(number2);
        return number1 == number2;
    }
}
