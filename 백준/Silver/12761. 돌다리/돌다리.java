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
        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[100001];
        boolean find = false;
        arr[N] = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(N);
        while (!q.isEmpty()){
            int y = q.poll();
            int[] check_arr = new int[8];
            check_arr[0] = y - 1;
            check_arr[1] = y + 1;
            check_arr[2] = A * y;
            check_arr[3] = B * y;
            check_arr[4] = A + y;
            check_arr[5] = B + y;
            check_arr[6] = y - A;
            check_arr[7] = y - B;
            for(int check : check_arr){
                if(check < 0 || check >100000){
                    continue;
                }
                if(arr[check] == 0 || arr[y]+1 < arr[check]){
                    arr[check] = arr[y]+1;
                    q.offer(check);
                }
            }
        }
        System.out.println(arr[M]);
    }
}
