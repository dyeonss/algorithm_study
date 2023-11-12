class Solution {
    public int solution(int storey) {
        int answer = 0;
        int tmp = storey;
        
        String str=String.valueOf(storey);
        int j=0;
        for(int i=str.length()-1;i>=0;i--){
            if(str.charAt(i)-'0'<5){
                storey-=(str.charAt(i)-'0')*Math.pow(10,j++);
                answer+=(str.charAt(i)-'0');
            }
            else{
                storey+=(10-(str.charAt(i)-'0'))*Math.pow(10,j++);
                answer+=(10-(str.charAt(i)-'0'));
                if(str.length()<String.valueOf(storey).length())    i++;
            }
            str=String.valueOf(storey);
        }
        
        j=0; 
        storey = tmp;
        str=String.valueOf(storey);
        int answer1 = 0;
        for(int i=str.length()-1;i>=0;i--){
            if(str.charAt(i)-'0'<=5){
                storey-=(str.charAt(i)-'0')*Math.pow(10,j++);
                answer1+=(str.charAt(i)-'0');
            }
            else{
                storey+=(10-(str.charAt(i)-'0'))*Math.pow(10,j++);
                answer1+=(10-(str.charAt(i)-'0'));
                if(str.length()<String.valueOf(storey).length())    i++;
            }
            str=String.valueOf(storey);
        }
        
        return Math.min(answer, answer1);
    }
}

    
    
