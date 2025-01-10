import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> nums = new ArrayList<>();

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(input[i]);
            nums.add(x);
        }

        Collections.sort(nums);

        int answer = 0;

        for (int i = 0; i < N; i++) {
            int target = nums.get(i);

            int left = 0;
            int right = N - 1;

            while (left < right) {
                if (left == i) {
                    left++;
                    continue;
                }

                if (right == i) {
                    right--;
                    continue;
                }

                int sum = nums.get(left) + nums.get(right);
                if (sum == target) {
                    answer++;
                    break;
                } else if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        System.out.println(answer);
    }
}
