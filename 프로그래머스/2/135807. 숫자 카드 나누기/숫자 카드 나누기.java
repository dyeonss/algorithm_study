class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int a=arrayA[0];
        int b=arrayB[0];
        boolean checkA=true;
        boolean checkB=true;
        
        for(int i=1;i<arrayA.length;i++){
            a=getGcd(a,arrayA[i]);
            b=getGcd(b,arrayB[i]);
        }
        
        for(int i=0;i<arrayA.length;i++){
            if(arrayA[i]%b==0){
                checkB=false;
                break;
            }
        }
        
        for(int i=0;i<arrayB.length;i++){
            if(arrayB[i]%a==0){
                checkA=false;
                break;
            }
        }
        
        if(!checkA&&!checkB)    return 0;
        if(checkA&&checkB)  return Math.max(a,b);
        return checkA?a:b;
    }
    public int getGcd(int x,int y){
        if(y==0)    return x;
        return getGcd(y, x%y);
    }
}