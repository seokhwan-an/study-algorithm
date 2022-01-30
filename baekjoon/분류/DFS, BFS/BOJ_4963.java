import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_4963 {
    static int[][] map;
    static int w;
    static int h;
    static int island;
    static ArrayList<Integer> answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        answer = new ArrayList<Integer>();
        while(w !=0 && h !=0){
            map = new int[h][w];
            for(int i = 0; i < h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < w; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            island = 0;
            for(int i = 0; i < h; i++){
                for(int j = 0; j < w; j++){
                    if(map[i][j] == 1){
                        dfs(i,j);
                        island++;
                    }
                }
            }
            answer.add(island);
            island = 0;
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < answer.size(); i++){
            System.out.println(answer.get(i));
        }
    }
    public static void dfs(int x, int y){
        if(x < 0 || x >= h || y < 0 || y >= w) {
            return;
        }
        if(map[x][y] == 1){
            map[x][y] = 2;
            dfs(x+1,y);
            dfs(x-1,y);
            dfs(x,y+1);
            dfs(x,y-1);
            dfs(x-1,y-1);
            dfs(x+1,y-1);
            dfs(x-1,y+1);
            dfs(x+1,y+1);
        }
    }
}
