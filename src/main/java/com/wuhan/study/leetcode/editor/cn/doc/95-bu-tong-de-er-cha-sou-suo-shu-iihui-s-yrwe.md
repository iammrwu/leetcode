### 解题思路
回溯法，思路全在代码和注释中了。简单易懂，如果对你有帮助请点赞。

### 代码

```java
class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new LinkedList<>();
        return generateTrees(1, n);
    }

    //回溯生成所有根节点值在[start, end]间的树
    public List<TreeNode> generateTrees(int start, int end){
        List<TreeNode> allTrees = new LinkedList<>();
        //此时应该生成空节点
        if(start > end){
            allTrees.add(null);
            return allTrees;
        }
        //对每个值为i的根节点，其左右子树的根节点的值分别在[start, i - 1]和[i + 1, end]范围内
        for(int i = start; i <= end; i++){
            //递归生成所有可能的二叉搜索左右子树
            List<TreeNode> leftTrees = generateTrees(start, i - 1);
            List<TreeNode> rightTrees = generateTrees(i + 1, end);
            //枚举所有左右子树的组合生成合法的二叉搜索树
            for(TreeNode left: leftTrees){
                for(TreeNode right: rightTrees){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    allTrees.add(root);
                }
            }
        }
        return allTrees;
    }
}
```