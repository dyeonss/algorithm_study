class Solution {
    public int solution(String s) {
        int answer = s.length();
        int unit=1;
        String ss=s.substring(0,unit);
        
        while(unit*2<=s.length()){
            ss=s.substring(0,unit);
            int n=1,idx=unit;
            StringBuilder result=new StringBuilder();
            while((idx+unit)<=s.length()){
                if(ss.equals(s.substring(idx,idx+unit))){
                    idx=idx+unit;
                    n++;
                }
                else{
                    if(n==1)    result.append(ss);
                    else    result.append(n+ss);
                    n=1;
                    ss=s.substring(idx,idx+unit);
                    idx=idx+unit;
                }
                
            }
            if(n==1)    result.append(ss);
            else    result.append(n+ss);
            if(idx<s.length())  result.append(s.substring(idx));
            unit++;
            answer=Math.min(answer,result.length());
        }
        return answer;
    }
}