import java.util.*;
class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        Arrays.fill(answer,1);
        
        for(int i=0;i<5;i++){
            ArrayList<int[]> list=new ArrayList<>();
            for(int j=0;j<5;j++){
                for(int k=0;k<5;k++){
                    if(places[i][j].charAt(k)=='P'){
                        list.add(new int[]{j,k});
                    }
                }
            }
        
            for(int j=0;j<list.size()-1&&answer[i]==1;j++){
                for(int k=j+1;k<list.size()&&answer[i]==1;k++){
                    int[] p1=list.get(j);
                    int[] p2=list.get(k);
                    int d=Math.abs(p1[0]-p2[0])+Math.abs(p1[1]-p2[1]);
                    if(d==2){
                        //같은 행에 존재할 때
                        if(p1[0]==p2[0]){
                            if(places[i][p1[0]].charAt((p1[1]+p2[1])/2)=='O')
                                answer[i]=0;
                        }
                        //같은 열에 존재할 때
                        else if(p1[1]==p2[1]){
                            if(places[i][(p1[0]+p2[0])/2].charAt(p1[1])=='O')
                                answer[i]=0;
                        }
                        //다른 행,열에 존재할 때
                        else{
                            int sr=Math.min(p1[0],p2[0]), er=Math.max(p1[0],p2[0]);
                            int sc=Math.min(p1[1],p2[1]), ec=Math.max(p1[1],p2[1]);
                            for(int r=sr;r<=er;r++)
                                for(int c=sc;c<=ec;c++){
                                    if(places[i][r].charAt(c)=='O')
                                        answer[i]=0;
                                }
                        }
                    }
                    else if(d==1)
                        answer[i]=0;                   
                }
            }
        }
        return answer;
    }
}