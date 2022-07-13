package fakru.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class LC355 {

}

class Twitter {

  Map<Integer, User> userMap;

  public Twitter() {
    userMap = new HashMap<>();
  }

  /**
   * Compose a new tweet.
   */
  public void postTweet(int userId, int tweetId) {
    userMap.computeIfAbsent(userId, x -> new User(userId));
    userMap.get(userId).postTweet(tweetId);
  }

  /**
   * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must
   * be posted by users who the user followed or by the user herself. Tweets must be ordered from
   * most recent to least recent.
   */
  public List<Integer> getNewsFeed(int userId) {
    List<Integer> result = new ArrayList<>();
    if (!userMap.containsKey(userId)) {
      return result;
    }
    Set<Integer> userIds = userMap.get(userId).followed;
    PriorityQueue<Tweet> pq =
        new PriorityQueue<>(userIds.size(), (a, b) -> b.time - a.time);
    for (int user : userIds) {
      Tweet t = userMap.get(user).tweetHead;
      if (t != null) {
        pq.add(t);
      }
    }
    int n = 0;
    while (!pq.isEmpty() && n++ < 10) {
      Tweet t = pq.poll();
      result.add(t.id);
      if (t.next != null) {
        pq.add(t.next);
      }
    }
    return result;
  }

  /**
   * Follower follows a followee. I(follower) follow suriya, dhanush (followee). If the operation is
   * invalid, it should be a no-op.
   */
  public void follow(int followerId, int followeeId) {
    userMap.computeIfAbsent(followerId, x -> new User(followerId));
    userMap.computeIfAbsent(followeeId, x -> new User(followeeId));
    userMap.get(followerId).follow(followeeId);
  }

  /**
   * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
   */
  public void unfollow(int followerId, int followeeId) {
    userMap.computeIfAbsent(followerId, x -> new User(followerId));
    userMap.computeIfAbsent(followeeId, x -> new User(followeeId));
    userMap.get(followerId).unfollow(followeeId);
  }

  static class User {

    int id;
    Tweet tweetHead;
    // the persons I'm following
    Set<Integer> followed;

    User(int id) {
      this.id = id;
      this.followed = new HashSet<>();
      this.tweetHead = null;
      follow(id);
    }

    public void postTweet(int tweetId) {
      Tweet t = new Tweet(tweetId);
      t.next = tweetHead;
      tweetHead = t;
    }

    public void follow(int id) {
      followed.add(id);
    }

    public void unfollow(int id) {
      followed.remove(id);
    }
  }

  private static int timestamp = 0;

  static class Tweet {

    int id;
    int time;
    Tweet next;

    Tweet(int id) {
      this.id = id;
      this.time = timestamp++;
      this.next = null;
    }
  }
}