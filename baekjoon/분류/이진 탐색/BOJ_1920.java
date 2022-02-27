import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] num_arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
           num_arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num_arr);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int s, e =0;
        for(int i = 0; i < M; i++){
            int check = Integer.parseInt(st.nextToken());
            boolean answer = false;
            if(num_arr[N-1] < 0){
                s = num_arr[N-1];
                e = 1;
            }
            else{
                s = 1;
                e = num_arr[N-1];
            }
            while(s <= e){
                int mid = (s + e)/2;
                if(mid > check){
                    e = mid -1;
                }
                else if(mid == check){
                    answer = true;
                    break;
                }
                else{
                    s = mid + 1;
                }
            }
            if(answer){
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }
    }
}