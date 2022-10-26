class Solution {
    public static int res=0;
    public static int [] arr;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        arr = new int [numbers.length];
        make(numbers, target, 0, 0, 0);
        answer=res;
        return answer;
    }
    public void make(int [] numbers, int target, int cnt, int start, int sum){
        if(cnt==numbers.length){
            if(sum==target)    res++;
            return;
        }
        
        for(int i=start;i<numbers.length;i++){
            make(numbers, target, cnt+1, i+1, sum+numbers[cnt]);
            make(numbers, target, cnt+1, i+1, sum+numbers[cnt]*-1);
        }
    }
}