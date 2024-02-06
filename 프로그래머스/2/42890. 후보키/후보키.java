import java.util.*;
class Solution {
    static ArrayList<String> list=new ArrayList<>();
    static boolean[] visited;
    public int solution(String[][] relation) {
        int[] arr=new int[relation[0].length];
        
        for(int i=0;i<relation[0].length;i++)   arr[i]=i;
        
        for(int i=relation[0].length;i>0;i--){
            int[] select=new int[i];   
            visited=new boolean[relation[0].length];
            combi(relation,select,0,i,0);
        }
        return list.size();
    }
    public void combi(String[][] relation,int[] select, int now, int cnt, int start){
        if(now==cnt){
            if(scan(relation,select)){
                StringBuilder sb=new StringBuilder();
                
                for(int i=0;i<select.length;i++)    sb.append(select[i]);
             
                for(int i=0;i<list.size();i++){
                    boolean isOk=true;
                    String s=list.get(i);
                    for(int j=0;j<sb.length();j++){
                        if(s.indexOf(sb.toString().charAt(j))<0){
                            isOk=false;
                            break;
                        }
                    }
                    if(isOk){
                        list.remove(i);
                        i--;
                    }
                }
                list.add(sb.toString());
            }
            return;    
        }
        
        for(int i=start;i<relation[0].length;i++){
            visited[i]=true;
            select[now]=i;
            combi(relation,select,now+1,cnt,i+1);
            visited[i]=false;
        }
        
    }
    public boolean scan(String[][] relation,int[] select){
        HashSet<String> set=new HashSet<>();
        
        for(int i=0;i<relation.length;i++){
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<select.length;j++)    sb.append(relation[i][select[j]]);
            
            if(set.contains(sb.toString())) return false;
            set.add(sb.toString());
        }
        return true;
    }
}