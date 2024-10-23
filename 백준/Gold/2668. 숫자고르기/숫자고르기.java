import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static int N;
    static int[] num;
    static boolean[] visited;
    static List<Integer> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        num = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            int number = Integer.parseInt(br.readLine());
            num[i] = number;
        }

        answer = new ArrayList<>();
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            visited[i] = true;
            findCycle(i, i);
            visited[i] = false;
        }

        Collections.sort(answer);
        System.out.println(answer.size());
        for (int num : answer) {
            System.out.println(num);
        }
    }

    private static void findCycle(int start, int i) {
        if (!visited[num[start]]) {
            visited[num[start]] = true;
            findCycle(num[start], i);
            visited[num[start]] = false;
        }
        if (num[start] == i) {
            answer.add(i);
        }
    }
}
