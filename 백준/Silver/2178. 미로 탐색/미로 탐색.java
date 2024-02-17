import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        int[][] map_bfs = new int[N][M];
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                int num = str.charAt(j)-'0';
                map[i][j] = num;
                map_bfs[i][j] = 0;
            }
        }
        int cnt = 2;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        map_bfs[0][0] = 1;
        while(!q.isEmpty()){
            int[] y = q.poll();

            for(int i = 0; i < 4; i++){
                int nx = y[0] + dx[i];
                int ny = y[1] + dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }
                if(map[nx][ny] == 1 && map_bfs[nx][ny] == 0){
                    map_bfs[nx][ny] = map_bfs[y[0]][y[1]] + 1;
                    q.offer(new int[]{nx,ny});
                }
            }
        }
        System.out.println(map_bfs[N-1][M-1]);
    }
}
