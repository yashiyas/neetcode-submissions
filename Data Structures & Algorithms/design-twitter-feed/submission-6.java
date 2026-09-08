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

        PriorityQueue<TweetFeed> pq = new PriorityQueue();
        List<Integer> following = userFollowingMap.getOrDefault(userId, new ArrayList());
        if(!following.contains(userId)){
            following.add(userId);
        }
        for(int i=0; i<following.size(); i++){
            Integer u = following.get(i);
            List<Tweet> tweets = userTweetsMap.getOrDefault(u, new ArrayList());
            if(!tweets.isEmpty()){
                Tweet tweet = tweets.get(tweets.size()-1);
                pq.offer(new TweetFeed(tweet.id, tweet.time, u, tweets.size()-1));
            }
            
        }

        List<Integer> ans = new ArrayList();
        while(!pq.isEmpty() && ans.size() < 10){
            TweetFeed tf = pq.poll();
            ans.add(tf.id);
            int index = tf.index - 1 ;
            int user = tf.user;
            if(index >= 0){
                Tweet curr = userTweetsMap.get(user).get(index);
                pq.offer(new TweetFeed(curr.id, curr.time, user, index));
            }
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

    class TweetFeed implements Comparable<TweetFeed>{
        Integer id;
        Integer time;
        Integer user;
        Integer index;

        TweetFeed(Integer id, Integer time, Integer user, Integer index){
            this.id = id;
            this.time = time;
            this.user = user;
            this.index = index;
        }

        @Override
        public int compareTo(TweetFeed tf){
            return tf.time - this.time;
        }
    }
}
