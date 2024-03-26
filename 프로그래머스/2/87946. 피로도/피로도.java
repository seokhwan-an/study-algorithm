class Solution {
    
    boolean[] visited;
    int answer = 0;
    int[] check;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        check = new int[dungeons.length];
        getMaxDungeons(dungeons.length, 0, k, dungeons);
        
        return answer;
    }
    
    private void getMaxDungeons(int n, int k, int tryPoint, int[][] dungeons) {
        if (k == n) {
            // 던전 개수 카운트하기
            int cnt = 0;
            int power = tryPoint;
            for (int i = 0; i < check.length; i++) {
                if (power >= dungeons[check[i]][0]) {
                    power -= dungeons[check[i]][1];
                    cnt += 1;
                }
            }
    
            answer = Math.max(cnt, answer);
            return;
        }
        
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                check[k] = i;
                getMaxDungeons(n, k + 1, tryPoint, dungeons);
                check[k] = -1;
                visited[i] = false;
            }
        }
    }
}