/**
1. 버스는 9:00부터 n회 t분 간격으로 역에 도착 최대 m명 승객 탑승
2. 버스가 도착한 순간 대기 순서대로 태우고 출발 (09:00에 도착 09:00 줄 선 크루도 탑승)

풀이 방안
1. 23:59에 해당하는 크루들을 제거한다.
2. 시간을 숫자로 변환한다.
2. n번 반복하며 m명의 사람들을 제거한다.
3. 최대한 늦은 n에서 답을 구한다.
*/

import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        int busTime = transTime("09:00");
        Queue<Integer> renew = goSleeping(timetable);
        
        int last = -1;
        int ride = 0;
        for (int i = 0; i < n; i++) {
            // 버스 시간 갱신
            if (i > 0) {
                busTime = busTime + t;
            }
            ride = 0;
        
            for (int j = 0; j < m; j++) {
                if (!renew.isEmpty() && renew.peek() <= busTime) {
                    last = renew.poll();
                    ride += 1;
                }
            }
        }

        
        int con = 0;
        // 탑승한 사람이 더 적은 경우
        if (ride < m) {
            con = busTime;
        } else {
            con = last -1;
        }
        
        return transFormat(con);
    }
    
    private Queue<Integer> goSleeping(String[] timetable) {
        Queue<Integer> queue = new PriorityQueue<>();
        
        for (String time : timetable) {
            if (time.equals("23:59")) {
                continue;
            }
            
            int trans = transTime(time);
            queue.offer(trans);
        }
        
        return queue;
    }
    
    private int transTime(String time) {
        String[] split = time.split(":");
        return 60 * Integer.parseInt(split[0]) + Integer.parseInt(split[1]);   
    }
    
    private String transFormat(int time) {
        int h = time / 60;
        int m = time % 60;
        
        if (h < 10) {
            if (m < 10) {
                return "0" + h + ":" + "0" + m;
            } 
            return "0" + h + ":" + m;
        } else {
            if (m < 10) {
                return h + ":" + "0" + m;
            }
            return h + ":" + m;
        }
    }
}