import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1697 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int answer = 0;
        int[] visied = new int[200001];
        visied[s] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        while(!q.isEmpty()) {
            int y = q.poll();
            if(y + 1 <= 200000 && visied[y+1] == 0){
                visied[y+1] = visied[y]+1;
                q.offer(y+1);
            }
            if(y - 1 <= 200000 && y-1 >= 0 && visied[y-1] == 0){
                visied[y-1] = visied[y]+1;
                q.offer(y-1);
            }
            if(y * 2 <= 200000 && visied[y*2] == 0){
                visied[y*2] = visied[y]+1;
                q.offer(y*2);
            }
        }
        answer = visied[e];
        if(s == e) answer = 0;
        System.out.println(answer);
    }
}
