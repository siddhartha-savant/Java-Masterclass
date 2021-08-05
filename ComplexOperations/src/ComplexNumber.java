public class ComplexNumber {
    private double real;
    private double imaginary;


    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }
    public void add(double real, double imaginary){   //Here we are just adding the parameters to the real and
        this.real+=real;                              // imaginary numbers.
        this.imaginary+=imaginary;
    }
    public void add(ComplexNumber complexNumber){
        this.real = real+complexNumber.real;           //Here we are doing the sum of two objects of complex numbers
        this.imaginary = imaginary+complexNumber.getImaginary();//However, the sum is stored in the instance variables
    }                                                     //of the object calling the method.
    public void subtract(double real, double imaginary){//We need to understand that a method with class being the
        this.real-=real;                              //return type is also possible. For this look up the
        this.imaginary-=imaginary;                    //polymorphism project.
    }
    public void subtract(ComplexNumber complexNumber){
        this.real = real-complexNumber.real;
        this.imaginary = imaginary-complexNumber.getImaginary();
    }
    //This operation on two objects as mentioned above can be done in both inheritance and composition.
    //In this case, one object is passed through parameter and the operation is done as stated in main
    //on the other object.

    //We can do this operation on two objects without the need of passing a parameter if we have two objects
    //already present with us. This can be easily done in a composition class with field variables of the two objects
    //eg. private ComplexNumber complexNumber1;
    //    private ComplexNumber complexNumber2;
    //  The example is given in a class Addition
}


