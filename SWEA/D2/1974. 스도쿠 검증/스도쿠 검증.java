import java.util.Scanner;

class Solution {
    static int[][] map = new int[9][9] ;
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int ans=1;

            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    map[i][j]= sc.nextInt();
                }
            }

            for(int i=0;i<9;i++){
                int rsum=0;
                int csum=0;
                for(int j=0;j<9;j++){
                    rsum+=map[i][j];
                    csum+=map[j][i];
                }
                if(rsum!=45||csum!=45) {
                    ans = 0;
                    break;
                }
            }

            if(ans==0){
                System.out.println("#"+test_case+" "+ans);
                continue;
            }

            for(int i=0;i<9;i=i+3){
                int sum=0;
                for(int j=0;j<3;j++){
                    for(int k=0;k<3;k++){
                        sum+=map[i+j][i+k];
                    }
                }
                if(sum!=45){
                    ans=0;
                    break;
                }
            }
            System.out.println("#"+test_case+" "+ans);
        }
    }
}