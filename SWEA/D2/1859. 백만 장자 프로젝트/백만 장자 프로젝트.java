import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n=sc.nextInt();
			int [] arr=new int[n];
			long sum=0;
			int max;
			
			for (int i = 0; i < n; i++) {
				arr[i]=sc.nextInt();
			}
			
			max=arr[n-1];
			
			for (int i = n-2; i >=0; i--) {
				if(max>arr[i]) {
					sum+=(max-arr[i]);
				}
				else
					max=arr[i];
			}
			System.out.println("#"+test_case+" "+sum);
		}
	}
}
