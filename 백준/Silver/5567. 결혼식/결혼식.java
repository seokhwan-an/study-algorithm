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
        int M = Integer.parseInt(br.readLine());
        int[] check = new int[N+1];
        ArrayList<ArrayList<Integer>> friends = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i <= N; i++){
            friends.add(new ArrayList<>());
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            friends.get(s).add(e);
            friends.get(e).add(s);
        }
        int answer = 0;
        int finish = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        check[1] = 1;
        while(!q.isEmpty()){
            int y = q.poll();
            if(check[y]== 3){
                break;
            }
            for(int friend : friends.get(y)){
                if(check[friend] == 0){
                    check[friend] = check[y]+1;
                    answer++;
                    q.offer(friend);
                }
            }
        }
        System.out.println(answer);
    }
}
