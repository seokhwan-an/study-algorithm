import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15686 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int h_cnt = 0;
        int c_cnt = 0;
        int[][] map = new int[N][N];
        ArrayList<int[]> home = new ArrayList<>();
        ArrayList<int[]> chicken = new ArrayList<>();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1){
                    home.add(new int[]{i,j});
                    h_cnt++;
                }
                else if(map[i][j] == 2){
                    chicken.add(new int[]{i,j});
                    c_cnt++;
                }
            }
        }
        int[][] check = new int[h_cnt][c_cnt];
        for(int i = 0; i < home.size(); i++){
            for(int j = 0; j < chicken.size(); j++){
                int distance = Math.abs(home.get(i)[0] - chicken.get(j)[0]) + Math.abs(home.get(i)[1] - chicken.get(j)[1]);
                check[i][j] = distance;
            }
        }
        int answer = 0;

    }
}
