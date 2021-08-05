package com.company;

public class Button {      //The button class is created to represent the local class example of inner classes
    private String title;  //A class ClickListener is defined in the main method to show local class
    private OnClickListener onClickListener;    //It is the interface defined in this class itself

    public Button(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setOnClickListener(OnClickListener onClickListener){
        this.onClickListener=onClickListener;
    }

    public void onClick(){                    //As we have created a field of datatype interface 'OnClickListener'
        this.onClickListener.onClick(this.title); //we are able to access the methods in that interface. Thus,
    }                                           //field.method--> this.onClickListener.onClick(this.title);


    public interface OnClickListener{
        public void onClick(String title);
    }

}
