public class FlourPacker {
    public static boolean canPack(int bigCount, int smallCount, int goal){
        if(bigCount<0 && smallCount<0 &goal<0){
            return false;
        }else{
            if(5*bigCount>=goal && smallCount==0 && goal%5==0){
                return true;
            }else if(bigCount==0 && smallCount>=goal){
                return true;
            }else if((5*bigCount + smallCount)==goal){
                return true;
            }else if((5*bigCount + smallCount)>goal){
                int diff=0;
                diff=((5*bigCount)+smallCount)-goal;
                if(diff%5==0){
                    return true;
                }else if(diff<5 && smallCount>=diff){
                    return true;
                }else if(diff>5 && diff%5<=smallCount){
                    return true;
                }else{
                    return false;
                }
            }
        }return false;
    }
}
