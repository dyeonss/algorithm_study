class Solution {
    public int[] answer=new int[2];
    public int[] solution(int[][] arr) {
        int n = arr.length;
        
        zip(arr,0,0,n);
        return answer;
    }
    public void zip(int[][] arr, int r, int c, int n){
        if(check(arr,r,c,n)){
            if(arr[r][c]==0)    answer[0]++;
            else    answer[1]++;
            return;
        }
        zip(arr,r,c,n/2);
        zip(arr,r,c+n/2,n/2);
        zip(arr,r+n/2,c,n/2);
        zip(arr,r+n/2,c+n/2,n/2);
    }
    public boolean check(int[][] arr, int r, int c, int n){
        for(int i=r;i<r+n;i++){
            for(int j=c;j<c+n;j++){
                if(arr[i][j]!=arr[r][c])
                    return false;
            }
        }
        return true;
    }
}