class Solution {
    public static int [] cb = new int[3];
    public static int answer = 0;
    public int solution(int[] number) {

        third(number,0,0);
        return answer;
    }
    public void third(int[] number, int k, int cnt){
        if(cnt==3){
            if(sum(cb))
                answer++;
            return;
        }
        for(int i=k;i<number.length;i++){
            cb[cnt]=number[i];
            third(number,i+1,cnt+1);   
        }
    }
    public boolean sum(int [] cb){
        int sum = 0;
        for(int i=0;i<3;i++)
            sum+=cb[i];
        return sum==0?true:false;
    }
}