import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] mx = {2,2,1,1,-2,-2,-1,-1};
        int[] my = {1,-1,2,-2,1,-1,2,-2};
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            int M = Integer.parseInt(br.readLine());
            int[][] map = new int[M][M];
            boolean[][] check = new boolean[M][M];
            st = new StringTokenizer(br.readLine());
            int x_s = Integer.parseInt(st.nextToken());
            int y_s = Integer.parseInt(st.nextToken());
            check[x_s][y_s] = true;
            st = new StringTokenizer(br.readLine());
            int x_e = Integer.parseInt(st.nextToken());
            int y_e = Integer.parseInt(st.nextToken());
            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[]{x_s, y_s});
            while (!q.isEmpty()){
                int[] y = q.poll();
                for(int j = 0; j < 8; j++){
                    int nx = y[0] + mx[j];
                    int ny = y[1] + my[j];
                    if(nx < 0 || nx >= M || ny < 0 || ny >= M){
                        continue;
                    }
                    if(check[nx][ny] == false){
                        check[nx][ny] = true;
                        map[nx][ny] = map[y[0]][y[1]] + 1;
                        q.offer(new int[]{nx,ny});
                    }
                }
            }
            System.out.println(map[x_e][y_e]);
        }
    }
}