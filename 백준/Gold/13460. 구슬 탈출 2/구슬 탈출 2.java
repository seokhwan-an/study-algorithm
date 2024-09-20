import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static class Ball {
        int x;
        int y;

        public Ball(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class MoveInfo {
        Ball red;
        Ball blue;
        int moveCnt;

        public MoveInfo(Ball red, Ball blue, int moveCnt) {
            this.red = red;
            this.blue = blue;
            this.moveCnt = moveCnt;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] mapInfo = br.readLine().split(" ");
        int h = Integer.parseInt(mapInfo[0]);
        int w = Integer.parseInt(mapInfo[1]);
        int answer = Integer.MAX_VALUE;

        String[][] map = new String[h][w];

        Ball red = new Ball(0, 0);
        Ball blue = new Ball(0, 0);
        int desX = 0;
        int desY = 0;
        for (int i = 0; i < h; i++) {
            String[] lineInfo = br.readLine().split("");
            for (int j = 0; j < w; j++) {
                String pointInfo = lineInfo[j];
                map[i][j] = pointInfo;

                if (pointInfo.equals("R")) {
                    red = new Ball(i, j);
                    map[i][j] = ".";
                }

                if (pointInfo.equals("B")) {
                    blue = new Ball(i, j);
                    map[i][j] = ".";
                }

                if (pointInfo.equals("O")) {
                    desX = i;
                    desY = j;
                }
            }
        }

        Queue<MoveInfo> queue = new LinkedList<>();
        queue.offer(new MoveInfo(red, blue, 0));

        while (!queue.isEmpty()) {
            MoveInfo moveInfo = queue.poll();

            if (answer != Integer.MAX_VALUE) {
                break;
            }

            if (moveInfo.moveCnt >= 10) {
                continue;
            }
            Ball r = moveInfo.red;
            Ball b = moveInfo.blue;
            Ball nextR = new Ball(0, 0);
            Ball nextB = new Ball(0, 0);
            // 0 : 동쪽, 1 : 서쪽, 2: 남쪽, 3: 북쪽
            for (int i = 0; i < 4; i++) {
                int[] redNextPosition = new int[3];
                int[] blueNextPosition = new int[3];
                if (i == 0) {
                    if (r.y >= b.y) {
                        redNextPosition = move(i, moveInfo.red, moveInfo.blue, map, desX, desY);
                        nextR = new Ball(redNextPosition[0], redNextPosition[1]);
                        blueNextPosition = move(i, moveInfo.blue, nextR, map, desX, desY);
                        nextB = new Ball(blueNextPosition[0], blueNextPosition[1]);
                    } else {
                        blueNextPosition = move(i, moveInfo.blue, moveInfo.red, map, desX, desY);
                        nextB = new Ball(blueNextPosition[0], blueNextPosition[1]);
                        redNextPosition = move(i, moveInfo.red, nextB, map, desX, desY);
                        nextR = new Ball(redNextPosition[0], redNextPosition[1]);
                    }

                }

                if (i == 1) {
                    if (r.y <= b.y) {
                        redNextPosition = move(i, moveInfo.red, moveInfo.blue, map, desX, desY);
                        nextR = new Ball(redNextPosition[0], redNextPosition[1]);
                        blueNextPosition = move(i, moveInfo.blue, nextR, map, desX, desY);
                        nextB = new Ball(blueNextPosition[0], blueNextPosition[1]);
                    } else {
                        blueNextPosition = move(i, moveInfo.blue, moveInfo.red, map, desX, desY);
                        nextB = new Ball(blueNextPosition[0], blueNextPosition[1]);
                        redNextPosition = move(i, moveInfo.red, nextB, map, desX, desY);
                        nextR = new Ball(redNextPosition[0], redNextPosition[1]);
                    }
                }

                if (i == 2) {
                    if (r.x >= b.x) {
                        redNextPosition = move(i, moveInfo.red, moveInfo.blue, map, desX, desY);
                        nextR = new Ball(redNextPosition[0], redNextPosition[1]);
                        blueNextPosition = move(i, moveInfo.blue, nextR, map, desX, desY);
                        nextB = new Ball(blueNextPosition[0], blueNextPosition[1]);
                    } else {
                        blueNextPosition = move(i, moveInfo.blue, moveInfo.red, map, desX, desY);
                        nextB = new Ball(blueNextPosition[0], blueNextPosition[1]);
                        redNextPosition = move(i, moveInfo.red, nextB, map, desX, desY);
                        nextR = new Ball(redNextPosition[0], redNextPosition[1]);
                    }
                }

                if (i == 3) {
                    if (r.x <= b.x) {
                        redNextPosition = move(i, moveInfo.red, moveInfo.blue, map, desX, desY);
                        nextR = new Ball(redNextPosition[0], redNextPosition[1]);
                        blueNextPosition = move(i, moveInfo.blue, nextR, map, desX, desY);
                        nextB = new Ball(blueNextPosition[0], blueNextPosition[1]);
                    } else {
                        blueNextPosition = move(i, moveInfo.blue, moveInfo.red, map, desX, desY);
                        nextB = new Ball(blueNextPosition[0], blueNextPosition[1]);
                        redNextPosition = move(i, moveInfo.red, nextB, map, desX, desY);
                        nextR = new Ball(redNextPosition[0], redNextPosition[1]);
                    }
                }

                if (nextR.x == r.x && nextR.y == r.y && nextB.x == b.x && nextB.y == b.y) {
                    continue;
                }

                if (blueNextPosition[2] == 1) {
                    continue;
                }

                if (redNextPosition[2] == 1) {
                    answer = Math.min(answer, moveInfo.moveCnt + 1);
                }

                queue.offer(new MoveInfo(nextR, nextB, moveInfo.moveCnt + 1));
            }
        }

        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    private static int[] move(int dir, Ball move, Ball notMove, String[][] map, int desX, int desY) {
        int[] position = new int[3];

        // 동쪽
        if (dir == 0) {
            position[0] = move.x;

            for (int i = move.y + 1; i < map[0].length; i++) {
                String next = map[move.x][i];
                if (move.x == desX && i == desY) {
                    position[2] = 1;
                }
                if (move.x == notMove.x && i == notMove.y) {
                    position[1] = i - 1;
                    break;
                }

                if (next.equals("#")) {
                    position[1] = i - 1;
                    break;
                }
            }
        }
        // 서쪽
        if (dir == 1) {
            position[0] = move.x;

            for (int i = move.y - 1; i >= 0; i--) {
                String next = map[move.x][i];
                if (move.x == desX && i == desY) {
                    position[2] = 1;
                }
                if (move.x == notMove.x && i == notMove.y) {
                    position[1] = i + 1;
                    break;
                }

                if (next.equals("#")) {
                    position[1] = i + 1;
                    break;
                }
            }
        }

        if (dir == 2) {
            position[1] = move.y;

            for (int i = move.x + 1; i < map.length; i++) {
                String next = map[i][move.y];
                if (i == desX && move.y == desY) {
                    position[2] = 1;
                }
                if (i == notMove.x && move.y == notMove.y) {
                    position[0] = i - 1;
                    break;
                }

                if (next.equals("#")) {
                    position[0] = i - 1;
                    break;
                }
            }
        }

        if (dir == 3) {
            position[1] = move.y;

            for (int i = move.x - 1; i >= 0; i--) {
                if (i == desX && move.y == desY) {
                    position[2] = 1;
                }
                String next = map[i][move.y];

                if (i == notMove.x && move.y == notMove.y) {
                    position[0] = i + 1;
                    break;
                }

                if (next.equals("#")) {
                    position[0] = i + 1;
                    break;
                }
            }
        }
        return position;
    }
}
