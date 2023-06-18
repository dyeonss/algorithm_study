import java.util.*;

class Solution {
    public long solution(long n) {
        char[] str= Long.toString(n).toCharArray();
        Arrays.sort(str);
        StringBuilder sb = new StringBuilder();
        return Long.parseLong(sb.append(str).reverse().toString());
    }
}