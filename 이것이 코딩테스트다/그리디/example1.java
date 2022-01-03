import java.util.Scanner;
public class example1 {
    public static void main(String[] args){
        //큰 수의 법칙
        Scanner sc = new Scanner(System.in);
        int answer = 0;
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        sc.nextLine();

        int[] num_list = new int[N];
        for(int i = 0; i < num_list.length; i++){
            num_list[i] = sc.nextInt();
        }

        for(int i = 0; i < num_list.length-1; i++){
            int max = i;
            for (int j = i+1; j < num_list.length; j++){
                if(num_list[j] > num_list[max]){
                    max = j;
                }
                int temp = num_list[max];
                num_list[max] = num_list[i];
                num_list[i] = temp;
            }
        }

        for(int i = 1; i <= M; i++){
            if (i == 1) answer += num_list[0];
            else{
                if (i % K == 1) answer += num_list[1];
                else{
                    answer += num_list[0];
                }
            }
        }
        System.out.println(answer);
    }
}
