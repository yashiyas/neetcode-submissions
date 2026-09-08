class Twitter {

    Map<Integer,List<Integer>> userFollowingMap;
    Map<Integer,List<Tweet>> userTweetsMap;
    Integer time;

    public Twitter() {

        this.userFollowingMap = new HashMap();
        this.userTweetsMap = new HashMap();
        this.time = 0;
        
    }
    
    public void postTweet(int userId, int tweetId) {

        Tweet tweet = new Tweet(tweetId, time);
        time++;
        List<Tweet> tweetList = userTweetsMap.getOrDefault(userId, new ArrayList());
        if(tweetList.size() == 10){
            tweetList.remove(0);
        }
        tweetList.add(tweet);
        userTweetsMap.put(userId, tweetList);
        
    }
    
    public List<Integer> getNewsFeed(int userId) {

        PriorityQueue<Tweet> pq = new PriorityQueue();
        List<Integer> following = userFollowingMap.getOrDefault(userId, new ArrayList());
        if(!following.contains(userId)){
            following.add(userId);
        }
        for(int i=0; i<following.size(); i++){
            Integer u = following.get(i);
            List<Tweet> tweets = userTweetsMap.getOrDefault(u, new ArrayList());
            for(int j=tweets.size()-1; j>=0; j--){
                Tweet currTweet = tweets.get(j);
                if(pq.size() < 10){
                    pq.offer(currTweet);
                } else{
                    Tweet top = pq.peek();
                    if(top.time >= currTweet.time){
                        break;
                    }
                    else{
                        pq.poll();
                        pq.offer(currTweet);
                    }
                }
            }
        }

        List<Integer> ans = new ArrayList();
        for(int i=0; i<pq.size(); i++){
            ans.add(0);
        }
        int i=pq.size()-1;
        while(!pq.isEmpty()){
            ans.set(i,pq.poll().id);
            i--;

        }

        return ans;
        
    }
    
    public void follow(int followerId, int followeeId) {

        List<Integer> followingList = userFollowingMap.getOrDefault(followerId, new ArrayList());
        if(!followingList.contains(followeeId)){
            followingList.add(followeeId);
            userFollowingMap.put(followerId, followingList);
        }
    
        
    }
    
    public void unfollow(int followerId, int followeeId) {

        List<Integer> followingList = userFollowingMap.getOrDefault(followerId, new ArrayList());
        if(!followingList.isEmpty() && followingList.contains(followeeId)){
            followingList.remove((Integer)followeeId);
            userFollowingMap.put(followerId, followingList);
        }
        
    }

    class Tweet implements Comparable<Tweet>{
        Integer id;
        Integer time;

        Tweet(Integer id,Integer time){
            this.id = id;
            this.time = time;
        }

        @Override
        public int compareTo(Tweet t2){
            return this.time - t2.time;
        }
    }
}
