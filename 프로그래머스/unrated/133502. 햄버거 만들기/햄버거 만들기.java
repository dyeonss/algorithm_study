import java.util.*;
class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        int idx=0;
        Stack<Integer> stack= new Stack<>();
        
        for(int i=0;i<ingredient.length;i++){
            stack.push(ingredient[i]);  
            idx=stack.size()-1;
            if(stack.size()>=4&&(stack.get(idx)==1&&stack.get(idx-1)==3&&stack.get(idx-2)==2&&stack.get(idx-3)==1)){
                stack.pop();
                stack.pop();
                stack.pop();
                stack.pop();
                answer++;
            }
        }
        return answer;
    }
}