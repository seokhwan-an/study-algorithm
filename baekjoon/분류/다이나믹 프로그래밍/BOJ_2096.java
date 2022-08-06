import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][3];
        int[][] dp_max = new int[n][3];
        int[][] dp_min = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 초기값 세팅
        for (int i = 0; i < 3; i++) {
            dp_max[0][i] = map[0][i];
            dp_min[0][i] = map[0][i];
        }
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            dp_max[i][0] = Math.max(dp_max[i - 1][0], dp_max[i - 1][1]) + map[i][0];
            dp_min[i][0] = Math.min(dp_min[i - 1][0], dp_min[i - 1][1]) + map[i][0];

            dp_max[i][1] = Math.max(dp_max[i - 1][1], Math.max(dp_max[i - 1][0], dp_max[i - 1][2])) + map[i][1];
            dp_min[i][1] = Math.min(dp_min[i - 1][1], Math.min(dp_min[i - 1][0], dp_min[i - 1][2])) + map[i][1];

            dp_max[i][2] = Math.max(dp_max[i - 1][2], dp_max[i - 1][1]) + map[i][2];
            dp_min[i][2] = Math.min(dp_min[i - 1][2], dp_min[i - 1][1]) + map[i][2];

        }
        for(int i = 0; i < 3; i++){
            max = Math.max(max, dp_max[n-1][i]);
            min = Math.min(min, dp_min[n-1][i]);
        }
        System.out.println(max + " " + min);
    }
}
