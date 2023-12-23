
// 페인트를 전체를 칠하려고 하는 것이 아닌 부분만 칠하려고 하는 것
// 길이가 n인 벽을 1m크기인 n개로 분할 왼쪽부터 1,2...n
// 벽에 페인트를 칠하는 롤러의 길이는 m
    // 롤거가 벽에서 벗어나면 안된다.
    // 구역의 일부분만 포함되도록 칠하면 안된다.
// 롤러로 페인트를 칠하는 횟수를 줄이고자한다.
class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        // 칠해야하는 벽 설정
        int[] wall = new int[n + 1];
        wall[0] = 1;
        for (int i = 1; i <= n; i++) {
            wall[i] = 1;
            for (int j = 0; j < section.length; j++) {
                if (i == section[j]) {
                    wall[i] = 0;
                }
            }
        }
        
        // 앞에서부터 칠하기
        for (int i = 1; i <= n; i++) {
            if (wall[i] == 0) {
                if (i + m - 1 > n) {
                    continue;
                }
                for (int j = 0; j < m; j++) {
                    wall[i + j] = 1;
                }
                i = i + m - 1;
                answer += 1;
            }
        }
        
        // 뒤에서부터 칠하기
        for (int i = n; i >= 1; i--) {
            if (wall[i] == 0) {
                if (i - m + 1 < 1) {
                    continue;
                }
                for (int j = 0; j < m; j++) {
                    wall[i - j] = 1;
                }
                i = i - m + 1;
                answer += 1;
            }
        }
        
        
        return answer;
    }
}