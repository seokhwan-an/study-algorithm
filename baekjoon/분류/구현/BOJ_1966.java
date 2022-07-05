import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int[] answers = new int[T];
        for(int i = 0; i < T; i++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] map = new int[N][2];
            PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                int value = Integer.parseInt(st.nextToken());
                queue.add(value);
                if(j == M){
                    map[j][0] = value;
                    map[j][1] = 1;
                }
                else{
                    map[j][0] = value;
                    map[j][1] = 0;
                }
            }
            int cnt = 0;
            boolean logic = true;
            int start = 0;
            while(logic){
                int check = queue.poll();
                cnt++;
                for(int j = start; j < N+start; j++){
                    if(map[j % N][0] == check){
                        if(map[j % N][1] == 1){
                            logic = false;
                        }
                        start = j+1;
                        break;
                    }
                }
            }
            answers[i] = cnt;
        }
        for(int answer : answers){
            System.out.println(answer);
        }
    }
}
