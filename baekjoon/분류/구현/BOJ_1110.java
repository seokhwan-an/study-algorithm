import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int check1 = N;
        int answer = 100;
        int cnt = 0;

        while(true){
            if(N == 0){
                cnt = 1;
                break;
            }
            String next = String.valueOf(check1);
            if(next.length() == 1){
                answer = Integer.parseInt(next + next);
                cnt++;
                if(N == answer){
                    break;
                }
                check1 = answer;
            }
            else{
                int check2 = 0;
                for(int i = 0; i < next.length(); i++){
                    char check3 = next.charAt(i);
                    check2 += check3 - '0';
                }
                answer = Integer.parseInt(next.substring(next.length()-1) +  String.valueOf(check2).substring(String.valueOf(check2).length()-1));
                cnt++;
                if(N == answer){
                    break;
                }
                check1 = answer;
            }
        }
        System.out.println(cnt);
    }
}
