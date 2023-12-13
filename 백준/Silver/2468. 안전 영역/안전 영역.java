import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] moveX = {1, 0, -1, 0};
    static int[] moveY = {0, 1, 0, -1};
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        int max = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int height = Integer.parseInt(st.nextToken());
                max = Math.max(height, max);
                map[i][j] = height;
            }
        }
        
        for (int i = 0; i < max; i++) {
            findSafeArea(i);
        }

        System.out.println(answer);
    }

    private static void findSafeArea(int rainHeight) {
        int cnt = 0;
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] == false && map[i][j] > rainHeight) {
                    cnt++;
                    dfs(i, j, rainHeight);
                }
            }
        }
        answer = Math.max(answer, cnt);
    }

    private static void dfs(int x, int y, int rainHeight) {
        if (x < 0 || y < 0 || x >= N || y >= N) {
            return;
        }
        if (visited[x][y] == false && map[x][y] > rainHeight) {
            visited[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int nx = x + moveX[i];
                int ny = y + moveY[i];
                dfs(nx, ny, rainHeight);
            }
        }
    }
}
