
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_1715 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < N; i++){
            int x = sc.nextInt();
            pq.add(x);
        }
        int answer = 0;
        while(pq.size()>1){
            int a = pq.poll();
            int b = pq.poll();
            answer += a+b;
            pq.add(a+b);
        }
        System.out.println(answer);

    }
}