import java.util.Scanner;

public class BOJ_1789 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Long S = sc.nextLong();
        int answer = 0;
        for(int i = 1; i <= S; i++){
            S -= i;
            if(S < 0){
                break;
            }
            answer++;
        }
        System.out.println(answer);
    }
}
