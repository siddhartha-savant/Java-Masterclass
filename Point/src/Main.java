public class Main {
    public static void main(String[] args) {
        Point first = new Point(1,1);
        Point second = new Point(2,2);
        System.out.println(first.distance());
        System.out.println(first.distance(2,2));
        System.out.println(first.distance(second));
    }
}
