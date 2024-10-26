import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");

        int[] towers = new int[N];
        for (int i = 0; i < N; i++) {
            towers[i] = Integer.parseInt(inputs[i]);
        }

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            while(!stack.isEmpty() && towers[stack.peek()] <= towers[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                sb.append(0).append(" ");
            } else {
                sb.append(stack.peek() + 1).append(" ");
            }

            stack.push(i);
        }

        System.out.println(sb.toString());
    }
}
