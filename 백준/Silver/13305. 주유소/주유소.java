import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        long[] length = new long[N];
        long[] pay = new long[N];
        long answer = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N-1; i++){
            length[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            pay[i] = Integer.parseInt(st.nextToken());
        }
        long cost = pay[0];
        for(int i = 0; i < N; i++){
            if(pay[i] < cost){
                cost = pay[i];
            }
            answer += cost * length[i];
        }
        System.out.println(answer);
    }
}
