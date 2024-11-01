import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    static class Tower {
        int height;
        int index;

        public Tower(int height, int index) {
            this.height = height;
            this.index = index;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Tower[] towers = new Tower[n];

        for (int i = 0; i < n; i++) {
            towers[i] = new Tower(Integer.parseInt(br.readLine()), i);
        }

        Stack<Tower> stack = new Stack<>();
        long[] see = new long[n];

        long answer = 0;
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek().height < towers[i].height) {
                Tower p = stack.pop();
                see[i] += see[p.index] + 1;
            }
            answer += see[i];
            stack.push(towers[i]);
        }

        System.out.println(answer);
    }
}
