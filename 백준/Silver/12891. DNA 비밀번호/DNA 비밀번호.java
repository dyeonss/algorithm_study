import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static int S, P;
	static String dna;
	static HashMap<Character, Integer> count= new HashMap<>();
	static int a;
	static int c;
	static int g;
	static int t;
	static int total=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		S=Integer.parseInt(st.nextToken());
		P=Integer.parseInt(st.nextToken());
		
		dna=br.readLine();
		st = new StringTokenizer(br.readLine());
		a=Integer.parseInt(st.nextToken());
		c=Integer.parseInt(st.nextToken());
		g=Integer.parseInt(st.nextToken());
		t=Integer.parseInt(st.nextToken());
		
		count.put('A', 0);
		count.put('C', 0);
		count.put('G', 0);
		count.put('T', 0);
		
		//첫번째 문자열 넣어줌
		for (int i = 0; i < P; i++) {
			switch(dna.charAt(i)) {
			case 'A':
				count.put('A', count.get('A')+1);
				break;
			case 'C':
				count.put('C', count.get('C')+1);
				break;
			case 'G':
				count.put('G', count.get('G')+1);
				break;
			case 'T':
				count.put('T', count.get('T')+1);
				break;
			}
		}
		
		check();
		
		int idx=0;
		for (int j = P; j < S; j++) {
			
			switch (dna.charAt(j)) {
			case 'A':
				count.put('A', count.get('A') + 1);
				break;
			case 'C':
				count.put('C', count.get('C') + 1);
				break;
			case 'G':
				count.put('G', count.get('G') + 1);
				break;
			case 'T':
				count.put('T', count.get('T') + 1);
				break;
				
			}
			count.put(dna.charAt(idx), count.get(dna.charAt(idx))-1);
			check();
			idx++;
		}
		System.out.println(total);
	}
	private static void check() {
		
		if(a>count.get('A'))
			return;
		if(c>count.get('C'))
			return;
		if(g>count.get('G'))
			return;
		if(t>count.get('T'))
			return;
		total++;
	}
	

}
