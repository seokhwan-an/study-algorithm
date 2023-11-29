import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int moveCnt = (int) Math.pow(2, n) - 1;
        sb.append(moveCnt).append("\n");
        solution(n, 1, 3);
        System.out.println(sb);
    }

    private static void solution(int n, int start, int end) {
        if (n == 1) {
            sb.append(start).append(" ").append(end).append("\n");
            return;
        }
        solution(n - 1, start, 6 - start - end);
        sb.append(start).append(" ").append(end).append("\n");
        solution(n - 1, 6 - start - end, end);
    }
}
