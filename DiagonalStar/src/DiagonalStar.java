public class DiagonalStar {         //Koshish karne walon ki kabhi haar nahi hoti
    public static void printSquareStar(int number) {
        if (number < 5) {
            System.out.println("Invalid Value");
        }else{
            for (int i=1;i<=number;i++){
                for (int j=1;j<=number;j++) {
                    if (i == 1 || i == number) {
                        System.out.print("*");
                    } else if (i > 1 && i < number) {
                        if(j==1||j==number){
                            System.out.print("*");
                        }else if(i==j||j==(number-i+1)){
                            System.out.print("*");
                        }else{
                            System.out.print(" ");
                        }
                    }
                }
                System.out.println();
            }
        }
    }
}
