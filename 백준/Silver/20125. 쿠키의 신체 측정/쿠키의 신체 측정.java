import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[][] map = new String[n][n];
        for (int i = 0; i < n; i++) {
            String[] lineInput = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                map[i][j] = lineInput[j];
            }
        }
        int[] head = findHead(map);
        int[] heart = new int[] {head[0] + 1, head[1]};
        int left = findLeft(map, heart);
        int right = findRight(map, heart);
        int mid = findMid(map, heart);
        int leftLeg = findLeftLeg(map, heart, mid);
        int rightLeg = findRightLeg(map, heart, mid);

        System.out.println((heart[0] + 1) + " " + (heart[1] + 1));
        System.out.println(left + " " + right + " " + mid + " " + leftLeg + " " + rightLeg);
    }

    private static int[] findHead(String[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j].equals("*")) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[]{0, 0};
    }

    private static int findLeft(String[][] map, int[] heart) {
        int left = 0;
        int start = heart[1];
        for (int i = start - 1; i >= 0; i--) {
            if (map[heart[0]][i].equals("*")) {
                left++;
            } else {
                break;
            }
        }

        return left;
    }

    private static int findRight(String[][] map, int[] heart) {
        int right = 0;
        int start = heart[1];
        for (int i = start + 1; i < map[0].length; i++) {
            if (map[heart[0]][i].equals("*")) {
                right++;
            } else {
                break;
            }
        }

        return right;
    }

    private static int findMid(String[][] map, int[] heart) {
        int mid = 0;
        int start = heart[0];
        for (int i = start + 1; i < map.length; i++) {
            if (map[i][heart[1]].equals("*")) {
                mid++;
            } else {
                break;
            }
        }

        return mid;
    }

    private static int findLeftLeg(String[][] map, int[] heart, int mid) {
        int left = 0;
        int start = heart[0] + mid + 1;
        for (int i = start; i < map.length; i++) {
            if (map[i][heart[1] - 1].equals("*")) {
                left++;
            } else {
                break;
            }
        }

        return left;
    }

    private static int findRightLeg(String[][] map, int[] heart, int mid) {
        int right = 0;
        int start = heart[0] + mid + 1;
        for (int i = start; i < map.length; i++) {
            if (map[i][heart[1] + 1].equals("*")) {
                right++;
            } else {
                break;
            }
        }
        return right;
    }
}
