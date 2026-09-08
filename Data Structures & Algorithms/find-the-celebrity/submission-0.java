/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        Map<Integer,Integer> knows = new HashMap();
        Map<Integer, Integer> isKnown = new HashMap();

        for(int i=0; i<n; i++){
            knows.put(i,0);
            isKnown.put(i,0);
        }

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(knows(i,j)){
                    knows.put(i, knows.get(i)+1);
                    isKnown.put(j, isKnown.get(j)+1);
                }
                if(knows(j,i)){
                    knows.put(j, knows.get(j)+1);
                    isKnown.put(i, isKnown.get(i)+1);
                }
            }
        }

        for(int i=0; i<n; i++){
            if(isKnown.get(i) == n-1 && knows.get(i) == 0){
                return i;
            }
        }

        return -1;

    }
}
