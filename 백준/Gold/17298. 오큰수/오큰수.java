import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] answer = new int[n];
        int[] numbers = new int[n];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
                continue;
            }
            int size = stack.size();
            for (int j = 0; j < size; j++) {
                if (numbers[stack.peek()] >= numbers[i]) {
                    break;
                }

                answer[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }

        int size = stack.size();
        for (int i = 0; i < size; i++) {
            answer[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int a : answer) {
            sb.append(a).append(" ");
        }

        System.out.println(sb.toString());
    }
}
