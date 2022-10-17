import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N,d,k,c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N=Integer.parseInt(st.nextToken());
        d=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());
        c=Integer.parseInt(st.nextToken());
        int [] sushi=new int[N];
        int [] eat = new int[d+1];
        for (int i = 0; i < N; i++) {
            sushi[i]=Integer.parseInt(br.readLine());
        }

        int cnt=0;
        for (int i = 0; i < k; i++) {
            if(eat[sushi[i]]==0) {
                cnt++;
            }
            eat[sushi[i]]++;
        }
        int res=cnt;
        for (int i = 1; i < N; i++) {
            if(res<=cnt){
                if(eat[c]==0){
                    res=cnt+1;
                }
                else
                    res=cnt;
            }

            if(eat[sushi[(i-1+k)%N]]==0){
                cnt++;
            }
            eat[sushi[(i-1+k)%N]]++;

            eat[sushi[i-1%N]]--;
            if(eat[sushi[i-1%N]]==0)
                cnt--;
        }
        System.out.println(res);
    }
}
