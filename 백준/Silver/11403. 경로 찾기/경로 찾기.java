import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> load = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i <= N; i++){
            load.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < N; i++){
            st= new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                int check = Integer.parseInt(st.nextToken());
                if(check == 1){
                    load.get(i).add(j);
                }
            }
        }
        for(int i = 0; i < N; i++){
            boolean[] answer = new boolean[N];
            Queue<Integer> q = new LinkedList<>();
            q.offer(i);
            while(!q.isEmpty()){
                int y = q.poll();
                for(int next : load.get(y)){
                    if(!answer[next]){
                        answer[next] = true;
                        q.offer(next);
                    }
                }
            }
            for(int j = 0; j < N; j++){
                if(answer[j] == true) {
                    System.out.print(1+" ");
                }
                else {
                    System.out.print(0+" ");
                }
            }
            System.out.println();
        }
    }
}
