import java.util.*;

class Solution {
    
    class Record {
        String time;
        String carId;
        String type;
        
        public Record(String time, String carId, String type) {
            this.time = time;
            this.carId = carId;
            this.type = type;
        }
    }
    
    public int[] solution(int[] fees, String[] records) {
        Set<String> set = new HashSet<>();
        List<Record> timeRecord = new ArrayList<>();
        Map<String, Integer> feeInfo = new HashMap<>();
        
        for (String record : records) {
            String[] split = record.split(" ");
            timeRecord.add(new Record(split[0], split[1], split[2]));
            set.add(split[1]);
        }
        
        List<String> carIds = new ArrayList<>(set);
        carIds.sort((c1, c2) -> c1.compareTo(c2));
        
        for (String carId : carIds) {
            List<Record> carInfos = getCarParkInfo(carId, timeRecord);
            int time = 0;
            String startTime = ""; 
            for (int i = 0; i < carInfos.size(); i++) {
                Record carInfo = carInfos.get(i);
                if (i == carInfos.size() - 1 && carInfo.type.equals("IN")) {
                    time += getDiffTime(carInfo.time, "23:59");
                }
                
                if (carInfo.type.equals("IN")) {
                    startTime = carInfo.time;
                    continue;
                }
                
                if (carInfo.type.equals("OUT")) {
                    time += getDiffTime(startTime, carInfo.time);
                }
            }
            
            feeInfo.put(carId, getFee(time, fees));
        }
        int[] answer = new int[carIds.size()];
        
        for (int i = 0; i < carIds.size(); i++) {
            answer[i] = feeInfo.get(carIds.get(i));
        }
        
        return answer;
    }
    
    private List<Record> getCarParkInfo(String carId, List<Record> records) {
        List<Record> filter = new ArrayList<>();
        for (Record record : records) {
            if (record.carId.equals(carId)) {
                filter.add(record);
            }
        }
        return filter;
    }
    
    private int getFee(int diff, int[] fees) {
        if (diff <= fees[0]) {
            return fees[1];
        }
        
        int extraTime = diff - fees[0];
        if (extraTime % fees[2] == 0) {
            return fees[1] + fees[3] * (extraTime / fees[2]);
        } else {
            return fees[1] + fees[3] * ((extraTime / fees[2]) + 1); 
        }
    }
    
    private int getDiffTime(String startTime, String endTime) {
        int start = getTime(startTime);
        int end = getTime(endTime);
        return end - start;
    }
    
    private int getTime(String time) {
        String[] timeInfo = time.split(":");
        return 60 * Integer.parseInt(timeInfo[0]) + Integer.parseInt(timeInfo[1]);
    }
}