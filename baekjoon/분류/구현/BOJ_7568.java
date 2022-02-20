import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] students = new int[N][2];
        int[] answer = new int[N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            students[i][0] = Integer.parseInt(st.nextToken());
            students[i][1] = Integer.parseInt(st.nextToken());
            answer[i] = 1;
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(i == j) continue;
                if(students[i][0] < students[j][0] && students[i][1] < students[j][1]){
                    answer[i] += 1;
                }
            }
        }
        for(int i = 0; i < N; i++){
            System.out.print(answer[i]+" ");
        }
    }
}