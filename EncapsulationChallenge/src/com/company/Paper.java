package com.company;

public class Paper {
    private String typeOfPaper;
    private String typeOfBinding;

    public Paper(String typeOfPaper, String typeOfBinding) {
        this.typeOfPaper = typeOfPaper;
        this.typeOfBinding = typeOfBinding;
    }

    public String getTypeOfPaper() {
        return typeOfPaper;
    }

    public String getTypeOfBinding() {
        return typeOfBinding;
    }
}
