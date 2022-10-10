import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N,min,max;
    static int [] nums;
    static int [] op;
    static int [] select;
    static boolean [] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T=Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N=Integer.parseInt(br.readLine());
            op=new int [4];
            select = new int[N-1];
            nums=new int[N];
            min=Integer.MAX_VALUE;
            max=Integer.MIN_VALUE;
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for (int i = 0; i < 4; i++) {
                op[i]=Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine()," ");
            for (int i = 0; i < N; i++) {
                nums[i]=Integer.parseInt(st.nextToken());
            }
            ncr(0);
            sb.append("#").append(tc).append(" ").append(max-min).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void ncr(int cnt) {
        if(cnt==N-1){
            int res=calculate();
            min=Math.min(res,min);
            max=Math.max(res,max);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if(op[i]>0){
                op[i]--;
                select[cnt]=i;
                ncr(cnt+1);
                op[i]++;
            }
        }
    }

    private static int calculate() {
        int result=nums[0];
        for (int i = 1; i < N; i++) {
            result = operate(result,nums[i],select[i-1]);
        }
        return result;
    }

    private static int operate(int a, int b, int op) {
        switch (op){
            case 0:
                return a+b;
            case 1:
                return a-b;
            case 2:
                return a*b;
            case 3:
                return a/b;
        }
        return 0;
    }
}