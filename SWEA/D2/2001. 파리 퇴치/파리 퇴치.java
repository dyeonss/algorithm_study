import java.util.Scanner;

class Solution {
    static int[][] map = new int[15][15] ;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int n=sc.nextInt();
            int m= sc.nextInt();
            int r=0, c=0, sum=0, max=0;
            
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    map[i][j]= sc.nextInt();
                }
            }
            
            for(int i=0;i<=n-m;i++){
                for(int j=0;j<=n-m;j++){
                    sum=0;
                    for(int k=0;k<m;k++){
                        for(int l=0;l<m;l++){
                            sum+=map[i+k][j+l];
                        }
                        if(sum>max)
                            max=sum;
                    }
                }
            }
            System.out.println("#"+test_case+" "+max);
        }
    }
}