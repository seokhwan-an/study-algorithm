import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][] gears = new int[4][8];
    static int[] gearPoints = new int[4];
    static boolean[] isMovable;
    static int[] moveDirs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;

        for (int i = 0; i < 4; i++) {
            String[] gearInputs = br.readLine().split("");
            for (int j = 0; j < 8; j++) {
                gears[i][j] = Integer.parseInt(gearInputs[j]);
            }
        }

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            moveDirs = new int[4];
            String[] moveInput = br.readLine().split(" ");
            int gear = Integer.parseInt(moveInput[0]) - 1;
            int moveDir = Integer.parseInt(moveInput[1]);
            move(gear, moveDir);
        }

        for (int i = 0; i < 4; i++) {
            if (i == 0 && gears[i][gearPoints[i]] == 1) {
                answer += 1;
            }
            if (i == 1 && gears[i][gearPoints[i]] == 1) {
                answer += 2;
            }
            if (i == 2 && gears[i][gearPoints[i]] == 1) {
                answer += 4;
            }
            if (i == 3 && gears[i][gearPoints[i]] == 1) {
                answer += 8;
            }
        }

        System.out.println(answer);
    }

    private static void move(int gear, int moveDir) {
        isMovable = new boolean[4];
        isMovable[gear] = true;
        moveDirs[gear] = moveDir;
        checkRightGear(gear, moveDir);
        checkLeftGear(gear, moveDir);

        for (int i = 0; i < 4; i++) {
            if (isMovable[i]) {
                if (moveDirs[i] == 1) {
                    gearPoints[i] = (gearPoints[i] + 7) % 8;
                }
                if (moveDirs[i] == -1) {
                    gearPoints[i] = (gearPoints[i] + 1) % 8;
                }
            }
        }
    }

    private static void checkRightGear(int gear, int moveDir) {
        for (int i = gear; i < 3; i++) {
            int rightGear = i + 1;
            int gearRightPoint = gears[i][(gearPoints[i] + 2) % 8];
            int rightGearLeftPoint = gears[rightGear][(gearPoints[rightGear] + 6) % 8];
            if (gearRightPoint - rightGearLeftPoint == 0) {
                break;
            }
            isMovable[rightGear] = true;
            if (moveDirs[i] == 1) {
                moveDirs[rightGear] = -1;
            } else {
                moveDirs[rightGear] = 1;
            }
        }
    }

    private static void checkLeftGear(int gear, int moveDir) {
        for (int i = gear; i >= 1; i--) {
            int leftGear = i - 1;
            int gearLeftPoint = gears[i][(gearPoints[i] + 6) % 8];
            int leftGearRightPoint = gears[leftGear][(gearPoints[leftGear] + 2) % 8];
            if (gearLeftPoint - leftGearRightPoint == 0) {
                break;
            }

            isMovable[leftGear] = true;
            if (moveDirs[i] == 1) {
                moveDirs[leftGear] = -1;
            } else {
                moveDirs[leftGear] = 1;
            }
        }
    }
}
