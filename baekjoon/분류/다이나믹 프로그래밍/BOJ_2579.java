import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] step = new int[N+2];
        for(int i = 2; i < N+2; i++){
            step[i] = Integer.parseInt(br.readLine());
        }
        int[][] answer = new int[N+2][2];
        answer[0][0] = answer[1][0] = answer[0][1] = answer[1][1] = 0;
        for(int i = 2; i < N+2; i++){
            if(i == N+1){ // 3번 조건
                if(answer[i-1][1] == 2){//2번 제약조건 3번 연속 불가;
                    answer[i][0] = answer[i-2][0] + step[i];
                    answer[i][1] = 1;
                }
                else{
                    answer[i][0] = Math.max(answer[i-1][0],answer[i-2][0]) + step[i];
                }
            }
            else{
                if(answer[i-1][1] == 2){//2번 제약조건 3번 연속 불가;
                    answer[i][0] = answer[i-2][0] + step[i];
                    answer[i][1] = 1;
                }
                else{
                    if(answer[i-1][0] > answer[i-2][0]) { // 1번 조건
                        answer[i][0] = answer[i-1][0] + step[i];
                        answer[i][1] = answer[i-1][1] + 1;
                    }
                    else{
                        answer[i][0] = answer[i-2][0] + step[i];
                        answer[i][1] = 1;
                    }
                }
            }
        }
        System.out.println(answer[N+1][0]);
    }
}
