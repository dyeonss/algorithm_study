import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		int [] p=new int[n];
		
		for (int i = 0; i < n; i++) {
			p[i]=sc.nextInt();
		}
		boolean result=np(n-1, p);
		
		if(result==false) 
			System.out.println("-1");
		else {
			for (int i = 0; i < p.length; i++) {
				System.out.printf("%d ",p[i]);
			}
		}

	}

	private static boolean np(int size, int [] p) {
		int i = size;

		while (i > 0 && p[i - 1] < p[i])
			i--;

		if (i == 0)
			return false;
		
		int j=size;
		
		while(p[i-1]<p[j])
			j--;
		
		int temp=p[i-1];
		p[i-1]=p[j];
		p[j]=temp;
		
		int k=size;
		
		while(i<k) {
			temp=p[i];
			p[i]=p[k];
			p[k]=temp;
			i++;
			k--;
		}
		
		return true;
	}

}
