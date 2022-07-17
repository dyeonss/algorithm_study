import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int n, m, large, small, sum=0;
            int max=Integer.MIN_VALUE;

            n = sc.nextInt();
            m = sc.nextInt();

            if(n>m){
                large=n;
                small=m;
            }
            else{
                large=m;
                small=n;
            }

            int[] a = new int[n];
            int[] b = new int[m];

            for(int i=0;i<n;i++){
                a[i]= sc.nextInt();
            }
            for(int i=0;i<m;i++){
                b[i]= sc.nextInt();
            }

            for(int i=0;i<=large-small;i++){
                sum=0;
                for(int j=0;j<small;j++){
                    if(n>m)
                        sum+=a[i+j]*b[j];
                    else
                        sum+=a[j]*b[i+j];
                }
                if(sum>max)
                    max=sum;
            }
            System.out.println("#"+test_case+" "+max);
        }
    }
}