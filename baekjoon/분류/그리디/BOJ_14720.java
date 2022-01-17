import java.util.Scanner;

public class BOJ_14720 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] num_arr = new int[N];
        int answer = 0;
        int check = 0;
        for(int i = 0; i< num_arr.length; i++){
            num_arr[i] = sc.nextInt();
        }
        for(int i = 0; i < num_arr.length; i++){
            if(num_arr[i] == check) {
                answer++;
                check = (check + 1) % 3;
            }
        }
        System.out.println(answer);
    }
}
