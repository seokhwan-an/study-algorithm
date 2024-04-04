import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        long cost = Integer.parseInt(br.readLine());
        long answer = 0;
        Arrays.sort(arr);
        long s = 0;
        long e = arr[N-1];
        while(s <= e){
            long mid = (s+e)/2;
            long sum = 0;
            for(long money : arr){
                if(money > mid) sum += mid;
                else sum += money;
            }
            if(sum > cost){
                e = mid - 1;
            }
            if(sum <= cost){
                s = mid + 1;
                answer = Math.max(answer, mid);
            }
        }
        System.out.println(answer);
    }
}
