package com.company;

class Movie{
    private String name;

    public Movie(String name) {
        this.name = name;
    }
    public String plot(){
        return "No plot here";
    }

    public String getName() {
        return name;
    }
}

class Jaws extends Movie{
    public Jaws() {
        super("Jaws");
    }

    public String plot(){          //Overrides plot() method in class Movie
        return "Shark eats people";
    }
}

class IndependenceDay extends Movie{
    public IndependenceDay() {
        super("Independent Day");
    }

    @Override
    public String plot() {
        return "Freedom struggle movie";
    }
}

class ShawshankRedemption extends Movie{
    public ShawshankRedemption() {
        super("Shawshank Redemption");
    }

    @Override
    public String plot() {
        return "Escape from prison and much more";
    }
}

class MazeRunner extends Movie{
    public MazeRunner() {
        super("Maze Runner");
    }

    @Override
    public String plot() {
        return "Running out of maze";
    }
}
class ForgettableMovie extends Movie{
    public ForgettableMovie() {
        super("Forgettable movie");
    }

}


public class Main {

    public static void main(String[] args) {
        Movie movie1 = new Jaws();                                     // Check these 3 objects: movie1, movie2
        System.out.println(movie1.getName() + "\n" + movie1.plot());   // movie3. And check the movie1.plot()

        Movie movie2 = new ForgettableMovie();                         //movie2.plot() and movie3.plot() respectively
        System.out.println(movie2.getName() + "\n" + movie2.plot());   //You will get an idea of polymorphism

        ForgettableMovie movie3 = new ForgettableMovie();
        System.out.println(movie3.getName() + "\n" + movie3.plot());

        for(int i=1;i<11;i++){
            Movie movie = randomMovie(); //Calling function in movie variable/object. Now we have our Movie in
                                        //movie object. Remember every time new object is created 'movie' and
                                       //because 'new' keyword is used in the return of the switch cases. The reference is
                                        //changing everytime. Although new objects are being created, movie identifier is just
                                        //pointing at different objects at different times.
            System.out.println("Movie #" + i + " : "+ movie.getName() + "\n" + "Plot: " + movie.plot() + "\n");
        }

    }
    public static Movie randomMovie(){

        //The return type of this method is of class Movie. So inherited classes
        //can be returned. Also the field variables for inherited classes is same as the super class Movie

        int randomNumber = (int)(Math.random()*5)+1;

        //The Math.random method produces a random number between 0-1
        //When multiplied by 5 and (int) will give us 0-4. When added to 1, range becomes 1-5.

        System.out.println("Random number generated was: " + randomNumber);
        switch(randomNumber) {
            case 1:
                return new Jaws();  //here we can also write return new Movie("...."); The object will be for the
                                    //base class.
            case 2:
                return new IndependenceDay();

            case 3:
                return new ShawshankRedemption();

            case 4:
                return new MazeRunner();

            case 5:
                return new ForgettableMovie();

            default:
                return null;
        }

    }

}