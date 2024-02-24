import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        boolean check = false;
        String[] arr1 = str.split("-");
        for(int i = 0; i < arr1.length; i++){
            for(int j = 0; j < arr1[i].length(); j++){
                if(arr1[i].charAt(j) == '+'){
                    check = true;
                    break;
                }
            }
            if(check){
                String[] arr2 = arr1[i].split("\\+");
                int num = Integer.parseInt(arr2[0]);
                for(int j = 1; j < arr2.length; j++){
                    num += Integer.parseInt(arr2[j]);
                }
                arr1[i] = String.valueOf(num);
                check = false;
            }
        }
        int answer = Integer.parseInt(arr1[0]);
        for(int i = 1; i < arr1.length; i++){
            answer -= Integer.parseInt(arr1[i]);
        }
        System.out.println(answer);
    }
}