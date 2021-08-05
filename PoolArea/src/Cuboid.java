public class Cuboid extends Rectangle{
    private double height;

    public Cuboid(double width, double length, double height1){
        super(width, length);
        height=height1;
        if(height1<0)
            height=0;
    }
    public double getHeight(){
        return height;
    }
    public double getVolume(){
        return getArea()*getHeight();
    }

}
