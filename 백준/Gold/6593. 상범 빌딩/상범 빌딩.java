import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int h;
    static int l;
    static int w;
    static int[][][] map;

    static Queue<int[]> queue;

    static int[] dh = {1, -1, 0, 0, 0, 0};
    static int[] dl = {0, 0, 1, -1, 0, 0};
    static int[] dw = {0, 0, 0, 0, 1, -1};

    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String[] mapInput = br.readLine().split(" ");
            h = Integer.parseInt(mapInput[0]);
            l = Integer.parseInt(mapInput[1]);
            w = Integer.parseInt(mapInput[2]);

            if (h == 0 && l == 0 && w == 0) {
                break;
            }
            map = new int[h][l][w];
            queue = new LinkedList<>();

            int eh = 0;
            int el = 0;
            int ew = 0;

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < l; j++) {
                    String[] lineInput = br.readLine().split("");
                    for (int k = 0; k < w; k++) {
                        if (lineInput[k].equals("#")) {
                            map[i][j][k] = 1;
                        }

                        if (lineInput[k].equals("S")) {
                            queue.offer(new int[]{i, j, k, 0});
                        }

                        if (lineInput[k].equals("E")) {
                            eh = i;
                            el = j;
                            ew = k;
                        }
                    }
                }
                String next = br.readLine();
            }

            answer = 0;
            move(eh, el, ew);

            if (answer == 0) {
                sb.append("Trapped!\n");
            } else {
                sb.append(String.format("Escaped in %d minute(s).\n", answer));
            }
        }

        System.out.println(sb.toString());
    }

    private static void move(int eh, int el, int ew) {
        boolean[][][] visited = new boolean[h][l][w];
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            visited[p[0]][p[1]][p[2]] = true;

            for (int i = 0; i < 6; i++) {
                int nh = p[0] + dh[i];
                int nl = p[1] + dl[i];
                int nw = p[2] + dw[i];

                if (nh == eh && nl == el && nw == ew) {
                    answer = p[3] + 1;
                    return;
                }
                if (nh < 0 || nh >= h || nl < 0 || nl >= l || nw < 0 || nw >= w) {
                    continue;
                }

                if (map[nh][nl][nw] == 1) {
                    continue;
                }

                if (!visited[nh][nl][nw]) {
                    visited[nh][nl][nw] = true;
                    queue.offer(new int[] {nh, nl, nw, p[3] + 1});
                }
            }
        }
    }
}
