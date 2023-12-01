import java.util.Scanner;

public class Main {

    static int[][] paper;
    static int paper1 = 0;
    static int paper2 = 0;
    static int paper3 = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                paper[i][j] = sc.nextInt();
            }
        }

        checkPaper(0, 0, N);
        System.out.println(paper1);
        System.out.println(paper2);
        System.out.println(paper3);
    }

    private static void checkPaper(int row, int col, int size) {
        if (isOnePaper(row, col, size)) {
            if (paper[row][col] == -1) {
                paper1++;
            }
            if (paper[row][col] == 0) {
                paper2++;
            }
            if (paper[row][col] == 1) {
                paper3++;
            }
            return;
        }

        int dividedSize = size / 3;

        checkPaper(row, col, dividedSize);
        checkPaper(row, col + dividedSize, dividedSize);
        checkPaper(row, col + 2 * dividedSize, dividedSize);

        checkPaper(row + dividedSize, col, dividedSize);
        checkPaper(row + dividedSize, col + dividedSize, dividedSize);
        checkPaper(row + dividedSize, col + 2 * dividedSize, dividedSize);

        checkPaper(row + 2 * dividedSize, col, dividedSize);
        checkPaper(row + 2 * dividedSize, col + dividedSize, dividedSize);
        checkPaper(row + 2 * dividedSize, col + 2 * dividedSize, dividedSize);
    }

    private static boolean isOnePaper(int row, int col, int size) {
        int paperNumber = paper[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (paperNumber != paper[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}

