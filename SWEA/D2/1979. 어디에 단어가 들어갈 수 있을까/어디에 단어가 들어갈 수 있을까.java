import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int n=sc.nextInt();
            int k=sc.nextInt();
            int cnt=0, d=0;
            int arr[][]= new int[n][n];

            for (int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    arr[i][j]=sc.nextInt();
                }
            }

            //가로탐색
            for(int i=0;i<n;i++){
                d=0;
                for(int j=0;j<n;j++){
                    if(arr[i][j]==1)
                        d++;
                    else if(arr[i][j]==0&&d!=k)
                        d=0;
                    else if(arr[i][j]==0&&d==k){
                        cnt++;
                        d=0;
                    }
                }
                if(d==k)
                    cnt++;
            }
            //세로탐색
            for(int i=0;i<n;i++){
                d=0;
                for(int j=0;j<n;j++){
                    if(arr[j][i]==1)
                        d++;
                    else if(arr[j][i]==0&&d!=k)
                        d=0;
                    else if(arr[j][i]==0&&d==k){
                        cnt++;
                        d=0;
                    }
                }
                if(d==k)
                    cnt++;
            }
            System.out.println("#"+test_case+" "+cnt);
        }
    }
}