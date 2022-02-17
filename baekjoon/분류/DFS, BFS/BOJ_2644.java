import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2644 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        ArrayList<ArrayList<Integer>> rapport = new ArrayList<ArrayList<Integer>>();
        int N = Integer.parseInt(br.readLine());
        int[] check = new int[N+1];
        for(int i = 0; i < N+1; i++){
            check[i] = -1;
        }
        for(int i = 0; i <= N; i++){
            rapport.add(new ArrayList<>());
        }
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        check[a] = 0;
        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            rapport.get(p).add(q);
            rapport.get(q).add(p);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(a);
        while(!queue.isEmpty()){
            int y = queue.poll();
            for(int c : rapport.get(y)){
                if(check[c] == -1){
                    check[c] = check[y] + 1;
                    queue.offer(c);
                }
            }
        }
        if(check[b] == -1){
            System.out.println(-1);
        }
        else{
            System.out.println(check[b]);
        }
    }
}