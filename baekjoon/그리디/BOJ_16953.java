import java.util.Scanner;

public class BOJ_16953 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int cnt = 1;
        while(true){
            if (B <= A){
                break;
            }
            if(B % 2 == 0){
                B = B/2;
                cnt++;
            }
            else if(B % 2 == 1){
                String num = String.valueOf(B);
                if(num.charAt(num.length()-1) != '1'){
                    break;
                }
                num = num.substring(0,num.length()-1);
                B = Integer.parseInt(num);
                cnt++;
            }
        }
        if (A == B){
            System.out.println(cnt);
        }
        else if(A != B){
            System.out.println(-1);
        }
    }
}
