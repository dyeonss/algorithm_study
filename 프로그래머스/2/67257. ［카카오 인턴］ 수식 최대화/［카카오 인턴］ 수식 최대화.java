import java.util.*;
class Solution {
    public long solution(String expression) {
        long answer = 0;
        int start=0;
        ArrayList<Character> ops=new ArrayList<>();
        ArrayList<Long> nums=new ArrayList<>();
        String[] calc={"+-*","+*-","-+*","-*+","*+-","*-+"};
        
        for(int i=0;i<expression.length();i++){
            if(expression.charAt(i)=='+'||expression.charAt(i)=='-'||expression.charAt(i)=='*'){
                ops.add(expression.charAt(i));
                nums.add(Long.valueOf(expression.substring(start,i)));
                start=i+1;
            }
        }
        nums.add(Long.valueOf(expression.substring(start)));
        
        for(int i=0;i<6;i++){
            ArrayList<Character> opsC=new ArrayList<>(ops);
            ArrayList<Long> numsC=new ArrayList<>(nums);
            for(char c:calc[i].toCharArray()){
                for(int j=0;j<opsC.size();j++){
                    if(c==opsC.get(j)){
                        if(c=='+'){
                            numsC.set(j,numsC.get(j)+numsC.get(j+1));
                            numsC.remove(j+1);
                        }else if(c=='-'){
                            numsC.set(j,numsC.get(j)-numsC.get(j+1));
                            numsC.remove(j+1);
                        }else{
                            numsC.set(j,numsC.get(j)*numsC.get(j+1));
                            numsC.remove(j+1);
                        }
                        opsC.remove(j);
                        j--;
                    }
                }
            }
            answer=Math.max(answer,Math.abs(numsC.get(0)));
        }
        
        return answer;
    }
}