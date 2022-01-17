import java.util.Scanner;

public class BOJ_4796 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        int P = sc.nextInt();
        int V = sc.nextInt();
        int[] answer_arr = new int[100000];
        int cnt = 0;
        while(L != 0 && P != 0 && V != 0){
            int answer = L * (V/P);
            if (L >= (V%P)){
                answer += V%P;
            }
            else{
                answer += L;
            }
            answer_arr[cnt++] = answer;
            L = sc.nextInt();
            P = sc.nextInt();
            V = sc.nextInt();
        }
        for(int i = 0; i < cnt; i++){
            System.out.println("Case "+(i+1)+": "+answer_arr[i]);
        }
    }
}
