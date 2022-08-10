import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1072 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int left = 0, right = x, mid = 0;
        long next = 0;
        if (z >= 99) {
            System.out.println(-1);
        } else {
            while (left <= right) {
                mid = (left + right) / 2;
                next = (y + mid) * 100 / (x + mid);
                if (next > z) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            System.out.println(mid);
        }
    }
}
