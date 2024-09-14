import java.util.*;
class Solution {
    static HashMap<String,Integer> map;
    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> answer=new ArrayList<>();
        
        for(int i=0;i<course.length;i++){
            map=new HashMap<>();
            for(int j=0;j<orders.length;j++){
                if(orders[j].length()<course[i])   continue;
                String[] menus=orders[j].split("");
                Arrays.sort(menus);
                combi(0,0,course[i],"",menus);
            }
            ArrayList<String> list=new ArrayList<>(map.keySet());
            list.sort((o1,o2)->map.get(o2)-map.get(o1));
            
            if(list.size()>0){
                int max=map.get(list.get(0));
                if(max<2)   continue;
                for(int k=0;k<list.size();k++){
                    if(map.get(list.get(k))!=max)   break;
                    answer.add(list.get(k));
                }
            }
        }
        Collections.sort(answer);
        return answer.toArray(new String[answer.size()]);
    }
    public void combi(int start,int cnt,int size,String s,String[] menus){
        if(cnt==size){
            map.put(s,map.getOrDefault(s,0)+1);
            return;
        }
        for(int i=start;i<menus.length;i++){
            combi(i+1,cnt+1,size,s+menus[i],menus);
        }
    }
}