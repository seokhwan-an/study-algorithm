import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[M][N];
        int[] m_x = {1,-1,-0,0};
        int[] m_y = {0,0,1,-1};
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1){
                    q.add(new int[]{i, j});
                }
            }
        }
        while(!q.isEmpty()){
            int[] y = q.poll();
            for(int i = 0; i < 4; i++){
                int n_x = y[0] + m_x[i];
                int n_y = y[1] + m_y[i];
                if(n_x < 0 || n_x >= M || n_y < 0 || n_y >= N){
                    continue;
                }
                if(map[n_x][n_y] == -1){
                    continue;
                }
                else if(map[n_x][n_y] == 0 || map[n_x][n_y] > map[y[0]][y[1]] + 1){
                    map[n_x][n_y] = map[y[0]][y[1]] + 1;
                    q.offer(new int[]{n_x,n_y});
                }
            }
        }
        int answer = 0;
        boolean check = true;
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] == 0){
                    answer = 0;
                    check = false;
                    break;
                }
                if(map[i][j] > answer){
                    answer = map[i][j];
                }
            }
            if(check == false){
                break;
            }
        }
        System.out.println(answer-1);
    }
}
