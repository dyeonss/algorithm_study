import java.util.*;
class Solution {
    public int solution(int[] ingredient) {
        String recipe = "1231";
        int answer = 0;
        StringBuffer sb = new StringBuffer(Arrays.toString(ingredient).replaceAll("[^0-9]",""));
          
        while(sb.indexOf(recipe)>-1){
            int idx = sb.indexOf(recipe);
            answer++;
            sb.delete(idx,idx+4);
        }
        return answer;
    }
}