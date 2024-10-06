import java.util.*;
class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        int n=routes.length, max=0;
        ArrayList<ArrayList<int[]>> list=new ArrayList<>();
        HashMap<String,Integer> map=new HashMap<>();
        
        for(int i=0;i<n;i++)
            list.add(new ArrayList<>());
        
        for(int i=0;i<n;i++){
            int size=0;
            list.get(i).add(new int[]{points[routes[i][0]-1][0],points[routes[i][0]-1][1]});
            size++;
            for(int j=0;j<routes[0].length-1;j++){
                int sr=points[routes[i][j]-1][0], sc=points[routes[i][j]-1][1];
                int er=points[routes[i][j+1]-1][0], ec=points[routes[i][j+1]-1][1];
            
                while(sr!=er){
                    if(sr<er)   sr++;
                    else if(sr>er)  sr--;
                    list.get(i).add(new int[]{sr,sc});
                    size++;
                }
                while(sc!=ec){
                    if(sc<ec)   sc++;
                    else if(sc>ec)  sc--;
                    list.get(i).add(new int[]{sr,sc});
                    size++;
                }
            }
            max=Math.max(max,size);
        }
        
        for(int i=0;i<max;i++){
            for(int j=0;j<n;j++){
                if(i>list.get(j).size()-1)  
                    map.put(String.valueOf(j),1);
                else{
                    int[] arr=list.get(j).get(i);
                    StringBuilder sb=new StringBuilder(String.valueOf(arr[0]));
                    String s=sb.append(" ").append(String.valueOf(arr[1])).toString();
                    map.put(s,map.getOrDefault(s,0)+1);
                }
            }
            for(String k:map.keySet())
                if(map.get(k)>1)    answer++;
            
            map.clear();
        }
        return answer;
    }
}