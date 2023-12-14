import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int M;
    static int N;
    static int square;
    static int[][] map;
    static int cnt;
    static ArrayList<Integer> answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        square = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        cnt = 0;
        answer = new ArrayList<Integer>();
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                map[i][j] = 0;
            }
        }
        for(int i = 0; i < square; i++){
            st = new StringTokenizer(br.readLine());
            int y_s = Integer.parseInt(st.nextToken());
            int x_s = Integer.parseInt(st.nextToken());
            int y_e = Integer.parseInt(st.nextToken());
            int x_e = Integer.parseInt(st.nextToken());
            for(int j = x_s ; j < x_e; j++){
                for(int k = y_s; k < y_e; k++){
                    map[j][k] = 1;
                }
            }
        }
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] == 0){
                    dfs(i,j);
                    answer.add(cnt);
                    cnt = 0;
                }
            }
        }
        System.out.println(answer.size());
        answer.sort(Comparator.naturalOrder());
        for(int i = 0; i < answer.size(); i++){
            System.out.print(answer.get(i)+" ");
        }
    }
    public static void dfs(int x, int y){
        if(x < 0 || x >= M || y < 0 || y>= N){
            return;
        }
        if(map[x][y] == 0){
            map[x][y] = 2;
            cnt++;
            dfs(x,y-1);
            dfs(x,y+1);
            dfs(x-1,y);
            dfs(x+1,y);
        }
    }
}
