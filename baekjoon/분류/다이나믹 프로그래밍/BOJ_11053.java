import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < N+1; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        int last = arr[0];
        for(int i = 1; i < N; i++){
            if(arr[i] > last && arr[i+1] > last){
                answer += 1;
                last = Math.min(arr[i],arr[i+1]);
            }
            else if(arr[i] > last){
                answer += 1;
                last = arr[i];
            }
            else if(arr[i+1] > last){
                answer += 1;
                last = arr[i+1];
            }
        }
        System.out.println(answer);
    }
}
