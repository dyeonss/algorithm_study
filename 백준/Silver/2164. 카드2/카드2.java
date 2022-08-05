import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> card=new LinkedList<>();
        int N=Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            card.offer(i);
        }

        while (card.size()!=1){
            card.poll();
            int rear=card.poll();
            card.offer(rear);
        }
        System.out.println(card.peek());

    }
}
