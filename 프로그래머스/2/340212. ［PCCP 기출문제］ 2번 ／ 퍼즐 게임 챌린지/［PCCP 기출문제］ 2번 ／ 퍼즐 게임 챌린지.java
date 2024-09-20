class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int start=Integer.MAX_VALUE, end=Integer.MIN_VALUE;
        
        for(int i=0;i<diffs.length;i++){
            start=Math.min(start,diffs[i]);
            end=Math.max(end,diffs[i]);
        }
        
        while(start<=end){
            int level=(start+end)/2;
            long now=limit;
            for(int i=0;i<diffs.length;i++){
                if(level<diffs[i])
                    now-=(i==0?times[i]:times[i]+times[i-1])*(diffs[i]-level)+times[i];
                else
                    now-=times[i];
                if(now<0)   break;
            }
            if(now<0){
                start=level+1;
            }
            else{
                end=level-1;
            }
        }
        answer=start;
        return answer;
    }
}