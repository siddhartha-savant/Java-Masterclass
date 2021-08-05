public class SumOddRange {
    public static boolean isOdd(int number){
        if(number<0){
            return false;
        }else if(number%2!=0){       //The easiest simplification for this is else return number%2!=0
            return true;
        }return false;
    }
    public static int sumOdd(int start, int end){
        int sum =0;
        if(start>0 && end >0 && end>=start){
            for(;start<=end;start++){   //here one might declare a new variable int i = start
               if(isOdd(start)){
                   sum += start;
               }
            }
            return sum;
        }else
            return -1;
    }
}
