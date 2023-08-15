import java.util.*;
class Solution {
    public int solution(String dirs) {
        char[] dir_list = dirs.toCharArray();
        int r=0, c=0;
        HashSet<String> set = new HashSet<>();
        
        for(char dir: dir_list){
            int nr = r, nc = c;
            if(dir == 'U')  nr-=1;
            else if(dir == 'D') nr+=1;
            else if(dir == 'R') nc+=1;
            else    nc-=1;
            
            if(nr<-5||nr>5||nc<-5||nc>5)    continue;
            set.add(nr+""+nc+" "+r+""+c);
            set.add(r+""+c+" "+nr+""+nc);
            r = nr;
            c = nc; 
        }
        return set.size()/2;
    }
}