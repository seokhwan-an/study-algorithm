import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int answer = Integer.MAX_VALUE;
        int len = 1;
        int start = 0, end = 1;
        long sum = arr[0];
        while (true) {
            if (end >= N || start >= N) break;
            if (start > end){
                end = start + 1;
                sum = arr[start];
                len = 1;
            }
            if (sum > S){
                sum -= arr[start];
                start++;
                len--;
            }
            else if(sum < S){
                sum += arr[end];
                end++;
                len++;
            }
            else if(sum == S){
                answer = Math.min(answer, len);
                sum -= arr[start];
                start++;
                len--;
            }
        }
        if (answer == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(answer);
        }
    }
}
