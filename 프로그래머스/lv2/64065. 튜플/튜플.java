import java.util.*;
class Solution {
    public int[] solution(String s) {
        String[] sArr = s.substring(2,s.length()-2).split("},\\{");
        int[] answer = new int[sArr.length];
        
        Arrays.sort(sArr, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                return o1.length()-o2.length();
            }
        });
        
        int i=0;
        HashSet<Integer> set = new HashSet<>();
        for(String ss:sArr){
            String[] nums = ss.split(",");
            
            for(String n:nums){
                if(set.add(Integer.valueOf(n)))
                    answer[i++]=Integer.valueOf(n);
            }
        }
        
        return answer;
    }
}