import java.util.Scanner;

public class Example2 {
    // 시각
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int answer = 0;
        for(int i = 0; i <= N; i++){
            for(int j = 0; j <= 59; j++){
                for(int k = 0; k <= 59; k++){
                    String time = String.valueOf(i)+ String.valueOf(j) + String.valueOf(k);
                    if(time.contains("3")){
                        answer++;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
