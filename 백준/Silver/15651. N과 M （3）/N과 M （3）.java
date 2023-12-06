import java.util.Scanner;

public class Main {

    static int N;
    static int M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[M];

        solution(0);
        System.out.println(sb);
    }

    private static void solution(int k) {
        if (k == M) {
            for (int number : arr) {
                sb.append(number).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            arr[k] = i;
            solution(k + 1);
        }
    }
}
