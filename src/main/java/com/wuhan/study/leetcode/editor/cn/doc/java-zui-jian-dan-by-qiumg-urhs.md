### 解题思路
此处撰写解题思路

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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
          Queue<TreeNode> queue=new LinkedList<>();
        List<List<Integer>> lists= new ArrayList<>();
        if(root != null){
            queue.add(root);
        }

        while(!queue.isEmpty()){
            List<Integer> list=new ArrayList<>();
            for(int i=queue.size();i>0;i--){
                TreeNode tmp = queue.poll();
                list.add(tmp.val);
                if(tmp.left != null){
                    queue.add(tmp.left);
                }
                if(tmp.right != null){
                    queue.add(tmp.right);
                }
            }
            lists.add(list);
        }
        Collections.reverse(lists);
        return lists;

    }
}
```