import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class BOJ_2468 {
    static int N;
    static int[][] map;
    static boolean[][] check;
    static int max;
    static int cnt;
    static int answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                int num = Integer.parseInt(st.nextToken());
                if(num > max) {
                    max = num;
                }
                map[i][j] = num;
            }
        }
        answer = 0;
        for(int i = 0; i <= max; i++){ // 빗물의 높이
            check = new boolean[N][N]; // 방문 여부
            cnt = 0;
            for(int j = 0; j < N; j++){
                for(int k = 0; k < N; k++){
                    if(check[j][k] == false && map[j][k] > i){ // 방문하지 않았고 물에 잠기지 않을 때
                        cnt++;
                        dfs(j,k,i);
                    }
                }
            }
            answer = Math.max(answer,cnt);
        }
        System.out.println(answer);
    }
    public static void dfs(int x, int y, int z){
        if(x < 0 || x >= N || y < 0 || y >= N){
            return;
        }
        if(check[x][y] == false && map[x][y] > z){
            check[x][y] = true;
            dfs(x+1,y,z);
            dfs(x-1,y,z);
            dfs(x,y-1,z);
            dfs(x,y+1,z);
        }
    }
}
