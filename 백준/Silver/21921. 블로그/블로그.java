import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int X = Integer.parseInt(input[1]);


        String[] visitedInput = br.readLine().split(" ");
        int[] visitedCount = new int[N];

        for (int i = 0; i < N; i++) {
            visitedCount[i] = Integer.parseInt(visitedInput[i]);
        }
        int max = 0;
        int count = 1;
        int total = 0;
        int start = 0;
        int end = X - 1;
        for (int i = 0; i <= end; i++) {
            total += visitedCount[i];
            max += visitedCount[i];
        }

        while (true) {
            end++;
            if (end >= N) {
                break;
            }
            total -= visitedCount[start++];
            total += visitedCount[end];

            if (total > max) {
                max = total;
                count = 1;
                continue;
            }

            if (total == max) {
                count += 1;
            }
        }

        if (max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max + "\n" + count);
        }
    }
}
