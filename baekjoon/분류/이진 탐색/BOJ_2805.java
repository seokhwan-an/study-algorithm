import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2805 {
    public static int binary_search(int[] tree, int need){
        int s = 0;
        int e = tree[tree.length-1];
        while(s <= e){
            int mid = (s + e)/2;
            int check = 0;
            for(int i = 0; i < tree.length; i++){
                if(tree[i] >= mid) {
                    check += tree[i] - mid;
                }
            }
            if(check >= need){
                s = mid + 1;
            }
            else if(check < need){
                e = mid -  1;
            }
        }
        return e;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] tree = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            tree[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(tree);
        System.out.println(binary_search(tree,M));
    }
}