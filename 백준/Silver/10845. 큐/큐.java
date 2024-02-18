import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Deque<Integer> q = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            if (order.equals("push")) {
                int num = Integer.parseInt(st.nextToken());
                q.addLast(num);
            } else if (order.equals("pop")) {
                if (q.isEmpty()) {
                    sb.append(-1 + "\n");
                } else {
                    int pop_num = q.poll();
                    sb.append(pop_num + "\n");
                }
            } else if (order.equals("size")) {
                sb.append(q.size() + "\n");
            } else if (order.equals("empty")) {
                if (q.isEmpty()) {
                    sb.append(1 + "\n");
                } else {
                    sb.append(0 + "\n");
                }
            } else if (order.equals("front")) {
                if (q.isEmpty()) {
                    sb.append(-1 + "\n");
                } else {
                    sb.append(q.getFirst() + "\n");
                }
            } else if (order.equals("back")) {
                if (q.isEmpty()) {
                    sb.append(-1 + "\n");
                } else {
                    sb.append(q.getLast() + "\n");
                }
            }
        }
        System.out.println(sb);
    }
}
