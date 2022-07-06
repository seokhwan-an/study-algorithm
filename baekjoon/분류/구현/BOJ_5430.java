import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String[] answers = new String[T];
        for(int i = 0; i < T; i++){
            String infos = br.readLine();
            int n = Integer.parseInt(br.readLine());
            ArrayList<Integer> num_arr = new ArrayList<>();
            String num = br.readLine();
            String num_add = "";
            for(String str : num.substring(1,num.length()-1).split(",")){
                if(!str.equals("")){
                    num_arr.add(Integer.parseInt(str));
                }
            }
            boolean check = true;
            boolean reverse = false;
            for(char info : infos.toCharArray()){
                if(info == 'R'){
                    reverse = !reverse;
                }
                else{
                    if(num_arr.size() == 0){
                        check = false;
                        break;
                    }
                    if(reverse){
                        num_arr.remove(num_arr.size()-1);
                    }
                    else{
                        num_arr.remove(0);
                    }
                }
            }
            answers[i] = ac(num_arr,check,reverse);
        }
        for(String answer : answers){
            System.out.println(answer);
        }
    }

    static String ac(ArrayList<Integer> num_arr, boolean check, boolean reverse) {
        String answer = "[";
        if (check == true) {
            while (!num_arr.isEmpty()) {
                if (reverse == true) {
                    answer += num_arr.get(num_arr.size() - 1);
                    num_arr.remove(num_arr.size() - 1);
                } else {
                    answer += num_arr.get(0);
                    num_arr.remove(0);
                }
                if (num_arr.size() != 0) {
                    answer += ",";
                }
            }
            answer += "]";
        }
        else {
            answer = "error";
        }
        return answer;
    }
}