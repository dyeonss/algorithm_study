import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        int divide = 0;
        //Arrays.sort(numbers);
        Integer[] sorted = Arrays.stream(numbers).boxed().toArray(Integer[]::new);

        Arrays.sort(sorted, new Comparator<Integer>(){
            @Override               
            public int compare(Integer a, Integer b){
                String atos = String.valueOf(a);
                String btos = String.valueOf(b);
                int alen=atos.length();
                int blen=btos.length();
                int max = Math.max(alen,blen);
                
                for(int i=0;i<max;i++){
                    int aidx = (i>=alen?i%alen:i);
                    int bidx = (i>=blen?i%blen:i);
                    if(atos.charAt(aidx)!=btos.charAt(bidx))
                        return btos.charAt(bidx)-atos.charAt(aidx);
                }
                return btos.charAt(blen-1)-atos.charAt(alen-1);
            }
        });
        
        for(int num:sorted)
            answer+=String.valueOf(num);

        if(answer.charAt(0)=='0')    answer="0";
        
        return answer;
    }
}