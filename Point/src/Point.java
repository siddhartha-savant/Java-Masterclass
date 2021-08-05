public class Point {
    private  int x;
    private  int y;

    public Point() {
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    public double distance(){
        int result = (x*x)+(y*y);
        return Math.sqrt(result);
    }
    public double distance(int x, int y){
        int result = ((getX()-x)*(getX()-x))+((getY()-y)*(getY()-y));
        return Math.sqrt(result);
    }
    public double distance(Point another){ //As we know class is a special data type of sorts, so the parameter we
        int result = ((getX()-another.getX())*(getX()-another.getX())) //have here is another of data type Point.
                +((getY()-another.getY())*(getY()-another.getY())); //another in this case is  a different object
        return Math.sqrt(result);          //of the same class. In this method, we are basically using values from
    }                                     //different objects although they belong to the same class.
}
//The formula above can be shortened: Instead of writing getX()-another.getX(), we could also have written
// getX() - another.x This is because we are able to access the private field as the method belongs to the same class