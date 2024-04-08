import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] tree = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            tree[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(tree);
        int s = 1;
        int e = tree[N-1];
        long answer = 0;
        while (s <= e){
            long check = 0;
            int mid = (s + e)/2;
            for(int length : tree){
                if(length >= mid){
                    check += length - mid;
                }
            }
            if(check >= M){
                answer = Math.max(answer,mid);
                s = mid + 1;
            }
            else if(check < M){
                e = mid -1;
            }
        }
        System.out.println(answer);
    }
}