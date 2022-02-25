import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BOJ_1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] cnt = new int[10];
        for(int i = 0; i < str.length(); i++){
            int num = str.charAt(i) - '0';
            cnt[num] += 1;
        }
        for(int i = 9; i >= 0; i--){
            for(int j = 0; j < cnt[i]; j++){
                System.out.print(i);
            }
        }
    }
}