import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class BOJ_11725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] graph = new int[N][2];
        int[] arr = new int[N+1];
        for(int i = 0; i < N+1; i++){
            arr[i] = -1;
        }
        for(int i = 0; i < N-1; i++){
            st = new StringTokenizer(br.readLine());
            graph[i][0] = Integer.parseInt(st.nextToken());
            graph[i][1] = Integer.parseInt(st.nextToken());
            if(arr[graph[i][0]] == -1 || arr[graph[i][1]] == -1){
                if(graph[i][1] == 1){
                    arr[graph[i][0]] = 1;
                }
                if(graph[i][0] == 1){
                    arr[graph[i][1]] = 1;
                }
                if(graph[i][1] != 1 && graph[i][0] != 1){
                    arr[graph[i][1]] = graph[i][0];
                }
            }
        }
        for(int i = 0; i < N-1; i++){
            if(arr[graph[i][0]] == -1){
                arr[graph[i][0]] = graph[i][1];
            }
        }
        for(int i = 2; i < N+1; i++){
            System.out.println(arr[i]);
        }

    }
}
