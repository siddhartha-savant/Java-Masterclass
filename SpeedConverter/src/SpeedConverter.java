public class SpeedConverter {
    public static long toMilesPerHour(double kilometersPerHour){
        if(kilometersPerHour < 0){
            return -1;
        }else{

            //long milesPerHour = (long) (kilometersPerHour / 1.609); //This line is redundant.

            //Also the answer changes here after typecasting. e.g. 10.5/1.609 is a recurring number.
            // We are confining this number in a long i.e. not taking into consideration the Math.round class

            //long milesPerHourRounded = Math.round(milesPerHour);// long  mPHR = Math.round(kilometersPerHour/1.609);
            //return milesPerHourRounded; //Even that is redundant just return the whole expression
        }return Math.round(kilometersPerHour/1.609); // No variable is needed here
    }
    public static void printConversion(double kilometersPerHour){

        //double kilometersPerHour = kilometersPerHour;
        long toMilesPerHourRounded = toMilesPerHour(kilometersPerHour);{
            if(kilometersPerHour < 0) {
                System.out.println("Invalid Value");
            }
            else{
                System.out.println(kilometersPerHour + "km/h = " + toMilesPerHourRounded + "mi/h");
            }

        }
    }
}
