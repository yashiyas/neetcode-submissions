/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {

        int can = 0;

        for(int i=1; i<n; i++){
            if(knows(can, i)){
                can = i;
            }
        }

        boolean isCeleb = true;

        for(int i=0; i<n; i++){
            if(i==can){
                continue;
            }
            if(!knows(i,can) || knows(can,i)){
                isCeleb = false;
                break;
            }
        }

        return isCeleb?can:-1;
        
    }
}
