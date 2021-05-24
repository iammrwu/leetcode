### 解题思路
如下：

### 代码

```java
class Solution {
   public List<List<Integer>> threeSum(int[] nums) {

        //防重复
        Set<List<Integer>> sets = new HashSet<>();

        //排序
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            //都为正数则直接不用算了
            if (nums[i] > 0)return new ArrayList<>(sets);
            //当前数与上一个相同则直接下一个
            if (i > 0 && nums[i] == nums[i-1])continue;
            int L = i+1;
            int R = len - 1;
            while (L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[L]);
                    list.add(nums[R]);
                    Collections.sort(list);
                    sets.add(list);
                    L++;
                    R--;
                }else if (sum < 0){
                    L++;
                }else{
                    R--;
                }
            }
        }

        //剔除相同的元素
        return new ArrayList<>(sets);
    }
}
```