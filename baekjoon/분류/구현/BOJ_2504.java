import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str = br.readLine();
        char[] arr = new char[str.length()];
        char[] process = new char[100];
        int pro = 0;
        int answer = 0;
        int head = 0;
        boolean correct = true;
        for(int i = 0; i < str.length(); i++){
            char check = str.charAt(i);
            if(check == '(' || check == '[') {
                arr[head++] = check;
                if(i-1 >= 0 && (str.charAt(i-1) == ')' || str.charAt(i-1) == ']')){
                    process[pro++] = '+';
                }
            }
            else{
                if(head <= 0) {
                    correct = false;
                    break;
                }
                char pre_arr = arr[head-1];
                char pre_str = str.charAt(i-1);
                if(check==')'){
                    if(pre_arr != '('){
                        correct = false;
                        break;
                    }
                    else if(pre_arr == '('){
                        if(pre_str == ')' || pre_str ==']'){
                            process[pro++] = '*';
                            process[pro++] = '2';
                        }
                        else if(pre_str == '('){
                            process[pro++] = '2';
                        }
                        head--;
                    }
                }
                else if(check == ']'){
                    if(pre_arr != '['){
                        correct = false;
                        break;
                    }
                    else if(pre_arr == '['){
                        if(pre_str == ']' || pre_str == ')'){
                            process[pro++] = '*';
                            process[pro++] = '3';
                        }
                        else if(pre_str == '['){
                            process[pro++] = '3';
                        }
                        head--;
                    }
                }
            }
        }
        for(int i = 0; i < pro; i++){
            System.out.println(process[i]);
        }
        if(correct){
            for(int i = 0; i < pro; i++){
                if(process[i] != '*' || process[i] != '+'){
                    answer = process[i] - '0';
                }
                else{
                    if(process[i] == '*'){
                        answer *= process[i+1] - '0';
                        i++;
                    }
                    else if(process[i] == '+'){
                        answer += process[i+1] - '0';
                    }
                }
            }
            System.out.println(answer);
        }
        else{
            System.out.println(0);
        }
    }
}
