import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1926 {
    public static int n;
    public static int m;
    public static int[][] draw;
    public static int check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        draw = new int[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                draw[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int cnt = 0;
        check = 2;
        int answer = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(draw[i][j] == 1){
                    cnt++;
                    dfs(i,j);
                    check -= 2;
                    answer = Math.max(answer,check);
                    check = 2;
                }
            }
        }
        System.out.println(cnt);
        System.out.println(answer);
    }
    public static void dfs(int x, int y){
        if(x < 0 || x >= n || y < 0 || y >= m){
            return;
        }
        if(draw[x][y] == 1){
            draw[x][y] = check;
            check++;
            dfs(x-1,y);
            dfs(x+1,y);
            dfs(x,y-1);
            dfs(x,y+1);
        }
    }
}
