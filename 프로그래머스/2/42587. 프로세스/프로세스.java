import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Process> processes = generateQueue(priorities);
        
        int mostPriority = getMostPriority(processes);
        while(!processes.isEmpty()) {
            Process process = processes.poll();
            if (process.isMostPriority(mostPriority)) {
                mostPriority = getMostPriority(processes);
                answer += 1;
                if (process.isTargetProcess(location)) {
                    break;
                }
            } else {
                processes.offer(process);
            }
            
        }
        
        return answer;
    }
    
    private Queue<Process> generateQueue(int[] priorities) {
        Queue<Process> processes = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            processes.add(new Process(priorities[i], i));
        }
        
        return processes;
    }
    
    private int getMostPriority(Queue<Process> processes) {
        if (processes.size() == 0) {
            return 0;
        }
        return processes.stream()
            .map(process -> process.priority)
            .max(Integer::compareTo)
            .orElseThrow();
    }
    
    static class Process {
        int priority;
        int location;
        
        public Process(int priority, int location) {
            this.priority = priority;
            this.location = location;
        }
        
        public boolean isMostPriority(int mostPriority) {
            return this.priority == mostPriority;
        }
        
        public boolean isTargetProcess(int location) {
            return this.location == location;
        }
    }
}