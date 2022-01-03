import java.util.Scanner;

public class example2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] card = new int[N][M];
        int[] list = new int[N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                card[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < N; i++){
            int min = card[i][0];
            for(int j = 0; j < M; j++){
                if(min > card[i][j]){
                    min = card[i][j];
                }
            }
            list[i] = min;
        }
        int max = list[0];
        for(int i = 0; i < N; i++){
            if (list[i] > max){
                max = list[i];
            }
        }
        System.out.println(max);
    }
}
