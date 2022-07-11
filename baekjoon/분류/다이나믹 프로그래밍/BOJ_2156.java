import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.max;

public class BOJ_2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] wine = new int[n+1];
        for(int i = 1; i <= n; i++){
            wine[i] = Integer.parseInt(br.readLine());
        }
        int[] answer = new int[n+1];
        answer[0] = 0;
        answer[1] = wine[1];
        if(n > 1){
            answer[2] = wine[1] + wine[2];
        }
        for(int i = 3; i <= n; i++){
            answer[i] = max(answer[i-1],max(answer[i-2]+wine[i],answer[i-3]+wine[i-1]+wine[i]));
        }
        System.out.println(answer[n]);
    }
}
