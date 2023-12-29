class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int a=arrayA[0];
        int b=arrayB[0];
        
        for(int i=1;i<arrayA.length;i++){
            a=getGcd(a,arrayA[i]);
            b=getGcd(b,arrayB[i]);
        }
        
        for(int i=0;i<arrayA.length;i++){
            if(arrayA[i]%b==0){
                b=0;
                break;
            }
        }
        
        for(int i=0;i<arrayB.length;i++){
            if(arrayB[i]%a==0){
                a=0;
                break;
            }
        }
        
        return Math.max(a,b);
    }
    public int getGcd(int x,int y){
        if(y==0)    return x;
        return getGcd(y, x%y);
    }
}