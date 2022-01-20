import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2960 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        for(int i = 2; i < arr.length; i++){
            arr[i] = i;
        }
        int cnt = 0;
        int answer = 0;
        int check = 0;
        boolean jud = false;
        while(true){
            //최소 수 찾기
            for(int i = 2; i < arr.length; i++){
                if(arr[i] != -1){
                    check = arr[i];
                    break;
                }
            }
            //최소 수의 배수 지우기
            for(int i = 2; i < arr.length; i++){
                if(arr[i] % check == 0) {
                    arr[i] = -1;
                    cnt ++;
                    answer = i;
                }
                if(cnt == K){
                    jud = true;
                    break;
                }
            }
            if(jud) break;
        }
        System.out.println(answer);
    }
}
