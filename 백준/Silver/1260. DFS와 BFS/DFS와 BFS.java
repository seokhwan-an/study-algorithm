import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> map;
    static boolean[] visited_dfs;
    static boolean[] visited_bfs;
    static int cnt;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        map = new ArrayList<ArrayList<Integer>>();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        visited_dfs = new boolean[N+1];
        visited_bfs = new boolean[N+1];
        cnt = 0;
        for(int i = 0; i <= N; i++){
            map.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            map.get(p).add(q);
            map.get(q).add(p);
        }
        dfs(start);
        System.out.println();
        bfs(start);
    }
    public static void dfs(int x){
        visited_dfs[x] = true;
        System.out.print(x+" ");
        map.get(x).sort(Comparator.naturalOrder());
        for(int i : map.get(x)){
            if(!visited_dfs[i])
                dfs(i);
        }
    }

    public static void bfs(int x){
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(x);
        visited_bfs[x] = true;
        while(!q.isEmpty()){
            int y = q.poll();
            System.out.print(y+" ");
            map.get(y).sort(Comparator.naturalOrder());
            for(int i : map.get(y)){
                if(!visited_bfs[i]){
                    q.offer(i);
                    visited_bfs[i] = true;
                }
            }
        }
    }
}
