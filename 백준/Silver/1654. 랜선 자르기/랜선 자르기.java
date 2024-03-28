import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] arr = new long[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        long s = 1, e = arr[N-1];
        long answer = 0;
        while(s <= e){
            long mid = (s + e)/2;
            int cnt = 0;
            for(int i = 0; i < N; i++){
                if(arr[i] >= mid){
                    cnt += arr[i] / mid;
                }
            }
            if(cnt >= M){
                s = mid + 1;
                answer = Math.max(answer, mid);
            }
            else{
                e = mid - 1;
            }
        }
        System.out.println(answer);
    }
}