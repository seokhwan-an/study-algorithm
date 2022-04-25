import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        int[] arr1 = new int[N+1];
        boolean[] arr2 = new boolean[N+1];
        for(int i = 1; i <= N+1; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < N-1; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph.get(s).add(e);
            graph.get(e).add(s);
        }
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(1);
        while(!q.isEmpty()){
            int y = q.poll();
            arr2[y] = true;
            for(int num : graph.get(y)){
                if(arr2[num] == false){
                    arr2[num] = true;
                    arr1[num] = y;
                    q.offer(num);
                }
            }
        }
        for(int i = 2; i < N+1; i++){
            System.out.println(arr1[i]);
        }
    }
}
