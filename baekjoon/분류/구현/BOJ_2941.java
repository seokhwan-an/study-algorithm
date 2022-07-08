import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class BOJ_2941 {
    static String[] cro = {"c=","c-","dz=","d-","lj","nj","s=","z="};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int answer = 0;
        for(int i = 0; i < str.length(); i++){
            if(i >= str.length()-1){
                answer += 1;
                break;
            }
            String check = str.substring(i,i+2);
            // dz=인 경우
            if(check.equals("dz")){
                if(i == str.length()-2){
                    answer +=2;
                    break;
                }
                check = str.substring(i,i+3);
                if(contains(cro,check)){
                    answer += 1;
                    i += 2;
                    continue;
                }
            }
            // 크로아티아어 포함된 경우
            if(contains(cro,check)){
                answer += 1;
                i+=1;
            }
            else{
                answer += 1;
            }
        }
        System.out.println(answer);
    }
    public static boolean contains(String[] cro, String check){
        return Arrays.asList(cro).contains(check);
    }
}
