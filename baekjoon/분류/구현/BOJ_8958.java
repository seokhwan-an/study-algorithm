import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_8958 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] answer = new int[N];
        int index = 0;
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            int cnt = 0;
            ArrayList<Integer> o = new ArrayList<Integer>();
            for(int j = 0; j < str.length(); j++){
                char check = str.charAt(j);
                if(check == 'O') cnt++;
                if(check == 'X') {
                    o.add(cnt);
                    cnt = 0;
                }
            }
            o.add(cnt);
            int fin = 0;
            for(int j = 0; j < o.size(); j++){
                fin += (o.get(j) * (o.get(j) +1))/2;
            }
            answer[index++] = fin;
        }
        for(int i = 0; i < N; i++){
            System.out.println(answer[i]);
        }
    }
}