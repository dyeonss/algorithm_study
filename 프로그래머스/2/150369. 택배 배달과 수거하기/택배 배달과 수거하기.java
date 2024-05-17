class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int d=0, p=0, idx=0, d_idx=0, p_idx=0;
        
        for(int i=n-1;i>=0;i--){
            if(deliveries[i]!=0||pickups[i]!=0){
                idx=i;
                break;
            }
        }
        
        if(idx==0)  return 0;
        while(idx>=0){
            for(d_idx=idx;d_idx>=0;d_idx--){
                d+=deliveries[d_idx];
                if(d<=cap){
                    deliveries[d_idx]=0;
                }
                else if(d>cap){
                    deliveries[d_idx]-=(cap-(d-deliveries[d_idx]));
                    break;
                }
            }
            for(p_idx=idx;p_idx>=0;p_idx--){
                p+=pickups[p_idx];
                if(p<=cap){
                    pickups[p_idx]=0;
                }
                else if(p>cap){
                    pickups[p_idx]-=(cap-(p-pickups[p_idx]));
                    break;
                }
            }
            d=0;
            p=0;
            
            answer+=(idx+1)*2;
            idx=Math.max(d_idx,p_idx);
        }
        return answer;
    }
}