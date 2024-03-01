import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[][] map;
    static int[][] copiedMap;
    static int[] move;
    static boolean[] visited;
    static int answer = 0;
    static int moveCnt = 5;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        copiedMap = new int[N][N];
        move = new int[moveCnt];
        visited = new boolean[moveCnt];

        for (int i = 0; i < N; i++) {
            String[] lineInputs = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(lineInputs[j]);
            }
        }

        solution(0);
        System.out.println(answer);
    }

    private static void solution(int n) {
        if (n == moveCnt) {
            move();
            answer = Math.max(getMaxNumber(), answer);
            return;
        }

        for (int i = 1; i <= 4; i++) {
            if (!visited[n]) {
                visited[n] = true;
                move[n] = i;
                solution(n + 1);
                visited[n] = false;
            }
        }
    }

    private static int getMaxNumber() {
        int number = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                number = Math.max(number, copiedMap[i][j]);
            }
        }

        return number;
    }

    private static void move() {
        copy();
        for (int i = 0; i < moveCnt; i++) {
            int moveDir = move[i];
            if (moveDir == 1) {
                moveUp();
            }

            if (moveDir == 2) {
                moveDown();
            }

            if (moveDir == 3) {
                moveLeft();
            }

            if (moveDir == 4) {
                moveRight();
            }
        }
    }

    private static void copy() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                copiedMap[i][j] = map[i][j];
            }
        }
    }

    private static void moveUp() {
        for(int i = 0; i < N; i++) {
            int index = 0;
            int block = 0;
            for(int j = 0; j < N; j++) {
                if(copiedMap[j][i] != 0) {
                    if(block == copiedMap[j][i]) {
                        copiedMap[index - 1][i] = block * 2;
                        block = 0;
                        copiedMap[j][i] = 0;
                    }
                    else {
                        block = copiedMap[j][i];
                        copiedMap[j][i] = 0;
                        copiedMap[index][i] = block;
                        index++;
                    }
                }
            }
        }
    }

    private static void moveDown() {
        for(int i = 0; i < N; i++) {
            int index = N - 1;
            int block = 0;
            for(int j = N - 1; j >= 0; j--) {
                if(copiedMap[j][i] != 0) {
                    if(block == copiedMap[j][i]) {
                        copiedMap[index + 1][i] = block * 2;
                        block = 0;
                        copiedMap[j][i] = 0;
                    }
                    else {
                        block = copiedMap[j][i];
                        copiedMap[j][i] = 0;
                        copiedMap[index][i] = block;
                        index--;
                    }
                }
            }
        }
    }

    private static void moveLeft() {
        for(int i = 0; i < N; i++) {
            int index = 0;
            int block = 0;
            for(int j = 0; j < N; j++) {
                if(copiedMap[i][j] != 0) {
                    if(block == copiedMap[i][j]) {
                        copiedMap[i][index - 1] = block * 2;
                        block = 0;
                        copiedMap[i][j] = 0;
                    }
                    else {
                        block = copiedMap[i][j];
                        copiedMap[i][j] = 0;
                        copiedMap[i][index] = block;
                        index++;
                    }
                }
            }
        }
    }

    private static void moveRight() {
        for(int i = 0; i < N; i++) {
            int index = N - 1;
            int block = 0;
            for(int j = N - 1; j >= 0; j--) {
                if(copiedMap[i][j] != 0) {
                    if(block == copiedMap[i][j]) {
                        copiedMap[i][index + 1] = block * 2;
                        block = 0;
                        copiedMap[i][j] = 0;
                    }
                    else {
                        block = copiedMap[i][j];
                        copiedMap[i][j] = 0;
                        copiedMap[i][index] = block;
                        index--;
                    }
                }
            }
        }
    }
}
