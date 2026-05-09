class Twitter {
    int timestamp;
    Map<Integer, Queue<int[]>> tweets;
    Map<Integer, Set<Integer>> followerMap;
    public Twitter() {
        this.tweets = new HashMap<>();
        this.followerMap = new HashMap<>();
        timestamp = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        int[] tweetPair = new int[] {tweetId, timestamp++};
        Queue<int[]> tweetsByUser = tweets.computeIfAbsent(userId, k -> new LinkedList<>());
        tweetsByUser.add(tweetPair);

        // if tweet size grows more than 10, remove the oldest tweet
        if (tweetsByUser.size() > 10) {
            tweetsByUser.remove();
        }

        this.follow(userId, userId);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();
        Set<Integer> followers = followerMap.get(userId);
        if (followers == null) {
            return feed;
        }

        Queue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        for (int follower: followers) {
            Queue<int[]> tweetsByUser = tweets.get(follower);
            if (tweetsByUser == null) continue;

            for (int[] t: tweetsByUser) {
                pq.add(t);
                if (pq.size() > 10) {
                    pq.remove();
                }
            }
        }
        while (!pq.isEmpty()) {
            feed.add(pq.remove()[0]);
        }
        Collections.reverse(feed);
        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        followerMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) return;

        Set<Integer> followers = followerMap.get(followerId);
        if (followers == null) {
            return;
        }        
        followers.remove(followeeId);
    }
}
