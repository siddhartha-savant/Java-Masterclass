public class MinutesToYearsDaysCalculator {
    public static void printYearsAndDays(long minutes){
        if(minutes<0){
            System.out.println("Invalid Value");
        }else{
            long year = minutes/(365*24*60);
            long remMinutes = minutes%(365*24*60);
            remMinutes = remMinutes/(24*60);
            if(year==0){
                remMinutes = minutes/(24*60);
            }
            System.out.println(minutes + " min = " + year + " y and " + remMinutes + " d");
        }
    }
}
