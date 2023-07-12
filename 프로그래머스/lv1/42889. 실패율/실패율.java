import java.util.*;
class Solution {
    static class Order{
        int idx=0;
        double rate=0.0;
        
        public Order(int idx, double rate){
            this.idx=idx;
            this.rate=rate;
        }
    }
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        Order[] arr = new Order[N];
        
        for(int i=1;i<=N;i++){
            int not=0,done=0;
            for(int j=0;j<stages.length;j++){
                if(stages[j]==i)    not++;
                if(stages[j]>=i) done++;
            }
            if(done==0) arr[i-1]=new Order(i,0.0);
            else    arr[i-1]=new Order(i,(double)not/done);
        }
        Arrays.sort(arr, new Comparator<Order>(){
            public int compare(Order o1, Order o2){
                if(o1.rate>o2.rate) return -1;
                else if(o1.rate==o2.rate)   return Integer.compare(o1.idx,o2.idx);
                else return 1;
            }
        });
        
        for(int i=0;i<N;i++){
            answer[i]=arr[i].idx;
        }
        return answer;
    }
}