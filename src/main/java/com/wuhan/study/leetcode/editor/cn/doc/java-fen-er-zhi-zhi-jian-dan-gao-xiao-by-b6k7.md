### 解题思路
本题解 使用了 **`分治`** 的思想：
> 将 连续的数，一个个遍历，作为根节点，
> 每次遍历中，将 左边的数组 和 右边的数组 分别进行构建子树，并接到 当前根节点上

### 运行结果
![image.png](https://pic.leetcode-cn.com/1618731737-VDUYYa-image.png)

### 代码

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> curRes = new LinkedList<TreeNode>();
        if (start > end) {
            curRes.add(null);
            return curRes;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftNodeList = generateTrees(start, i - 1);
            List<TreeNode> rightNodeList = generateTrees(i + 1, end);

            for (TreeNode leftNode : leftNodeList) {
                for (TreeNode rightNode : rightNodeList) {
                    curRes.add(new TreeNode(i, leftNode, rightNode));
                }
            }
        }

        return curRes;
    }

}
```
打卡189天，加油！！！
继续肝题解ing...