class Solution {
    public List<Integer> partitionLabels(String s) {

        Map<Character, Interval> charMap = new HashMap();
        List<Integer> ans = new ArrayList();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(charMap.containsKey(c)){
                charMap.get(c).end = i;
            } else{
                charMap.put(c, new Interval(i,i));
            }
        }

        List<Interval> intervals = new ArrayList();

        for(Map.Entry<Character,Interval> entry: charMap.entrySet()){
            intervals.add(entry.getValue());
        }

        Collections.sort(intervals, (a,b) -> a.start-b.start);

        int i=0;

        ArrayDeque<Interval> aq = new ArrayDeque();

        while(i<intervals.size()){
            Interval curr = intervals.get(i);
            if(aq.isEmpty()){
                aq.push(curr);
                i++;
            }
            else{
                Interval prev = aq.peek();
                if(curr.start > prev.end){
                    aq.push(curr);
                }
                else{
                    aq.pop();
                    curr.start = Math.min(prev.start, curr.start);
                    curr.end = Math.max(prev.end, curr.end);
                    aq.push(curr);
                }
                i++;
            }

        }

        while(!aq.isEmpty()){
            Interval curr = aq.pop();
            int size = curr.end-curr.start+1;
            ans.add(size);
        }

        Collections.reverse(ans);

        return ans;
        
    }

    class Interval {
        int start;
        int end;

        Interval(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
}
