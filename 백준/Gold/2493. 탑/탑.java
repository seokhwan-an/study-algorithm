import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    static class Tower {
        int index;
        int height;

        public Tower(int index, int height) {
            this.index = index;
            this.height = height;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");

        StringBuilder sb = new StringBuilder();
        Stack<Tower> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            int towerHeight = Integer.parseInt(inputs[i]);
            if (stack.isEmpty()) {
                sb.append(0).append(" ");
                stack.push(new Tower(i, towerHeight));
            } else {
                while (true) {
                    if (stack.isEmpty()) {
                        sb.append("0").append(" ");
                        stack.push(new Tower(i, towerHeight));
                        break;
                    }

                    Tower top = stack.peek();

                    if (top.height > towerHeight) {
                        sb.append(top.index + 1).append(" ");
                        stack.push(new Tower(i, towerHeight));
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
        }

        System.out.println(sb);
    }
}
