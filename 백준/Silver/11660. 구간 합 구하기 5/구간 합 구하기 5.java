import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int [][] arr;
    static int x1,x2,y1,y2;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        arr=new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            st=new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                arr[i][j]=Integer.parseInt(st.nextToken())+arr[i][j-1];
            }
        }
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < M; i++) {
            int sum = 0;
            st=new StringTokenizer(br.readLine());
            x1=Integer.parseInt(st.nextToken());
            y1=Integer.parseInt(st.nextToken());
            x2=Integer.parseInt(st.nextToken());
            y2=Integer.parseInt(st.nextToken());

            if(x1==x2&&y1==y2){
                sum=arr[x1][y1]-arr[x1][y1-1];
            }
            else{
                for (int j = x1; j <= x2 ; j++) {
                    sum+=arr[j][y2]-arr[j][y1-1];
                }
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb.toString());
    }
}