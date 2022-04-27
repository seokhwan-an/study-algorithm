import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i <= n; i++){
            triangle.add(new ArrayList<>());
            answer.add(new ArrayList<>());
        }
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j <= i; j++){
                int num = Integer.parseInt(st.nextToken());
                triangle.get(i).add(num);
            }
        }
        for(int i = 0; i < n; i++){
            if(i == 0){
                answer.get(i).add(triangle.get(i).get(0));
            }
            else{ // i가 1부터 시작하는 경우에
                int index = 0;
                for(int k = 0; k < answer.get(i-1).size(); k++){
                    for(int j = 0; j < triangle.get(i-1).size(); j++){
                        answer.get(i).add(answer.get(i-1).get(j) + triangle.get(i).get(j));
                        answer.get(i).add(answer.get(i-1).get(j) + triangle.get(i).get(j+1));
                    }
                }
            }
        }
        int max = 0;
        for(int i = 0; i < answer.get(n-1).size(); i++){
            if(answer.get(n-1).get(i) > max){
                max = answer.get(n-1).get(i);
            }
        }
        System.out.println(max);
    }
}
