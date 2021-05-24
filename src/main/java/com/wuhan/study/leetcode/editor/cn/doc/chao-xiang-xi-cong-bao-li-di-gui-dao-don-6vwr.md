### 视频

![...一题系列20210421】版本2.mp4](dfb52cdb-b55f-4f81-bee5-4694ea6da3fd)


### 方法一：暴力递归（超时）

**思路**：

枚举所有可能的解码方案。枚举方法如下：

**第一步**：首先对 1、……、26 一共 26 个数字，可以构建一个编码的字符串集合 `legalstr` 。

**第二步**：对于任意的字符串，依次选择 **开始的 1 个字符** 或者 **开始的 2 个字符** 进行解码。

+ 如果这 1 字符或者 2 个字符在 `legalstr` 中，则表示可以编码，对剩下的字符串执行同样的操作；
+ 如果不合法，就不能生出递归树的枝叶。

当剩余字符串长度为 *0* 的时候就说明完成了解码，给计数器加 *1*。假设字符串长为 *n*，递归树如下图所示：

![91题递归图.png](https://pic.leetcode-cn.com/1618895990-wznVHv-91%E9%A2%98%E9%80%92%E5%BD%92%E5%9B%BE.png)

**代码**：

```Python3 []
class Solution:
    def numDecodings(self, s: str) -> int:
        legalstr = set(str(i) for i in range(1, 27))
        self.ans = 0
        def dfs(s):
            if len(s)==0:
                self.ans += 1
                return 
            # 对于任何一个字符串，我们每次可以读取一到两个
            if s[0] in legalstr:
                dfs(s[1 : ])
            if len(s)>1 and s[ : 2] in legalstr:
                dfs(s[2 : ])
            return
        dfs(s)
        return self.ans
```

+ 时间复杂度 *O(2^n)*；
+ 空间复杂度 *O(n)*。

暴力枚举超时的原因是：不仅计算了结果，还求出了每一种可能的编码，并且在求解问题的过程中，重复计算了子问题（如图中字符串 *S_2S_3...S_n* 和 *S_3...S_n* 至少出现了两次）。

### 方法二：动态规划

**思路**：

**第一步**：确定动态规划 `dp` 数组的定义

设 `dp[i]` 为 `s[0...i]` 字符串有多少种解码方法。动态规划 `dp[i]` 的定义如果是题目所问，则返回的结果就是最后一个状态值 `dp[-1]`。


**第二步**：确定状态转移方程

状态转移方程表示了大规模的问题如何由小规模问题转换而来，即状态转移方程表达了不同规模的子问题之间的关系。所以思考的方向是：此时 `dp[i]` 可以如何利用 `dp[i - 1]`、...、`dp[0]`。



**难点**: 对 2 个字符，可能解码成 0 种、1 种、2 种情况。所以需要进行分类讨论这2个字符什么时候解码成 0 种，什么时候解码成 1种，什么时候解码成 2种。利用我们一开始设置的合法集合（`legalstr`）可以很快的判断出这2个字符连起来是否可解码以及分开时是否可以分别解码的，从而得出解码方案数。分类讨论具体如下：

现在对 `dp[i]` 具体分析：

`s[i]` 不在合法集合中，也就是 `s[i]` 为 `0` 的情况：
- `s[i - 1] + s[i] = s[i - 1: i + 1]` 也不在合法集合中（比如 `00`）：无法解码字符串，直接返回 *0*； 
- `s[i - 1: i + 1]` 在合法集合中（比如10）：`s[i - 1: i + 1]` 只有一种解码可能，**所以 `s[i - 1: i + 1]` 的解码是固定的**，`dp[i] = dp[i - 2]` 也就是 到i的解码方案 = 到i-2的解码方案，因为i-1到i的位置是确定的。

`s[i]`在合法集合中:
- `s[i - 1: i + 1]` 不在合法集合中（比如 `31`）：`s[i - 1: i + 1]` 无法解码，**`s[i]` 单独解码**,所以 `dp[i] = dp[i - 1]`；
- `s[i - 1: i + 1]` 在合法集合中（比如 `21`）：这种时候 `s[i - 1: i + 1]` 可以解码，也可以拆开分别解码，**那么这两种不同的解码会导致之后的整体解码都是不同的**。所以 `dp[i] = dp[i - 2] + dp[i - 1]`。
 
**细节**：由于状态转移方程需要 `dp[i - 2]` ，所以我们初始化的时候要初始化 `dp[0]` 和 `dp[1]` , `dp[1]` 表示两个字符的解码方案，此时有三种可能性，所以也要分类讨论。


**代码**：

```Python3 []
class Solution:
    def numDecodings(self, s: str) -> int:
        if s[0] == '0': return 0
        if len(s) == 1: return 1
 
        legalstr = set(str(i) for i in range(1, 27))
 
        dp = [0] * (len(s))
        dp[0] = 1 
        if s[1] not in legalstr:  # s[1]为0
            dp[1] = 1 if s[ : 2] in legalstr else 0
        else:
             dp[1] = 2 if s[ : 2] in legalstr else 1            
 
        # 因为要用到i-2 所以至少初始化 dp[0] dp[1]
        for i in range(2, len(s)):
            if s[i] not in legalstr:
                if s[i - 1: i + 1] not in legalstr:
                    return 0
                else:
                    dp[i] = dp[i - 2]
            else:
                if s[i - 1: i + 1] in legalstr:
                    dp[i] = dp[i - 1]+dp[i - 2]
                else:
                    dp[i] = dp[i - 1]
        return dp[-1]
```
时间复杂度 *O(n)*
空间复杂度 *O(n)*

#### 改进一：
因为 `dp[1]` 的生成要分类讨论 `s[1]` 和 `s[ : 2]` 的情况，比较繁琐。 所以我选择在开头加一个**虚拟数字** 9(3-9) 不影响结果.这个时候 `dp[0] = 1` , 如果过了一开始的特判 `if s[0] == '0': return 0` ，`dp[1] = 1`.

#### 代码
```python3 []
class Solution:
    def numDecodings(self, s: str) -> int:
        if s[0] == '0': return 0
        if len(s) == 1: return 1
 
        legalstr = set(str(i) for i in range(1, 27))
 
        dp = [0] * (len(s) + 1)
        dp[0] = 1 
        dp[1] = 1
 
        for i in range(1, len(s)):
            if s[i] not in legalstr:
                if s[i - 1: i + 1] not in legalstr:
                    return 0
                else:
                    dp[i + 1] = dp[i - 2 + 1] # 因为dp多了一个，所以集体加1
            else:
                if s[i - 1: i + 1] in legalstr:
                    dp[i + 1] = dp[i - 1 + 1]+dp[i - 2 + 1]
                else:
                    dp[i + 1] = dp[i - 1 + 1]
        return dp[-1]
```
时间复杂度 *O(n)*
空间复杂度 *O(n)*


#### 改进二：
可以有更节省空间的做法，那就是：**滚动数组**。方法就是把上面的`dp[i - 1] dp[i] dp[i + 1]` 换成 `a b c`, 每次循环结束的时候 a 变成 b ， b 变成 c ，也就是滚动起来。
```python3 []
class Solution:
    def numDecodings(self, s: str) -> int:
        if s[0] == '0':return 0
        if len(s) == 1:return 1
 
        legalstr = set(str(i) for i in range(1, 27))
 
        a = 1 
        b = 1
 
        for i in range(1, len(s)):
            if s[i] not in legalstr:
                if s[i - 1: i + 1] not in legalstr:
                    return 0
                else:
                    c = a 
            else:
                if s[i - 1: i + 1] in legalstr:
                    c = b+a
                else:
                    c = b
            a = b
            b = c # 滚动起来
        return c  
```
时间复杂度 *O(n)*
空间复杂度 *O(1)*

