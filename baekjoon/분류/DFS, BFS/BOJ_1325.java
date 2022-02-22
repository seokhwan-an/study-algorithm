import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1325 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        ArrayList<ArrayList<Integer>> computer = new ArrayList<ArrayList<Integer>>();
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] answer = new int[N+1];
        for(int i = 1; i <= N+1; i++){
            computer.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            computer.get(q).add(p);
        }
        for(int i = 1; i <= N; i++){
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            int cnt = 0;
            while(!queue.isEmpty()){
                int y = queue.poll();
                for(int j = 0; j < computer.get(y).size(); j++){
                    cnt++;
                    queue.offer(computer.get(y).get(j));
                }
            }
            answer[i] = cnt;
        }
        int max = 0;
        for(int i = 1; i <= N; i++){
            max = Math.max(max,answer[i]);
        }
        for(int i = 1; i <= N; i++){
            if(answer[i] == max){
                System.out.print(i+" ");
            }
        }
    }
}
