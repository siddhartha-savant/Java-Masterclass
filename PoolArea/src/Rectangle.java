public class Rectangle {
    private double width;
    private double length;

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;         //This is right
        if(width<0)
            this.width=0;
        if(length<0)
            this.length=0;
        //this.length = length;         //This is wrong over here. The conditional statement has no point
    }
    public double getWidth(){
        return width;
    }
    public double getLength(){
        return length;
    }
    public double getArea(){
        return length*width;
    }

}
