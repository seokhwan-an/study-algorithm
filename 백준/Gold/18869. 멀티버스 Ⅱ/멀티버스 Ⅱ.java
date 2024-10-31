import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int[][] universe = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] unitInput = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                universe[i][j] = Integer.parseInt(unitInput[j]);
            }
        }

        int[][] change = changeUniverse(universe);
        int answer = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (Arrays.equals(change[i], change[j])) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

    private static int[][] changeUniverse(int[][] universe) {
        int[][] change = new int[universe.length][universe[0].length];

        for (int i = 0; i < universe.length; i++) {
            int[] changeUnit = universe[i];
            Set<Integer> set = new HashSet<>();
            for (int j : changeUnit) {
                set.add(j);
            }
            List<Integer> sorted = new ArrayList<>(set);
            Collections.sort(sorted);

            for (int j = 0; j < changeUnit.length; j++) {
                int target = changeUnit[j];

                int start = 0;
                int end = sorted.size() - 1;
                while(start <= end) {
                    int mid = (start + end) / 2;
                    int find = sorted.get(mid);

                    if (target == find) {
                        change[i][j] = mid;
                        break;
                    } else if (target > find) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }
            }
        }

        return change;
    }
}
