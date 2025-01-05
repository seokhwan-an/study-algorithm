import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(1);
            return;
        }

        int start = 1;
        int count = 1;
        while(true) {
            start += 6 * count;
            if (start >= N) {
                break;
            }
            count++;
        }

        System.out.println(count + 1);
    }
}
