import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_11724 {
    static int N;
    static int M;
    static ArrayList<ArrayList<Integer>> map;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        check = new boolean[N+1];
        map = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i <= N; i++){
            map.add(new ArrayList<Integer>());
            check[i] = false;
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            map.get(p).add(q);
            map.get(q).add(p);
        }
        int answer = 0;
        for(int i = 1; i <=N; i++){
            if(check[i] == false){
                dfs(i);
                answer++;
            }
        }
        System.out.println(answer);
    }
    public static void dfs(int x){
        check[x] = true;
        for(int i : map.get(x)){
            if(check[i] == false) {
                dfs(i);
            }
        }
    }
}
