class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;
        int startTime=h1*60*60+m1*60+s1, endTime=h2*60*60+m2*60+s2;
        int sHour=startTime;
        int sMinute=m1*60+s1;
        int sSecond=s1;
        
        //1초전 위치
        double pHour=(sHour*(1.0/120.0))%360.0;
        double pMinute=(sMinute*0.1)%360.0;
        double pSecond=(sSecond*6)%360.0;
        
        if(pHour==pSecond)  answer++;
        else if(pMinute==pSecond)   answer++;
        
        for(int i=1;i<=endTime-startTime;i++){
            //시침위치
            double nHour=((sHour+i)*(1.0/120.0))%360.0;
            double nMinute=((sMinute+i)*0.1)%360.0;
            double nSecond=((sSecond+i)*6)%360.0;
                      
            if((pHour>pSecond)&&(nHour<=((nSecond<pSecond)?nSecond+360:nSecond))){
            //     if(h1==1&&m1==5&&s1==5){
            //     System.out.println("시간: "+(sHour+i-1)+"초와 "+(sHour+i)+"초 사이");
            //     System.out.println("1초전 시침: "+pHour+", 1초후 시침:"+nHour);
            //     System.out.println("1초전 분침: "+pMinute+", 1초후 분침:"+nMinute);
            //     System.out.println("1초전 초침: "+pSecond+", 1초후 초침:"+nSecond+"\n");
            // }
                answer++;
            }
            if((pMinute>pSecond)&&(nMinute<=((nSecond<pSecond)?nSecond+360:nSecond))){
            //     if(h1==1&&m1==5&&s1==5){
            //     System.out.println("시간: "+(sHour+i-1)+"초와 "+(sHour+i)+"초 사이");
            //     System.out.println("1초전 시침: "+pHour+", 1초후 시침:"+nHour);
            //     System.out.println("1초전 분침: "+pMinute+", 1초후 분침:"+nMinute);
            //     System.out.println("1초전 초침: "+pSecond+", 1초후 초침:"+nSecond+"\n");
            // }
                answer++;
            }
            if((pHour>pMinute)&&(pMinute>pSecond)&&(nHour<=((nMinute<pMinute)?nMinute+360:nMinute))&&(nMinute<=((nSecond<pSecond)?nSecond+360:nSecond))){
            //     if(h1==1&&m1==5&&s1==5){
            //     System.out.println("시간: "+(sHour+i-1)+"초와 "+(sHour+i)+"초 사이");
            //     System.out.println("1초전 시침: "+pHour+", 1초후 시침:"+nHour);
            //     System.out.println("1초전 분침: "+pMinute+", 1초후 분침:"+nMinute);
            //     System.out.println("1초전 초침: "+pSecond+", 1초후 초침:"+nSecond+"\n");
            // }
                answer--;
            }
            pHour=nHour;
            pMinute=nMinute;
            pSecond=nSecond;
        }
        
        //시침이 1초에 이동하는 각도: 1/120
        //분침이 1초에 이동하는 각도: 1/10
        //초침이 1초에 이동하는 각도: 6
        
        
        
        
        return answer;
    }
}