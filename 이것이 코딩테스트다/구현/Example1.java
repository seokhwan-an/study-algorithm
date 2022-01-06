import java.util.*;
public class Example1 {
    // 상하좌우
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        int nx = 0, ny = 0;
        int x = 1, y = 1;
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};
        char[] move = {'L','R','U','D'};
        String[] plans = sc.nextLine().split(" ");
        for(int i = 0; i < plans.length; i++){
            for(int j = 0; j < move.length; j++){
                if(plans[i].charAt(0) == move[j]){
                    nx = x + dx[j];
                    ny = y + dy[j];
                }
            }
            if (nx < 1 || nx > N || ny < 1 || ny > N){
                continue;
            }
            x = nx;
            y = ny;
        }
        System.out.println(x+" "+y);
    }
}
