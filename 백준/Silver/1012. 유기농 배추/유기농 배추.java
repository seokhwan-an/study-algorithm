import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int M; // 가로(열)
    static int N; // 세로(행)
    static int K;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        int[] answer = new int[T];
        int check = 0;
        for(int i = 0; i < T; i++){
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N+1][M+1];
            for(int j = 0; j < N+1; j++){
                for(int k = 0; k < M+1; k++){
                    map[j][k] = 0;
                }
            }
            for(int j = 0; j < K; j++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                map[b][a] = 1;
            }
            int cnt = 0;
            for(int j = 0; j <N+1; j++){
                for(int k = 0; k < M+1; k++){
                    if(map[j][k] == 1){
                        cnt++;
                        dfs(j,k);
                    }
                }
            }
            answer[check++] = cnt;
        }
        for(int i = 0; i < check; i++){
            System.out.println(answer[i]);
        }
    }
    public static void dfs(int x,int y){
        if(x < 0 || x >= N+1 || y < 0 || y >= M+1 ) return;
        if(map[x][y] == 1) {
            map[x][y] = 2;
            dfs(x-1,y);
            dfs(x+1,y);
            dfs(x,y-1);
            dfs(x,y+1);
        }
    }
}
