import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1743 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        int answer = 0;
        int check = 0;
        int[] mx = {1,-1,0,0};
        int[] my = {0,0,1,-1};
        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x-1][y-1] = 1;
        }
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 1 && visited[i][j]==false){
                    check++;
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                    while(!q.isEmpty()){
                        int[] y = q.poll();
                        for(int k = 0; k < 4; k++){
                            int nx = y[0] + mx[k];
                            int ny = y[1] + my[k];
                            if(nx < 0 || nx >= N || ny < 0 || ny >= M){
                                continue;
                            }
                            if(map[nx][ny] == 1 && visited[nx][ny] == false){
                                check++;
                                visited[nx][ny] = true;
                                q.offer(new int[]{nx,ny});
                            }
                        }
                    }
                    answer = Math.max(answer, check);
                    check = 0;
                }
            }
        }
        System.out.println(answer);
    }
}
