import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str = br.readLine();
        int[] check = new int[10];
        for(int i = 0; i < 10; i++){
            check[i] = 0;
        }
        for(int i = 0; i < str.length(); i++) {
            int num = str.charAt(i) - '0';
            check[num]++;
        }
        int six_nine = check[6]+ check[9];
        if(six_nine % 2 == 1){
            six_nine = six_nine/2 + 1;
        }
        else{
            six_nine = six_nine/2;
        }
        int max_num = check[0];
        for(int i = 0; i < 10; i++){
            if(i == 6 || i == 9) continue;
            if(check[i] > max_num){
                max_num = check[i];
            }
        }
        if(max_num > six_nine){
            System.out.println(max_num);
        }
        else{
            System.out.println(six_nine);
        }
    }
}
