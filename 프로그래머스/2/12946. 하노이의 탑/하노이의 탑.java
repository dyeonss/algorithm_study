import java.util.*;
class Solution {
    static ArrayList<int[]> list=new ArrayList<>();
    public int[][] solution(int n) {
        int[][] answer = {};
        hanoi(n,1,3,2);
        answer=new int[list.size()][2];
        
        for(int i=0;i<list.size();i++){
            System.arraycopy(list.get(i),0,answer[i],0,list.get(i).length);
        }
        return answer;
    }
    public void hanoi(int n,int from, int to, int sub){
        if(n==0)    return;
        hanoi(n-1,from,sub,to);
        list.add(new int[]{from,to});
        hanoi(n-1,sub,to,from);
    }
}