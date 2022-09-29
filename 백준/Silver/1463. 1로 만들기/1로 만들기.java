import java.util.Scanner;

public class Main {
    static int res=Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp(n, 0);
        System.out.println(res);
    }

    private static void dp(int n, int cnt) {
        if(cnt>=res)    return;
        if(n==1){
            res=Math.min(cnt,res);
            return;
        }
        if(n%3==0)  dp(n/3,cnt+1);
        if(n%2==0)  dp(n/2,cnt+1);
        dp(n-1,cnt+1);
    }
}
