import java.util.Scanner;

public class Main {

    static int N;
    static int M;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[M + 1];
        visited = new boolean[N + 1];

        solution(1);
    }

    private static void solution(int k) {
        if (k == M + 1) {
            for (int i = 1; i <= M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (i > arr[k - 1] && !visited[i]) {
                arr[k] = i;
                visited[i] = true;
                solution(k + 1);
                visited[i] = false;
            }
        }
    }
}
