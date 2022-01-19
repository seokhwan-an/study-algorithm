import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class BOJ_1316 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        String[] arr = new String[N];
        for(int i = 0; i < N; i++){
            arr[i] = br.readLine();
        }
        for(int i = 0; i < N; i++){//주어진 문자열에 대하여
            boolean jud = true; // 판별 여부
            char[] check = new char[arr[i].length()];
            for(int j = 0; j < check.length; j++){
                check[j] = '1';
            }
            int cnt = 0;
            char last = arr[i].charAt(0);
            check[cnt++] = last;
            for(int j = 1; j < arr[i].length(); j++){//문자마다
                char next = arr[i].charAt(j);
                if(last == next) continue;
                for(int k = 0; k < check.length; k++){
                    if(next == check[k]) {
                        jud = false;
                        break;
                    }
                }
                last = next;
                check[cnt++] = last;
                if(!jud){
                    break;
                }
            }
            if(jud) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
