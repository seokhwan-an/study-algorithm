import java.io.BufferedReader;
import java.io.IOException;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int score = Integer.parseInt(input[1]);
        int p = Integer.parseInt(input[2]);

        Stack<Integer> stack = new Stack<>();
        if (n > 0) {
            String[] scoreInput = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                int s = Integer.parseInt(scoreInput[i]);
                stack.push(s);
            }
        }

        while(!stack.isEmpty()) {
            if (stack.peek() >= score) {
                break;
            }
            stack.pop();
        }

        if (stack.size() >= p) {
            System.out.println(-1);
        } else {
            if (n == 0) {
                System.out.println(1);
            } else if (stack.isEmpty()) {
                System.out.println(1);
            } else if (stack.peek() == score) {
                while(!stack.isEmpty()) {
                    if (stack.peek() > score) {
                        break;
                    }
                    stack.pop();
                }
                System.out.println(stack.size() + 1);
            } else {
                System.out.println(stack.size() + 1);
            }
        }
    }
}
