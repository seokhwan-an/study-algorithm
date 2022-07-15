import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.max;


public class BOJ_1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] num_arr = new int[n];
        int[] sum = new int[n];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            num_arr[i] = Integer.parseInt(st.nextToken());
        }
        sum[0] = num_arr[0];
        int answer = num_arr[0];
        for(int i = 1; i < n; i++){
            sum[i] = max(sum[i-1] + num_arr[i], num_arr[i]);
            answer = max(sum[i],answer);
        }
        System.out.println(answer);
    }

}
