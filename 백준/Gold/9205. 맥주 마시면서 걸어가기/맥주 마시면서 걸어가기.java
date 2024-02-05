import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        String[] answer = new String[N];
        for(int i = 0; i < N; i++){
            int M = Integer.parseInt(br.readLine());
            int[][] city = new int[M+2][2];
            boolean[] visit = new boolean[M+2];
            for(int j = 0; j < M+1; j++){
                visit[j] = false;
            }
            for(int j = 0; j < M+2; j++){
                st = new StringTokenizer(br.readLine());
                city[j][0] = Integer.parseInt(st.nextToken());
                city[j][1] = Integer.parseInt(st.nextToken());
            }
            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[]{city[0][0], city[0][1]});
            visit[0] = true;
            while(!q.isEmpty()){
                int[] y = q.poll();
                for(int j = 0; j < M+2; j++){
                    if(!visit[j]){
                        int lenght = Math.abs(y[0] - city[j][0]) + Math.abs(y[1] - city[j][1]);
                        if(lenght <= 1000){
                            visit[j] = true;
                            q.offer(new int[]{city[j][0], city[j][1]});
                        }
                    }
                }
            }
            if(visit[M+1] == true){
                answer[i] = "happy";
            }
            else{
                answer[i] = "sad";
            }
        }
        for(int i = 0; i < N; i++){
            System.out.println(answer[i]);
        }
    }
}
