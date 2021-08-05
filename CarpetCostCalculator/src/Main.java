public class Main {
    public static void main(String[] args) {
        Carpet carpet = new Carpet(3.5);
        Floor floor = new Floor(2.75, 4.0);
        Calculator calculator = new Calculator(floor, carpet);  //As commented in Calculator class, the objects for
        System.out.println("total= " + calculator.getTotalCost());//Carpet and Floor, are the field values for class
        carpet = new Carpet(1.5);                            //Calculator
        floor = new Floor(5.4, 4.5);
        calculator = new Calculator(floor, carpet);
        System.out.println("total= " + calculator.getTotalCost());

    }
}
