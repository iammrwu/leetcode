### ðº è§é¢é¢è§£  

![355 è®¾è®¡æ¨ç¹-ä»²èæ.mp4](262540fb-dfbf-4220-a8b9-504f0151d287)

### ð æå­é¢è§£

#### æ¹æ³ä¸ï¼åå¸è¡¨ + é¾è¡¨

**æè·¯åç®æ³**

æ ¹æ®é¢ææä»¬ç¥éï¼å¯¹äºæ¯ä¸ªæ¨ç¹ç¨æ·ï¼æä»¬éè¦å­å¨ä»å³æ³¨çç¨æ· `Id`ï¼ä»¥åèªå·±åçæ¨æ `Id` çéåï¼ä¸ºäºä½¿æ¯ä¸ªæä½çå¤æåº¦å°½å¯è½çä½ï¼æä»¬éè¦æ ¹æ®æä½æ¥å³å®å­å¨è¿äºä¿¡æ¯çæ°æ®ç»æãæ³¨æï¼ç±äºé¢ç®ä¸­æ²¡æè¯´æç¨æ·ç `Id` æ¯å¦è¿ç»­ï¼æä»¥æä»¬éè¦ç¨ä¸ä¸ªä»¥ç¨æ· `Id` ä¸ºç´¢å¼çåå¸è¡¨æ¥å­å¨ç¨æ·çä¿¡æ¯ã

å¯¹äºæä½ `3` åæä½ `4`ï¼æä»¬åªéè¦ç¨ä¸ä¸ªåå¸è¡¨å­å¨ï¼å³å¯å®ç°æå¥åå é¤çæ¶é´å¤æåº¦é½ä¸º *O(1)*ã

å¯¹äºæä½ `1` åæä½ `2`ï¼ç±äºæä½ `2` è¦ç¥éæ­¤ç¨æ·å³æ³¨çäººåç¨æ·èªå·±ååºçæè¿åæ¡æ¨æï¼å æ­¤æä»¬å¯ä»¥èèå¯¹æ¯ä¸ªç¨æ·ç¨é¾è¡¨å­å¨åéçæ¨æãæ¯æ¬¡åå»ºæ¨æçæ¶åæä»¬å¨é¾è¡¨å¤´æå¥ï¼è¿æ ·è½ä¿è¯é¾è¡¨éå­å¨çæ¨æçæ¶é´æ¯ä»æè¿å°æä¹çãé£ä¹å¯¹äºæä½ `2`ï¼é®é¢å¶å®å°±ç­ä»·äºæè¥å¹²ä¸ªæåºçé¾è¡¨ï¼æä»¬éè¦æ¾å°å®ä»¬åèµ·æ¥æè¿çåæ¡æ¨æãç±äºé¾è¡¨éå­å¨çæ°æ®é½æ¯æåºçï¼æä»¥æä»¬å°è¿äºé¾è¡¨è¿è¡çº¿æ§å½å¹¶å³å¯å¾å°æè¿çåæ¡æ¨æãè¿ä¸ªæä½ä¸ [23. åå¹¶Kä¸ªæåºé¾è¡¨](https://leetcode-cn.com/problems/merge-k-sorted-lists/) åºæ¬ç­åã

![fig1](https://assets.leetcode-cn.com/solution-static/355_fig1.png)

å¦ææä»¬ç´æ¥ç§æ¬ãåå¹¶Kä¸ªæåºé¾è¡¨ãçè§£æ³æ¥è¿è¡åå¹¶ï¼é£ä¹æ çä¼é æç©ºé´çé¨åæµªè´¹ï¼å ä¸ºè¿ä¸ªé¢ç®ä¸è¦æ±ä½ å±ç¤ºç¨æ·çæææ¨æï¼æä»¥æä»¬åªè¦å¨æç»´æ¤ç¨æ·çé¾è¡¨ï¼å­å¨æè¿ç `recentMax` ä¸ªæ¨æ `Id` å³å¯ï¼é¢ç®ä¸­ç `recentMax` ä¸º `10`ï¼ãé£ä¹å¯¹äºæä½ `1`ï¼å½åç°é¾è¡¨çèç¹æ°ç­äº `recentMax` æ¶ï¼æä»¬æé¢æå é¤é¾è¡¨æ«å°¾çåç´ ï¼åæå¥ææ°çæ¨æ `Id`ãå¯¹äºæä½ `2`ï¼å¨ä¸¤ä¸ªé¾è¡¨è¿è¡çº¿æ§å½å¹¶çæ¶åï¼åªè¦å·²åå¹¶çæ°éç­äº `recentMax`ï¼ä»£è¡¨å·²ç»æ¾å°è¿ä¸¤ä¸ªé¾è¡¨åèµ·æ¥åæè¿ç `recentMax` æ¡æ¨æï¼ç´æ¥ç»æåå¹¶å³å¯ã

```C++ [sol1-C++]
class Twitter {
    struct Node {
        // åå¸è¡¨å­å¨å³æ³¨äººç Id
        unordered_set<int> followee;
        // ç¨é¾è¡¨å­å¨ tweetId
        list<int> tweet;
    };
    // getNewsFeed æ£ç´¢çæ¨æçä¸éä»¥å tweetId çæ¶é´æ³
    int recentMax, time;
    // tweetId å¯¹åºåéçæ¶é´
    unordered_map<int, int> tweetTime;
    // æ¯ä¸ªç¨æ·å­å¨çä¿¡æ¯
    unordered_map<int, Node> user;
public:
    Twitter() {
        time = 0;
        recentMax = 10;
        user.clear();
    }
    
    // åå§å
    void init(int userId) {
        user[userId].followee.clear();
        user[userId].tweet.clear();
    }

    void postTweet(int userId, int tweetId) {
        if (user.find(userId) == user.end()) {
            init(userId);
        }
        // è¾¾å°éå¶ï¼åé¤é¾è¡¨æ«å°¾åç´ 
        if (user[userId].tweet.size() == recentMax) {
            user[userId].tweet.pop_back();
        }
        user[userId].tweet.push_front(tweetId);
        tweetTime[tweetId] = ++time;
    }
    
    vector<int> getNewsFeed(int userId) {
        vector<int> ans; ans.clear();
        for (list<int>::iterator it = user[userId].tweet.begin(); it != user[userId].tweet.end(); ++it) {
            ans.emplace_back(*it);
        }
        for (int followeeId: user[userId].followee) {
            if (followeeId == userId) continue; // å¯è½åºç°èªå·±å³æ³¨èªå·±çæåµ
            vector<int> res; res.clear();
            list<int>::iterator it = user[followeeId].tweet.begin();
            int i = 0;
            // çº¿æ§å½å¹¶
            while (i < (int)ans.size() && it != user[followeeId].tweet.end()) {
                if (tweetTime[(*it)] > tweetTime[ans[i]]) {
                    res.emplace_back(*it);
                    ++it;
                } else {
                    res.emplace_back(ans[i]);
                    ++i;
                }
                // å·²ç»æ¾å°è¿ä¸¤ä¸ªé¾è¡¨åèµ·æ¥åæè¿ç recentMax æ¡æ¨æ
                if ((int)res.size() == recentMax) break;
            }
            for (; i < (int)ans.size() && (int)res.size() < recentMax; ++i) res.emplace_back(ans[i]);
            for (; it != user[followeeId].tweet.end() && (int)res.size() < recentMax; ++it) res.emplace_back(*it);
            ans.assign(res.begin(),res.end());
        }
        return ans;
    }
    
    void follow(int followerId, int followeeId) {
        if (user.find(followerId) == user.end()) {
            init(followerId);
        }
        if (user.find(followeeId) == user.end()) {
            init(followeeId);
        }
        user[followerId].followee.insert(followeeId);
    }
    
    void unfollow(int followerId, int followeeId) {
        user[followerId].followee.erase(followeeId);
    }
};
```

```Java [sol1-Java]
class Twitter {
    private class Node {
        // åå¸è¡¨å­å¨å³æ³¨äººç Id
        Set<Integer> followee;
        // ç¨é¾è¡¨å­å¨ tweetId
        LinkedList<Integer> tweet;

        Node() {
            followee = new HashSet<Integer>();
            tweet = new LinkedList<Integer>();
        }
    }

    // getNewsFeed æ£ç´¢çæ¨æçä¸éä»¥å tweetId çæ¶é´æ³
    private int recentMax, time;
    // tweetId å¯¹åºåéçæ¶é´
    private Map<Integer, Integer> tweetTime;
    // æ¯ä¸ªç¨æ·å­å¨çä¿¡æ¯
    private Map<Integer, Node> user;

    public Twitter() {
        time = 0;
        recentMax = 10;
        tweetTime = new HashMap<Integer, Integer>();
        user = new HashMap<Integer, Node>();
    }

    // åå§å
    public void init(int userId) {
        user.put(userId, new Node());
    }

    public void postTweet(int userId, int tweetId) {
        if (!user.containsKey(userId)) {
            init(userId);
        }
        // è¾¾å°éå¶ï¼åé¤é¾è¡¨æ«å°¾åç´ 
        if (user.get(userId).tweet.size() == recentMax) {
            user.get(userId).tweet.remove(recentMax - 1);
        }
        user.get(userId).tweet.addFirst(tweetId);
        tweetTime.put(tweetId, ++time);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        LinkedList<Integer> ans = new LinkedList<Integer>();
        for (int it : user.getOrDefault(userId, new Node()).tweet) {
            ans.addLast(it);
        }
        for (int followeeId : user.getOrDefault(userId, new Node()).followee) {
            if (followeeId == userId) { // å¯è½åºç°èªå·±å³æ³¨èªå·±çæåµ
                continue;
            }
            LinkedList<Integer> res = new LinkedList<Integer>();
            int tweetSize = user.get(followeeId).tweet.size();
            Iterator<Integer> it = user.get(followeeId).tweet.iterator();
            int i = 0;
            int j = 0;
            int curr = -1;
            // çº¿æ§å½å¹¶
            if (j < tweetSize) {
                curr = it.next();
                while (i < ans.size() && j < tweetSize) {
                    if (tweetTime.get(curr) > tweetTime.get(ans.get(i))) {
                        res.addLast(curr);
                        ++j;
                        if (it.hasNext()) {
                            curr = it.next();
                        }
                    } else {
                        res.addLast(ans.get(i));
                        ++i;
                    }
                    // å·²ç»æ¾å°è¿ä¸¤ä¸ªé¾è¡¨åèµ·æ¥åæè¿ç recentMax æ¡æ¨æ
                    if (res.size() == recentMax) {
                        break;
                    }
                }
            }
            for (; i < ans.size() && res.size() < recentMax; ++i) {
                res.addLast(ans.get(i));
            }
            if (j < tweetSize && res.size() < recentMax) {
                res.addLast(curr);
                for (; it.hasNext() && res.size() < recentMax;) {
                    res.addLast(it.next());
                }
            }
            ans = new LinkedList<Integer>(res);
        }
        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        if (!user.containsKey(followerId)) {
            init(followerId);
        }
        if (!user.containsKey(followeeId)) {
            init(followeeId);
        }
        user.get(followerId).followee.add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        user.getOrDefault(followerId, new Node()).followee.remove(followeeId);
    }
}
```

```Python [sol1-Python3]
class Twitter:

    class Node:
        def __init__(self):
            self.followee = set()
            self.tweet = list()

    def __init__(self):
        self.time = 0
        self.recentMax = 10
        self.tweetTime = dict()
        self.user = dict()

    def postTweet(self, userId: int, tweetId: int) -> None:
        if userId not in self.user:
            self.user[userId] = Twitter.Node()
        self.user[userId].tweet.append(tweetId)
        self.time += 1
        self.tweetTime[tweetId] = self.time

    def getNewsFeed(self, userId: int) -> List[int]:
        if userId not in self.user:
            return list()
        ans = self.user[userId].tweet[-10:][::-1]
        for followeeId in self.user[userId].followee:
            if followeeId in self.user:
                opt = self.user[followeeId].tweet[-10:][::-1]
                i, j, combined = 0, 0, list()
                while i < len(ans) and j < len(opt):
                    if self.tweetTime[ans[i]] > self.tweetTime[opt[j]]:
                        combined.append(ans[i])
                        i += 1
                    else:
                        combined.append(opt[j])
                        j += 1
                combined.extend(ans[i:])
                combined.extend(opt[j:])
                ans = combined[:10]
        return ans

    def follow(self, followerId: int, followeeId: int) -> None:
        if followerId != followeeId:
            if followerId not in self.user:
                self.user[followerId] = Twitter.Node()
            self.user[followerId].followee.add(followeeId)
            
    def unfollow(self, followerId: int, followeeId: int) -> None:
        if followerId != followeeId:
            if followerId in self.user:
                self.user[followerId].followee.discard(followeeId)
```

**å¤æåº¦åæ**

- æ¶é´å¤æåº¦ï¼
	
	- æä½ `1` ï¼ *O(1)*ï¼é¾è¡¨çæå¥å é¤ä¸º *O(1)* çå¤æåº¦ã
	
	- æä½ `2` ï¼ ![O(\textit{recentMax}*num) ](./p__O_textit{recentMax}*num__.png) ï¼å¶ä¸­ `recentMax = 10`ï¼ `num` ä¸ºç¨æ·å³æ³¨çäººå ä¸èªå·±çæ°éåãå ä¸ºé¾è¡¨éæå¤å­å¨ `recentMax` ä¸ªèç¹ï¼å æ­¤æ¯æ¬¡åå¹¶ä¸¤ä¸ªé¾è¡¨æå¤æ¯è¾ `recentMax` æ¬¡åè½å¾å°ä¸¤ä¸ªé¾è¡¨æè¿ç `recentMax` ä¸ªæ¨æï¼ä¸å±éè¦åå¹¶ `num` æ¬¡ï¼å æ­¤æ»æ¶é´å¤æåº¦ä¸º ![O(\textit{recentMax}*num) ](./p__O_textit{recentMax}*num__.png) ã
	
	- æä½ `3` ï¼ *O(1)*ï¼åå¸è¡¨æå¥ä¸º *O(1)* çå¤æåº¦ã
	
	- æä½ `4` ï¼ *O(1)*ï¼åå¸è¡¨æå¥ä¸º *O(1)* çå¤æåº¦ã

- ç©ºé´å¤æåº¦ï¼![O(\textit{recentMax}*tot) ](./p__O_textit{recentMax}*tot__.png) ï¼å¶ä¸­ `recentMax = 10`ï¼`tot` ä¸ºæ¨ç¹æ»ç¨æ·æ°ãå³å¯¹äºæ¯ä¸ªç¨æ·æä»¬ä¸ä¼å­å¨è¶è¿ `recentMax` ä¸ªæ¨ç¹ `Id`ï¼æä»¥ç©ºé´ä¸éä¸º ![O(\textit{recentMax}*tot) ](./p__O_textit{recentMax}*tot__.png) ã