import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        for(int i = 0; i < N; i++){
            arr[i] = br.readLine();
        }
        for(int i = 0; i < N; i++){
            int len = i;
            for(int j = i+1; j < N; j++){
                if(arr[len].length() > arr[j].length()){ // 길이가 더 긴 경우
                    len = j;
                }
                else if(arr[len].length() == arr[j].length()){// 길이가 같은 경우
                    if(arr[len].compareTo(arr[j])>0){
                        len = j;
                    }
                }
            }
            String temp = arr[i];
            arr[i] = arr[len];
            arr[len] = temp;
        }
        String pre = "1";
        for(int i = 0; i < N; i++){
            if(arr[i].equals(pre)){
                continue;
            }
            else{
                System.out.println(arr[i]);
                pre = arr[i];
            }
        }
    }
}
