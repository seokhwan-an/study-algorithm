import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] map = new int[N];
        int[] check = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){ // 맵 생성
            map[i] = Integer.parseInt(st.nextToken());
        }
        int index = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(map[index]);
        while(!q.isEmpty()){
            int y = q.poll(); // 큐에서 꺼내는 것
            int visit = check[index]; // 이전 값 넣기
            for(int i = 0; i < y; i++){
                index++;
                if(index >= N){
                    break;
                }
                if(check[index] == 0){
                    check[index] = visit + 1;
                    q.offer(map[index]);
                }
            }
            if(y == 0){
                index++;
            }
            for(int i = 0; i < y-1; i++){
                index--;
            }
        }
        if(N == 1){
            System.out.println(0);
        }
        else if(check[N-1] == 0){
            System.out.println(-1);
        }
        else{
            System.out.println(check[N-1]);
        }
    }
}