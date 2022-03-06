import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759 {
    public static int N;
    public static int M;
    public static String[] chars;
    public static char[] answer;
    public static int check = 0;
    public static int consonant = 0;
    public static int vowel = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = new char[N];
        chars = new String[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            chars[i] = st.nextToken();
        }
        Arrays.sort(chars);
        for(int i = 0; i <= M-N; i++){
            answer[check++] = chars[i].charAt(0);
            dfs(i,M);
            check--;
        }
    }
    public static void dfs(int i, int M){
        if (check == N){
            for(int j = 0; j < check; j++){
                if(answer[j] == 'a'){
                    vowel++;
                }
                else if(answer[j] == 'e'){
                    vowel++;
                }
                else if(answer[j] == 'i'){
                    vowel++;
                }
                else if(answer[j] == 'o'){
                    vowel++;
                }
                else if(answer[j] == 'u'){
                    vowel++;
                }
                else{
                    consonant++;
                }
            }
            if(consonant >= 2 && vowel >= 1){
                for(int j = 0; j < check; j++){
                    System.out.print(answer[j]);
                }
                System.out.println();
            }
            consonant = 0;
            vowel = 0;
            return;
        }
        for(int j = i + 1; j < M; j++){
            answer[check++] = chars[j].charAt(0);
            dfs(j,M);
            check--;
        }
    }
}