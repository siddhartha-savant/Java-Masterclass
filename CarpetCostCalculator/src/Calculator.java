public class Calculator {    //As stated class is a data type on steroids. Its a blueprint for objects.
    private Floor floor;     //Here, Floor, Carpet are the datatype and floor carpet are the fields(variables)
    private Carpet carpet;   //for the datatype. However, when defining objects in Main for Floor and Carpet,
                             //the objects for Floor & Carpet will become the fields(variables) for class Calculator
    public Calculator(Floor floor, Carpet carpet) {
        this.floor = floor;
        this.carpet = carpet;
    }
    public double getTotalCost(){
        return floor.getArea() * carpet.getCost();  //Here i cannot write carpet.cost as cost field is private
    }                                               //and belongs to different class
}
