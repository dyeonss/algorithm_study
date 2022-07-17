import java.util.Scanner;

class Solution {
    static int[][] num = new int[7][7];

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();

            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++){
                    num[i][j]=sc.nextInt();
                }
            }

            System.out.println("#"+test_case);
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    System.out.printf("%d", num[n-1-j][i]);
                }
                System.out.printf(" ");
                for(int j=0;j<n;j++){
                    System.out.printf("%d", num[n-1-i][n-1-j]);
                }
                System.out.printf(" ");
                for(int j=0;j<n;j++){
                    System.out.printf("%d", num[j][n-1-i]);
                }
                System.out.println();
            }
        }
    }
}