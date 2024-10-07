class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        
        for(int i=0;i<balls.length;i++){
            int x=balls[i][0], y=balls[i][1], distance=0;
            int d1=(int)(Math.pow(startX-x,2)+Math.pow(startY-(n+(n-y)),2)),
            d2=(int)(Math.pow(startX-x,2)+Math.pow(startY-(-y),2)),
            d3=(int)(Math.pow(startX-(-x),2)+Math.pow(startY-y,2)),
            d4=(int)(Math.pow(startX-(m+(m-x)),2)+Math.pow(startY-y,2));
            
            if(startX==x){
                distance=Math.min(d3,d4);
                if(startY>y)    distance=Math.min(distance,(int)Math.pow(2*n-startY-y,2));
                else if(startY<y)   distance=Math.min(distance,(int)Math.pow(startY+y,2));
            }
            else if(startY==y){
                distance=Math.min(d1,d2);
                if(startX>x)    distance=Math.min(distance,(int)Math.pow(2*m-startX-x,2));
                else if(startX<x)   distance=Math.min(distance,(int)Math.pow(startX+x,2));
            }
            else
                distance=Math.min(Math.min(d1,d2),Math.min(d3,d4));
             
            answer[i]=distance;
        }
        return answer;
    }
}