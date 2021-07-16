### 解题思路
这题是之前的二叉树的层次遍历的变形题，我们可以发现，我们只要每次在偶数层反转我们那层的答案就能够得到我们的锯齿形层序遍历的结果

### 代码

```java
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();    
        Deque<TreeNode> deque = new LinkedList<>();
        if(root != null)
            deque.add(root);
        boolean k = false;  //判断是否在偶数层，初始为第一层，默认为false
        while(!deque.isEmpty()) {
            List<Integer> t = new ArrayList<>();
            for(int i = deque.size(); i > 0; i--) {
                TreeNode node = deque.poll();
                t.add(node.val);
                if(node.left != null) 
                    deque.add(node.left);
                if(node.right != null)
                    deque.add(node.right);
            }
            if(k)   //如果是偶数层则反转
                Collections.reverse(t);
            k = !k; //奇数变偶数，偶数变奇数
            ans.add(t);
        }
        return ans;
    }
}
```
### 复杂度分析
- 时间复杂度：O(n)
- 空间复杂度：O(n)