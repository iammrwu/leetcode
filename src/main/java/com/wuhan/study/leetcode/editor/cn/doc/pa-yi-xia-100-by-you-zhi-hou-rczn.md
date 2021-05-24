### 解题思路
dfs回溯求解

### 代码

```java
class Solution {
    //dfs回溯求解
    //时间复杂度O(3^m×4^n),空间复杂度O(m+n)
    List<String> ans = new LinkedList<>();
    
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return ans;
        getStringList(digits, 0, digits.length(), new StringBuilder());
        return ans;
    }
    
    public char getCharByNum(int num, int flag){
        int index = 0;
        if(num <= 7){
            index = (num - 2) * 3 + flag;
        }else if(num == 8){
            index = 19 + flag;
        }else{
            index = 22 + flag;
        }
        char ch = (char)(index + 'a');
        return ch;
    }
    
    public void getStringList(String digits, int index, int length, StringBuilder ret){
        if(index == length){
            ans.add(ret.toString());
            return;
        }
        int num = digits.charAt(index) - '0';
        for(int j = 0; j < 4; j++){
            if(j == 3 && num != 7 && num != 9){
                break;
            }
            ret.append(getCharByNum(num, j));
            getStringList(digits, index + 1, length, ret);
            ret.deleteCharAt(index);
        }
    }
}
```