import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10026 {
    static int N;
    static char[][] map1;
    static char[][] map2;
    static int cnt1;
    static int cnt2;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map1 = new char[N][N];
        map2 = new char[N][N];
        cnt1 = 0;
        cnt2 = 0;
        for(int i = 0 ; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map1[i][j] = str.charAt(j);
                map2[i][j] = str.charAt(j);
            }
        }
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map1[i][j] == 'R') {
                    R(i, j);
                    cnt1++;
                }
                if (map1[i][j] == 'G'){
                    G(i, j);
                    cnt1++;
                }
                if (map1[i][j] == 'B') {
                    B(i, j);
                    cnt1++;
                }
                if (map2[i][j] == 'R' || map2[i][j] == 'G'){
                    R_G(i, j);
                    cnt2++;
                }
                if (map2[i][j] == 'B'){
                    B2(i, j);
                    cnt2++;
                }
            }
        }
        System.out.println(cnt1+" "+cnt2);
    }
    public static void R(int x, int y){
        if(x<0 || x >= N || y < 0 || y >= N){
            return;
        }
        if(map1[x][y] == 'R'){
            map1[x][y] = 'C';
            R(x-1,y);
            R(x+1,y);
            R(x,y-1);
            R(x,y+1);
        }
    }
    public static void B(int x, int y){
        if(x<0 || x >= N || y < 0 || y >= N){
            return;
        }
        if(map1[x][y] == 'B'){
            map1[x][y] = 'C';
            B(x-1,y);
            B(x+1,y);
            B(x,y-1);
            B(x,y+1);
        }
    }
    public static void G(int x, int y){
        if(x<0 || x >= N || y < 0 || y >= N){
            return;
        }
        if(map1[x][y] == 'G'){
            map1[x][y] = 'C';
            G(x-1,y);
            G(x+1,y);
            G(x,y-1);
            G(x,y+1);
        }
    }
    public static void R_G(int x, int y){
        if(x<0 || x >= N || y < 0 || y >= N){
            return;
        }
        if(map2[x][y] == 'R' || map2[x][y] == 'G'){
            map2[x][y] = 'C';
            R_G(x-1,y);
            R_G(x+1,y);
            R_G(x,y-1);
            R_G(x,y+1);
        }
    }
    public static void B2(int x, int y){
        if(x<0 || x >= N || y < 0 || y >= N){
            return;
        }
        if(map2[x][y] == 'B'){
            map2[x][y] = 'C';
            B2(x-1,y);
            B2(x+1,y);
            B2(x,y-1);
            B2(x,y+1);
        }
    }
}
