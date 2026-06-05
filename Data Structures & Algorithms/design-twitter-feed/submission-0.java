class Twitter {
    private static int time = 0;

    // userId -> list of tweets
    private Map<Integer, List<Tweet>> tweetMap;

    // userId -> set of followees
    private Map<Integer, Set<Integer>> followMap;

    class Tweet {
        int id;
        int time;

        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    public Twitter() {
        tweetMap = new HashMap<>();
        followMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new Tweet(tweetId, time++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
     List<Integer> result = new ArrayList<>();

        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>(
            (a, b) -> b.time - a.time
        );

        // Ensure user follows themselves
        followMap.putIfAbsent(userId, new HashSet<>());
        followMap.get(userId).add(userId);

        // Add all tweets from self + followees
        for (int followee : followMap.get(userId)) {
            List<Tweet> tweets = tweetMap.get(followee);
            if (tweets != null) {
                for (Tweet t : tweets) {
                    maxHeap.offer(t);
                }
            }
        }

        // Get top 10
        int count = 0;
        while (!maxHeap.isEmpty() && count < 10) {
            result.add(maxHeap.poll().id);
            count++;
        }

        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId) && followeeId != followerId) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}
