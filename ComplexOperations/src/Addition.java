public class Addition {
    private ComplexNumber complexNumber1;
    private ComplexNumber complexNumber2;

    public Addition(ComplexNumber complexNumber1, ComplexNumber complexNumber2) {
        this.complexNumber1 = complexNumber1;
        this.complexNumber2 = complexNumber2;
    }

    public ComplexNumber addingTwoComplexNumbers(){
        double real = complexNumber1.getReal()+complexNumber2.getReal();
        double imaginary = complexNumber1.getImaginary()+complexNumber2.getImaginary();
        return new ComplexNumber(real,imaginary);
    }
}

