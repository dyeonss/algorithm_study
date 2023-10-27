import java.util.*;
class Solution {
    public static HashMap<String, Integer> map;
    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> answer = new ArrayList<>();
        
        for(int i=0;i<course.length;i++){
            int size = course[i];
            map = new HashMap<>();
            for(int j=0;j<orders.length;j++){
                if(orders[j].length()<size) continue;
                char[] ch = orders[j].toCharArray();
                Arrays.sort(ch);
                select(new String(ch),size,"",0,0);
            }
            if(map.size()==0)   continue;
            
            ArrayList<String> arr = new ArrayList<>(map.keySet());
            arr.sort((s1,s2)->map.get(s2)-map.get(s1));
            int max = map.get(arr.get(0));
            if(max<2)   continue;
            
            for(String k:arr){
                if(map.get(k)!=max) break;
                answer.add(k);
            }
        }
        String[] result = answer.toArray(new String[answer.size()]);
        Arrays.sort(result);
        return result;
    }
    public void select(String order, int size, String menu, int cnt, int start){
        if(cnt==size){
            map.put(menu, map.getOrDefault(menu,0)+1);
            return;
        }
        for(int i=start;i<order.length();i++){
            select(order,size,menu+order.substring(i,i+1),cnt+1,i+1);
        }
    }
}