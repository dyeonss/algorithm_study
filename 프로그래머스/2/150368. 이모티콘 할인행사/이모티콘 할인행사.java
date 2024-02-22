import java.util.*;
class Solution {
    public class Emoticon{
        int price, rate;
        Emoticon(int price, int rate){
            this.price=price;
            this.rate=rate;
        }
    }
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
        int[] price=new int[emoticons.length];
        int join=0, total=0;
        ArrayList<Emoticon> list=new ArrayList<>();
        
        for(int i=0;i<emoticons.length;i++){
            list.add(new Emoticon((int)(emoticons[i]*(100-sale[i])*0.01),sale[i]));
            price[i]=(int)(emoticons[i]*(100-sale[i])*0.01);
        }
        list.sort((o1,o2)->-(o1.price-o2.price));
    
        for(int i=0;i<users.length;i++){
            int buy=0;
            for(int j=0;j<list.size();j++){
                Emoticon e=list.get(j);
                if(e.rate>=users[i][0]){
                    if(buy+e.price>=users[i][1]){
                        join++;
                        buy=0;
                        break;
                    }
                    buy+=e.price;
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