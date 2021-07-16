### 解题思路
![WechatIMG117.png](https://pic.leetcode-cn.com/1621485061-gUPusv-WechatIMG117.png)

由于栈里边存储的是倒序的节点访问顺序,所以先访问的节点的子节点一定是下层节点最后才能访问到的,所以往队列添加的时候,相当于栈的顺序存放
(即头插法),  注意子节点左右顺序
                    
```
TreeNode curNode = stack.poll();
if(curNode.right!=null){
    queue.addFirst(curNode.right);
}
if(curNode.left!=null){
    queue.addFirst(curNode.left);
}
```
队列里边存储的是正常的访问顺序,所以先访问的节点的子节点一定是下层最后访问到的,注意子节点的左右顺序
```
TreeNode curNode = queue.poll();
if(curNode.left!=null){
    stack.push(curNode.left);
}
if(curNode.right!=null){
    stack.push(curNode.right);
}
```

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
         List<List<Integer>> ret = new ArrayList<>();
        if(root==null){
            return ret;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        Deque<TreeNode> stack = new ArrayDeque<>();

        queue.add(root);
        int level =1;///层数为奇数时，正常顺序遍历,层数为偶数,倒序遍历
        while (!queue.isEmpty()||!stack.isEmpty()){

            boolean isOrder = (level&1)==1;
            int n =isOrder?queue.size():stack.size();
            List<Integer> sub = new ArrayList<>();
            for(int i=0;i<n;i++){


                if(isOrder){
                    TreeNode curNode = queue.poll();
                    sub.add(curNode.val);
                    if(curNode.left!=null){
                        stack.push(curNode.left);
                    }
                    if(curNode.right!=null){
                        stack.push(curNode.right);
                    }
                }else{
                    TreeNode curNode = stack.poll();
                    sub.add(curNode.val);
                    if(curNode.right!=null){
                        queue.addFirst(curNode.right);
                    }
                    if(curNode.left!=null){
                        queue.addFirst(curNode.left);
                    }

                }
            }
            level++;
            ret.add(sub);
        }
        return ret;
    }
}
```