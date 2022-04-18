import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] cost = new int[N][3];
        int[][] answer = new int[N][3];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());
            cost[i][2] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < N; i++){
            if(i == 0){
                answer[i][0] = cost[i][0];
                answer[i][1] = cost[i][1];
                answer[i][2] = cost[i][2];
            }
            else{
                answer[i][0] = Math.min(answer[i-1][1],answer[i-1][2]) + cost[i][0];
                answer[i][1] = Math.min(answer[i-1][0],answer[i-1][2]) + cost[i][1];
                answer[i][2] = Math.min(answer[i-1][0],answer[i-1][1]) + cost[i][2];
            }
        }
        int min = answer[N-1][0];
        for(int i = 0; i < 3; i++){
            if(min > answer[N-1][i]){
                min = answer[N-1][i];
            }
        }
        System.out.println(min);
    }
}
