import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14716 {
    static int N;
    static int M;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 1){
                    answer++;
                    dfs(i,j);
                }
            }
        }
        System.out.println(answer);
    }

    public static void dfs(int x, int y) {
        if(x < 0 || x >= N || y < 0 || y >= M){
            return;
        }
        if(map[x][y] == 1){
            map[x][y] = 2;
            dfs(x-1,y);
            dfs(x+1,y);
            dfs(x,y-1);
            dfs(x,y+1);
            dfs(x-1,y-1);
            dfs(x-1,y+1);
            dfs(x+1,y-1);
            dfs(x+1,y+1);
        }
    }
}

