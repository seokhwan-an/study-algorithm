import java.util.Scanner;

public class Main {

    static int N;
    static int M;
    static int arr[] = new int[9];
    static boolean[] visited = new boolean[9];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        M = sc.nextInt();

        solution(0);
    }

    private static void solution(int k) {
        if (k == M) {
            for (int i = 0; i < k; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                arr[k] = i;
                visited[i] = true;
                solution(k + 1);
                visited[i] = false;
            }
        }
    }
}
