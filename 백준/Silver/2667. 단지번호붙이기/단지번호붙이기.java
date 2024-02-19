import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int city_cnt;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        city_cnt = 0;
        ArrayList<Integer> town = new ArrayList<>();
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < N; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                dfs(i,j);
                if(city_cnt > 0){
                    town.add(city_cnt);
                    city_cnt = 0;
                }
            }
        }
        System.out.println(town.size());
        town.sort(Comparator.naturalOrder());
        for(int i = 0; i < town.size(); i++){
            System.out.println(town.get(i));
        }
    }
    public static void dfs(int x, int y){
        if(x<0 || x >= N || y < 0 || y >= N) {
            return;
        }
        if(map[x][y] == 1){
            city_cnt++;
            map[x][y] = 2;
            dfs(x-1,y);
            dfs(x+1,y);
            dfs(x,y-1);
            dfs(x,y+1);
        }
    }
}
