import java.util.*;
class Solution {
    public int[] solution(String s) {
        String[] sArr = s.substring(2,s.length()-2).split("},\\{");
        
        Arrays.sort(sArr, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                return o1.length()-o2.length();
            }
        });
        
        ArrayList<Integer> tmp = new ArrayList<>();
        for(String ss:sArr){
            String[] nums = ss.split(",");
            
            for(String n:nums){
                if(!tmp.contains(Integer.valueOf(n))){
                    tmp.add(Integer.valueOf(n));
                }
            }
        }
        
        int[] answer = new int[tmp.size()];
        for(int i=0;i<tmp.size();i++){
            answer[i] = tmp.get(i);
        }
        return answer;
    }
}