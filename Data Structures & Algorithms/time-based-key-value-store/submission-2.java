class TimeMap {

    Map<String, List<Pair>> timeStampMap;

    public TimeMap() {

        this.timeStampMap = new HashMap();
        
    }
    
    public void set(String key, String value, int timestamp) {

        timeStampMap.computeIfAbsent(key, k-> new ArrayList());

        timeStampMap.get(key).add(new Pair(value,timestamp));
        
    }
    
    public String get(String key, int timestamp) {

        if(!timeStampMap.containsKey(key)){
            return "";
        }

        List<Pair> candidates = timeStampMap.get(key);
        int n = candidates.size();

        if(timestamp < candidates.get(0).time){
            return "";
        }

        if(timestamp >= candidates.get(n-1).time){
            return candidates.get(n-1).val;
        }

        int l = 0;
        int r = n-1;

        int index=0;

        while(l <= r && r<n && l>=0 ){
            int mid = (r-l)/2 + l;
            
            int currTime = candidates.get(mid).time;

            if(currTime == timestamp){
                return candidates.get(mid).val;
            }

            if(currTime > timestamp){
                r = mid-1;
            }else{
                index = mid;
                l = mid+1;
            }
        }

        return candidates.get(index).val;
        
    }


    class Pair{
        int time;
        String val;

        Pair(String val, int time){
            this.time = time;
            this.val = val;
        }
    }
}
