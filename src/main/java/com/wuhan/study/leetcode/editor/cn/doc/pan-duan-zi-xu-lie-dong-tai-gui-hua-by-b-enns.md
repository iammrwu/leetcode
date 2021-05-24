# 解题思路

本题与 [最长公共子序列（动态规划：再看）](https://leetcode-cn.com/problems/longest-common-subsequence/solution/zui-chang-gong-gong-zi-xu-lie-dong-tai-g-fhyd/)相似，可以参考。

**动态规划思想是希望连续的，也就是说上一个状态和下一个状态(自变量)之间有关系而且连续。**

因为在找两个字符串中的最长公共子序列时，都是按照从前往后的顺序进行遍历的，找两个字符串的最长公共子序列，若最长公共子序列的长度与字符串 s 的长度相等，则 s 一定是 t 的子序列。

**dp[i][j]：表示字符串 t 的前 i 个元素和字符串 s 的前 j 个元素中公共子序列的长度。**

###### **遍历两个字符串**
**(1) 若当前字符相同**，则找到了一个公共元素，**此时要在原来已经找到当前最长公共子序列的基础上加 1**，即在 f(i - 1)(j - 1) 的基础上加 1，`此时状态转移方程：dp[i][j] = dp[i-1][j-1] + 1`。

**(2) 若当前字符不同**，此时相当于字符串 t 要将当前元素删除，t 如果把当前元素 t[i - 1] 删除，**此时公共子序列的长度就是原来已经求得的公共子序列的长度**，所以 dp[i][j] 的值就是看 s[j - 1] 与 t[i - 2] 的比较结果了，`此时状态转移方程：dp[i][j] = dp[i - 1][j]`。

---
# 代码
```java
class Solution {


    public boolean isSubsequence(String s, String t) {

        int n = s.length();
        int m = t.length();
        if (n > m) return false;

        int[][] dp = new int[m + 1][n + 1];
        for (int i=1;i<=m;i++) {

            for (int j=1;j<=n;j++) {

                if (t.charAt(i - 1) == s.charAt(j - 1)) {

                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {

                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        if (dp[m][n] == n) return true;
        else return false;
    }
}
```
时间复杂度：O(mn)
空间复杂度：O(mn)