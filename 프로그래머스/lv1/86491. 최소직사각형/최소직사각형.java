import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int maxlen = Integer.MIN_VALUE;
        int d=0;
        boolean flag = false;
        int [] h = new int[sizes.length];
        int [] v = new int[sizes.length];
        int i=0;
        for(int [] tmp:sizes){
            h[i]=tmp[0];
            v[i]=tmp[1];
            if(tmp[0]>maxlen){  
                maxlen=tmp[0];
                flag=false;
            }
            else if(tmp[1]>maxlen){
                maxlen=tmp[1];
                flag=true;
            }
            i++;
        }
        if(!flag){  //max가 가로임
            Arrays.sort(v); //세로 정렬
            d=v[0];
            while(true){
                boolean poss=false;
                for(int k=0;k<sizes.length;k++){
                    poss=false;
                    if(d>=sizes[k][0]&&maxlen>=sizes[k][1]) poss=true;
                    else if(d>=sizes[k][1]&&maxlen>=sizes[k][0])    poss=true;
                    if(!poss)   break;
                }
                if(poss)    break;
                d++;
            }
        }else{
            Arrays.sort(h); //세로 정렬
            d=h[0];
            while(true){
                boolean poss=false;
                for(int k=0;k<sizes.length;k++){
                    poss=false;
                    if(d>=sizes[k][0]&&maxlen>=sizes[k][1]) poss=true;
                    else if(d>=sizes[k][1]&&maxlen>=sizes[k][0])    poss=true;
                    if(!poss)   break;
                }
                if(poss)    break;
                d++;
            }
        }
        
        return maxlen*d;
    }
}