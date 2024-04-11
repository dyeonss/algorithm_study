import java.util.*;
class Solution {
    static HashMap<String,ArrayList<Integer>> map=new HashMap<>();
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        int idx=0;
        
        for(String ii:info){
            String[] arr=ii.split(" ");
            dfs(0,arr,"");
        }
        
        for(String key:map.keySet())
            map.get(key).sort((o1,o2)->o1-o2);
        
        for(String q:query){
            q=q.replace(" and ","");
            String[] arr=q.split(" ");
            answer[idx++]=map.containsKey(arr[0])?binarySearch(map.get(arr[0]),Integer.valueOf(arr[1])):0;
           
        }  
        
        return answer;
    }
    public void dfs(int cnt, String[] arr, String str){
        if(cnt==4){
            if(map.containsKey(str)){
                map.get(str).add(Integer.valueOf(arr[4]));
            }
            else{
                ArrayList<Integer> list=new ArrayList<>();
                list.add(Integer.valueOf(arr[4]));
                map.put(str,list);
            }
            
            return;
        }
        dfs(cnt+1,arr,str+"-");
        dfs(cnt+1,arr,str+arr[cnt]);
    }
    public int binarySearch(ArrayList<Integer> list,int n){
        int start=0, end=list.size()-1;
        
        while(start<=end){
            int mid=(start+end)/2;
            if(list.get(mid)<n)
                start=mid+1;
            else
                end=mid-1;
        }
        return list.size()-start;
    }
}