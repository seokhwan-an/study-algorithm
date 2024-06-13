import java.util.*;

// 처음에 생각한 방법은 백트래킹을 통해서 모든 방안을 다 체크하는 방향으로 생각 -> 시간 초과 발생
// 순차적으로 병사 수를 줄이다가 병사수가 부족해졌을 때 가장 큰 적 wave를 무적권을 이용하는 방안
class Solution {
    
    public int solution(int n, int k, int[] enemy) {
        int answer = enemy.length;
        int soldier = n;
        int counter = k;
        Queue<Integer> queue = new PriorityQueue<>((i1, i2) -> i2 - i1);
        
        for (int i = 0; i < enemy.length; i++) {
            int cnt = enemy[i];
            soldier -= cnt;
            queue.offer(cnt);
            
            if (soldier < 0) {
                if (counter > 0) {
                    counter--;
                    soldier += queue.poll();
                } else {
                    answer = i;
                    break;
                }
            }
        }
        
        return answer;
    }
    
   
}