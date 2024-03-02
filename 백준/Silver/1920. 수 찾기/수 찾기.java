import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int binary_search(int[] arr, int num){
        int s = 0;
        int e = arr.length -1;
        while(s <= e){
            int mid = (s + e)/2;
            if(arr[mid] > num) {
                e = mid - 1;
            }
            else if (arr[mid] == num){
                return 1;
            }
            else if (arr[mid] < num){
                s = mid + 1;
            }
        }
        return 0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] num_arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
           num_arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num_arr);
        int M = Integer.parseInt(br.readLine());
        int[] check = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            check[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < M; i++){
            System.out.println(binary_search(num_arr,check[i]));
        }
    }
}