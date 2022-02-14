import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2110 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] houses = new int[N];
        for(int i = 0; i < N ; i++){
            int loc = Integer.parseInt(br.readLine());
            houses[i] = loc;
        }
        Arrays.sort(houses);
        int s = 1, e = houses[N-1] - houses[0];
        int answer = 0;
        while(s <= e){
            int mid = (s + e)/2;
            int first = houses[0];
            int cnt = 1;
            for(int i = 0; i < N; i++){
                if(houses[i] >= first + mid){
                    first = houses[i];
                    cnt++;
                }
            }
            if(cnt >= C) {
                s = mid+1;
                answer = Math.max(answer, mid);
            }
            else{
                e = mid -1;
            }
        }
        System.out.println(answer);
    }
}