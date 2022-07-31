import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1010 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb;
        sb = new StringBuilder();
        int[][] dp = new int[30][30];
        int T = Integer.parseInt(br.readLine());
        for(int i = 1; i < 30; i++){
            dp[i][1] = i;
        }
        for(int i = 2; i < 30; i++){
            for(int j = 2; j < 30; j++){
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }
        for(int i = 0; i < T; i++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            sb.append(String.valueOf(dp[M][N])+"\n");
        }
        System.out.println(sb);
    }
}
