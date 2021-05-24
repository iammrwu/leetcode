### 解题思路
**设计思想**
基础的动态规划问题，大致思路如下：
由于每次只能往下或者往右走，那么当走到一个新的方格时，所需的步数即为上一格的步数再加上当前格子的步数即可。
因为要找到最短的路径，那么我们只需把当前格子的上边一格或者左边一格的最小值求出来，即可得到答案。（如图）
**优化原则**
边界条件：原数组的大小，特殊情况要注意，避免越界。
初始状态：dp[0][0] = grid[0][0];
状态转移方程：dp[i][j] = grid[i][j] + Math.min(dp[i-1][j],dp[i][j-1]);
**大致流程**
![1.png](https://pic.leetcode-cn.com/1618025196-MDRLFU-1.png)
![3.png](https://pic.leetcode-cn.com/1618025202-BGHULC-3.png)
![5.png](https://pic.leetcode-cn.com/1618025206-CFwyfl-5.png)
![7.png](https://pic.leetcode-cn.com/1618025210-whYkqc-7.png)


### 代码

```java
class Solution {
    public int minPathSum(int[][] grid) {
        //n,m代表行长和列长
        int n = grid.length;
        int m = grid[0].length;
        //当只有一格的时候，直接返回
        if(n == 1 && m == 1)
            return grid[0][0];
        //定义状态转移方程，初始状态为grid[0]
        int[][] dp = new int[n][m];
        dp[0][0] = grid[0][0];
        //先行后列，逐行遍历
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                //当为边界时，直接为上一个值相加
                if(i == 0 || j == 0){
                    if(j != 0)
                        dp[0][j] = grid[0][j] + dp[0][j-1];
                    else if(i != 0)
                        dp[i][0] = grid[i][0] + dp[i-1][0];
                }
                //当不为边界时，当前最优方格解为grid[i][j]加上上一个方格或者左边方格的值
                else  
                    dp[i][j] = grid[i][j] + Math.min(dp[i-1][j],dp[i][j-1]);  
            }
        }
        return dp[n-1][m-1];
    }
}
```