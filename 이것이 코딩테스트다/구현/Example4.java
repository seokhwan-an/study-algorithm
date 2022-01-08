import java.util.Scanner;

public class Example4 {
    // 게임 개발
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        // map의 크기
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] map = new int[N][M];
        int answer = 1;
        // 현재 위치 및 방향
        int[] loc = new int[2];
        loc[0] = sc.nextInt();
        loc[1] = sc.nextInt();
        int dir = sc.nextInt();
        // 움직임
        int[] dx = {-1,0,1,0};
        int[] dy = {0,-1,0,1};
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                map[i][j] = sc.nextInt();
            }
        }
        map[loc[0]][loc[1]] = 2;
        int cnt = 0;
        while(true){
            // 1번조건
            dir = (dir + 1) % 4;
            int nx = loc[0] + dx[dir];
            int ny = loc[1] + dy[dir];
            cnt++;
            // 2번조건
            if (map[nx][ny] == 0){
                loc[0] = nx;
                loc[1] = ny;
                map[loc[0]][loc[1]] = 2;
                cnt = 0;
                answer++;
            }
            // 3번조건
            else if (map[nx][ny] == 1 || map[nx][ny] == 2){
                if (cnt == 4){
                    nx = nx + dx[(dir + 2) % 4];
                    ny = ny + dx[(dir + 2) % 4];
                    if(map[nx][ny] == 1){
                        break;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
