import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] step = new int[N+1];
        for(int i = 1; i < N+1; i++){
            step[i] = Integer.parseInt(br.readLine());
        }
        int[] answer = new int[N+1];
        answer[1] = step[1];
        if(N >= 2){
            answer[2] = step[1] + step[2];
        }
        for(int i = 3; i < N+1; i++){
            answer[i] = Math.max(answer[i-2],answer[i-3]+step[i-1]) + step[i];
        }
        System.out.println(answer[N]);
    }
}
