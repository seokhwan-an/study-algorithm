import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int H = Integer.parseInt(input[0]);
        int W = Integer.parseInt(input[1]);

        List<Integer> walls = Arrays.stream(br.readLine().split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        int answer = 0;

        for (int i = 1; i < W; i++) {
            int leftHigh = 0;
            int rightHigh = 0;
            boolean hasLeftHigh = false;
            boolean hasRightHigh = false;
            int wall = walls.get(i);
            for (int j = i + 1; j < W; j++) {
                if (walls.get(j) > wall) {
                    rightHigh = Math.max(rightHigh, walls.get(j));
                    hasRightHigh = true;
                }
            }

            for (int j = i - 1; j >= 0; j--) {
                if (walls.get(j) > wall) {
                    leftHigh = Math.max(leftHigh, walls.get(j));
                    hasLeftHigh = true;
                }
            }
            if (hasLeftHigh && hasRightHigh) {
                answer += Math.min(leftHigh, rightHigh) - wall;
            }
        }

        System.out.println(answer);
    }
}
