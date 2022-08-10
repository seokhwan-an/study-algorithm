import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1072 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        long x = Integer.parseInt(st.nextToken());
        long y = Integer.parseInt(st.nextToken());
        int z = win_rate(x, y);

        long left = 0, right = x, mid = 0;
        int next = 0;
        if (z >= 99) {
            System.out.println(-1);
        } else {
            while (left <= right) {
                mid = (left + right) / 2;
                next = win_rate(x + mid, y + mid);
                if (next > z) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            System.out.println(left);
        }
    }

    public static int win_rate(long x, long y) {
        int win_rate = (int)(y * 100 / x);
        return win_rate;
    }
}
