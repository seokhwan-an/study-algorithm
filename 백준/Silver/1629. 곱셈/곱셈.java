import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();
        System.out.println(solution(a, b, c));
    }

    private static long solution(long a, long b, long c) {
        if (b == 1) {
            return a % c;
        }
        long val = solution(a, b/2, c);
        if (b % 2 == 1) {
            return val * val % c * a % c;
        }
        return val * val % c;
    }
}
