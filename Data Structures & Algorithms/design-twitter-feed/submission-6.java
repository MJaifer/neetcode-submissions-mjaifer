class Twitter {
    private Map<Integer, User> userMap;
    private int timestamp;
    public Twitter() {
        userMap = new HashMap<>();
        timestamp = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        User user = getOrCreateUser(userId);
        user.post(tweetId, timestamp);
        timestamp++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();
        User user = userMap.get(userId);
        if (user == null) {
            return feed;
        }

        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.timestamp, a.timestamp));
        Set<Integer> followedUsers = user.getFollowed();

        for (int followed: followedUsers) {
            User followedUser = userMap.get(followed);
            if (followedUser == null || followedUser.getTweetHead() == null) continue;

            pq.add(followedUser.getTweetHead());
        }

        while (!pq.isEmpty()) {
            Tweet tweet = pq.remove();
            feed.add(tweet.getId());
            if (feed.size() == 10) break;

            Tweet next = tweet.getNext();
            if (next != null) {
                pq.add(next);
            }
        }

        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        // The user with ID followerId follows the user with ID followeeId.
        User user = getOrCreateUser(followerId);
        user.follow(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        User user = getOrCreateUser(followerId);
        user.unfollow(followeeId);
    }

    private User getOrCreateUser(int userId) {
        return userMap.computeIfAbsent(userId, k -> new User(k));
    }
}

/**
* owns Tweet, followed users
*/
class User {
    private int id;
    private Set<Integer> followed;
    private Tweet tweetHead;

    public User(int id) {
        this.id = id;
        followed = new HashSet<>();
        followed.add(id);
        tweetHead = null;
    }

    public void follow(int followeeId) {
        followed.add(followeeId);
    }

    public void unfollow(int followeeId) {
        followed.remove(followeeId);
    }

    public void post(int tweetId, int timestamp) {
        Tweet newTweet = new Tweet(tweetId, timestamp);
        if (tweetHead == null) {
            tweetHead = newTweet;
            return;
        }
        tweetHead.add(newTweet);
        tweetHead = newTweet;
    }

    public int getId() { return id; }
    public Set<Integer> getFollowed() { return followed; }
    public Tweet getTweetHead() { return tweetHead; }
}


class Tweet {
    private final int timestamp;
    private final int id;
    private Tweet next;

    public Tweet(int id, int timestamp) {
        this.id = id;
        this.timestamp = timestamp;
        next = null;
    }

    // add tweet as the previous of this tweet
    public void add(Tweet tweet) {
        tweet.next = this;
    }

    public int getTimestamp() { return timestamp; }
    public int getId() { return id; }
    public Tweet getNext() { return next; }
}
