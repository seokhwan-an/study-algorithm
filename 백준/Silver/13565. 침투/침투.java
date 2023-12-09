import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class Main{
	static boolean check;
	static int[][] map;
	static int M;
	static int N;
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        check = false;
        for(int i = 0; i < M; i++) {
        	String str = br.readLine();
        	for(int j = 0; j < N; j++) {
        		map[i][j] = str.charAt(j)-'0';
        	}
        }
        for(int i = 0; i < N; i++) {
        	dfs(0,i);
        }
        for(int i = 0; i < N; i++) {
        	if(map[M-1][i] == 2) check = true;
        }
		
        if(check)System.out.println("YES");
        else System.out.println("NO");
    }
	public static void dfs(int x, int y) {
		if(x < 0 || x >= M || y < 0 || y >= N) {
			return;
		}
		if(map[x][y] == 0) {
			map[x][y] = 2;
			dfs(x-1, y);
			dfs(x+1, y);
			dfs(x, y-1);
			dfs(x, y+1);
		}
	}
}
