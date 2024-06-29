class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        
        for(int i=0;i<balls.length;i++){
            int x=balls[i][0], y=balls[i][1];
            int distance=Integer.MAX_VALUE;
            
            if(!(startX==x&&y>startY))   //상
                distance=Math.min(distance, (int)(Math.pow(startX-x,2)+Math.pow(startY-(n+(n-y)),2)));
        
            if(!(startX==x&&y<startY))  //하
                distance=Math.min(distance, (int)(Math.pow(startX-x,2)+Math.pow(startY-(-y),2)));
              
            if(!(startY==y&&x<startX))  //좌
                distance=Math.min(distance, (int)(Math.pow(startX-(-x),2)+Math.pow(startY-y,2)));
             
            if(!(startY==y&&x>startX))  //우
                distance=Math.min(distance, (int)(Math.pow(startX-(m+(m-x)),2)+Math.pow(startY-y,2)));
             
            answer[i]=distance;
        }
        return answer;
    }
}