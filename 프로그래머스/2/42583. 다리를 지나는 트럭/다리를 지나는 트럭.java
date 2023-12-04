import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int readyTruckCnt = truck_weights.length;
        int complitTruckCnt = 0;
        int truck_index = 0;
        
        Queue<Integer> road = new LinkedList<>();
        road.offer(0);
        int roadWeight = 0;
        
        while(!road.isEmpty()) {
            // 트럭이 있을 때
            if (truck_index < truck_weights.length) {
                int truck = truck_weights[truck_index];

                
                // 트럭을 road에 넣기
                if (roadWeight + truck <= weight) {
                    road.offer(truck);
                    roadWeight += truck;
                    truck_index++;
                } else {
                    road.offer(0);
                }
                
                // 트럭 빼기
                if (road.size() >= bridge_length) {
                    int complitTruck = road.poll();
                    roadWeight -= complitTruck;
                }
                answer++;
            } 
            // 트럭이 이미 다리에 올라간 경우
            else {
                answer += bridge_length;
                break;
            }
        }
        return answer;
    }
}