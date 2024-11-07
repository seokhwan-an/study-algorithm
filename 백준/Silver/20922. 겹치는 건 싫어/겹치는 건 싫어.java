import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        Map<Integer, Integer> map = new HashMap<>();

        int[] arr = new int[n];
        String[] numbers = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(numbers[i]);
        }

        int start = 0;
        int end = 0;
        map.put(arr[end], 1);
        int length = 1;
        int answer = Integer.MIN_VALUE;
        while(start <= end) {
            if (map.get(arr[end]) <= k) {
                end++;
                if (end >= n) {
                    break;
                }
                if (map.containsKey(arr[end])) {
                    map.put(arr[end], map.get(arr[end]) + 1);
                } else {
                    map.put(arr[end], 1);
                }
                length++;
                continue;
            }
            answer = Math.max(answer, length - 1);
            map.put(arr[start], map.get(arr[start]) - 1);
            start++;
            length--;

            if (start > end) {
                end = start;
                if (end >= n) {
                    break;
                }
                length = 1;
                map.put(arr[end], 1);
            }
        }
        answer = Math.max(answer, length);

        System.out.println(answer);
    }
}
