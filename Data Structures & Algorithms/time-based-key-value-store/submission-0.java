class TimeMap {
    private Map<String,List<Pair>> timeValues;

    public TimeMap() {

        this.timeValues = new HashMap();

        
    }
    
    public void set(String key, String value, int timestamp) {

        Pair p = new Pair(timestamp, value);

        if(timeValues.containsKey(key)){
            List<Pair> list = timeValues.get(key);
            list.add(p);
            timeValues.put(key,list);
        } else{
            List<Pair> list = new ArrayList();
            list.add(p);
            timeValues.put(key,list);
        }
        
    }
    
    public String get(String key, int timestamp) {
        Pair ans = new Pair(Integer.MIN_VALUE, "");

        if(timeValues.containsKey(key)){
            List<Pair> list = timeValues.get(key);
            int lower = 0;
            int higher = list.size() - 1;

            while(lower <= higher && lower >= 0 && higher < list.size()){
                int mid = lower + (higher - lower)/2;
                Pair p = list.get(mid);
                System.out.println(lower);
                System.out.println(higher);
                System.out.println(mid);

                if(p.time == timestamp){
                    return p.value;
                }
                if(p.time > timestamp){
                    higher = mid - 1;
                }
                else{
                    if(ans.time < p.time){
                        ans = p;
                    }
                    lower = mid + 1;
                }
            }

        }

        return ans.value;
         
    }

    class Pair{
        int time;
        String value;

        Pair(int time, String value){
            this.time = time;
            this.value = value;
        }
    }
}
