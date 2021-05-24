### 解题思路
此处撰写解题思路

### 代码

```java
class Solution {
    public int[] getNoZeroIntegers(int n) {
        int i = 1;
        a:for( i= 1;i < n;i++){
            int a = i;
            int b = n - i;
            while(a != 0){
                if(a % 10 == 0){
                    continue a;
                }
                a /= 10;
            }
            while(b != 0){
                if(b % 10 == 0){
                    continue a;
                }
                b /= 10; 
            }
            break;
        }
        return new int[]{i,n - i};
    }
}
```