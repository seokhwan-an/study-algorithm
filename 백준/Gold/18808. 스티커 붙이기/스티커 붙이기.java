import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int h;
    static int w;
    static int[][] laptop;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        h = Integer.parseInt(inputs[0]);
        w = Integer.parseInt(inputs[1]);
        int stickerCnt = Integer.parseInt(inputs[2]);

        laptop = new int[h][w];
        List<int[][]> stickers = new ArrayList<>();

        for (int i = 0; i < stickerCnt; i++) {
            String[] stickerInputs = br.readLine().split(" ");
            int stickerH = Integer.parseInt(stickerInputs[0]);
            int stickerW = Integer.parseInt(stickerInputs[1]);
            int[][] sticker = new int[stickerH][stickerW];

            for (int j = 0; j < stickerH; j++) {
                String[] stickerInfo = br.readLine().split(" ");
                for (int k = 0; k < stickerW; k++) {
                    sticker[j][k] = Integer.parseInt(stickerInfo[k]);
                }
            }

            stickers.add(sticker);
        }

        for (int[][] sticker : stickers) {
            for (int i = 0; i < 4; i++) {
                int[][] turnedSticker = switchSticker(i, sticker);
                if (isAvailableStick(turnedSticker)) {
                    break;
                }
            }
        }

        System.out.println(answer);
    }

    private static int[][] switchSticker(int type, int[][] sticker) {
        int[][] turnedSticker;
        int row = sticker.length;
        int col = sticker[0].length;

        if (type == 1) {
            turnedSticker = new int[col][row];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    turnedSticker[j][row - i - 1] = sticker[i][j];
                }
            }
            return turnedSticker;
        }

        if (type == 2) {
            turnedSticker = new int[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    turnedSticker[row - i - 1][col - j - 1] = sticker[i][j];
                }
            }
            return turnedSticker;
        }

        if (type == 3) {
            turnedSticker = new int[col][row];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    turnedSticker[col - j - 1][i] = sticker[i][j];
                }
            }
            return turnedSticker;
        }

        return sticker;
    }

    private static boolean isAvailableStick(int[][] sticker) {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (canStick(sticker, i, j)) {
                    stick(sticker, i, j);
                    return true;
                }
            }
        }
        return false;
    }

    // 붙일 수 있는지 체크
    private static boolean canStick(int[][] sticker, int startX, int startY) {
        // 노트북이 모두 비어 있는지 체크하기
        for (int i = 0; i < sticker.length; i++) {
            for (int j = 0; j < sticker[0].length; j++) {
                int nx = startX + i;
                int ny = startY + j;
                if (sticker[i][j] == 1) {
                    if (!(nx < h && ny < w && laptop[nx][ny] == 0)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static void stick(int[][] sticker, int startX, int startY) {
        for (int i = 0; i < sticker.length; i++) {
            for (int j = 0; j < sticker[0].length; j++) {
                if (sticker[i][j] == 1) {
                    answer++;
                    laptop[i + startX][j + startY] = 1;
                }
            }
        }
    }

}
