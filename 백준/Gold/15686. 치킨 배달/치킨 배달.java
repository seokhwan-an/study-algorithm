import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int N;
    static int M;
    static int chickenCnt = 0;
    static List<int[]> chickenLocs = new ArrayList<>();
    static List<int[]> houseLocs = new ArrayList<>();
    static boolean[][] isClosed;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);

        init(br);
        solution(-1, 0);
        System.out.println(answer);
    }

    private static void init(BufferedReader br) throws IOException {
        isClosed = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String[] lineInputs = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(lineInputs[j]);
                if (value == 1) {
                    houseLocs.add(new int[]{i, j});
                }
                if (value == 2) {
                    chickenCnt++;
                    chickenLocs.add(new int[]{i, j});

                }
            }
        }
    }

    private static void solution(int pre, int n) {
        if (n == chickenCnt - M) {
            int chickenLength = 0;
            for (int[] houseLoc : houseLocs) {
                int x = houseLoc[0];
                int y = houseLoc[1];
                chickenLength += getChickenLength(x, y);
            }
            answer = Math.min(answer, chickenLength);
            return;
        }

        for (int i = 0; i < chickenLocs.size(); i++) {
            if (i > pre) {
                final int[] chickLoc = chickenLocs.get(i);
                isClosed[chickLoc[0]][chickLoc[1]] = true;
                solution(i, n + 1);
                isClosed[chickLoc[0]][chickLoc[1]] = false;
            }
        }
    }

    private static int getChickenLength(int x, int y) {
        int length = Integer.MAX_VALUE;
        for (int[] chickenLoc : chickenLocs) {
            int chickenLocX = chickenLoc[0];
            int chickenLocY = chickenLoc[1];
            if (!isClosed[chickenLocX][chickenLocY]) {
                length = Math.min(length, Math.abs(chickenLocX - x) + Math.abs(chickenLocY - y));
            }
        }
        return length;
    }
}
