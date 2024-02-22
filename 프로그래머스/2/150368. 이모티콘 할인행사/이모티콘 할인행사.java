import java.util.*;
class Solution {
    static int[] discount={10,20,30,40};
    static int[] sale;
    static int[] answer=new int[2];
    public int[] solution(int[][] users, int[] emoticons) {
        sale=new int[emoticons.length];
        dfs(users,emoticons,0);
        return answer;
    }
    public void dfs(int[][] users, int[] emoticons, int cnt){
        if(cnt==emoticons.length){
            service(users,emoticons);
            return;
        }
        for(int i=0;i<discount.length;i++){
            sale[cnt]=discount[i];
            dfs(users,emoticons,cnt+1);
        }
    }
    public void service(int[][] users,int[] emoticons){
        int join=0, total=0;
        int[] price=new int[emoticons.length];
        
        for(int i=0;i<emoticons.length;i++)
            price[i]=(int)(emoticons[i]*(100-sale[i])*0.01);
        
        for(int i=0;i<users.length;i++){
            int buy=0;
            for(int j=0;j<price.length;j++){
                if(sale[j]>=users[i][0]){
                    if(buy+price[j]>=users[i][1]){
                        join++;
                        buy=0;
                        break;
                    }
                    buy+=price[j];
                }
            }
            total+=buy;
        }
        
        if(join==answer[0])
            answer[1]=Math.max(answer[1],total);
        else if(join>answer[0]){
            answer[0]=join;
            answer[1]=Math.max(0,total);
        }       
    }
}