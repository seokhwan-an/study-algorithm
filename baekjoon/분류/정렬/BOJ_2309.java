import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] people = new int[9];
        for(int i = 0; i < 9; i++){
            people[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(people);
        int chk1 = 0;
        int chk2 = 0;
        boolean answer = false;
        for(int i = 0; i <9 ; i++){
            chk1 = i;
            for(int j = 0; j < 9; j++){
                if(j == chk2) continue;
                chk2 = j;
                int sum = 0;
                for(int k = 0; k < 9; k++){
                    if(chk1 == k || chk2 == k) continue;
                    sum += people[k];
                }
                if(sum == 100) {
                    answer = true;
                    break;
                }
            }
            if(answer) break;
        }
        for(int i = 0; i < 9; i++){
            if(i == chk1 || i == chk2)continue;
            System.out.println(people[i]);
        }
    }
}