import java.util.*;

class Solution {
    
    static int x = 0;
    static int y = 0;
    
    public int solution(String dirs) {
        int answer = 0;
        String[] dirsArr = dirs.split("");
        
        List<Load> loads = new ArrayList<>();
        for (String dir : dirsArr) {
            Load load = new Load(x, y);
            move(dir);
            // 경계를 벗어난 움직임 체크
            if (load.notMove(x,y)) {
                System.out.println("경계를 벗어남");
                continue;
            }
            load.setDestination(x, y);
            boolean duplicationChecker = false;
            for (Load containedLoad : loads) {
                if (containedLoad.isSameLoad(load)) {
                    System.out.println("중복된 경우");
                    duplicationChecker = true;
                }
            }
            if (duplicationChecker) {
                continue;
            } else {
                loads.add(load);
            }
        }
        answer = loads.size();
        return answer;
    }
    
    public void move(String dir) {
        if (dir.equals("U")) {
            if (y - 1 < -5) { 
                return;
            }
            y -= 1;
        }
        if (dir.equals("D")) {
            if (y + 1 > 5) {       
                return;
            }
            y += 1;
        }
        if (dir.equals("R")) {
            if (x + 1 > 5) {   
                return;
            }
            x += 1;
        }
        if (dir.equals("L")) {
            if (x - 1 < -5) {
                return;
            }
            x -= 1;
        }
    }
    
    static class Load {
        int start_x;
        int start_y;
        int end_x;
        int end_y;
        
        public Load(int start_x, int start_y) {
            this.start_x = start_x;
            this.start_y = start_y;
        }
        
        public void setDestination(int end_x, int end_y) { 
            this.end_x = end_x;
            this.end_y = end_y;
        }
        
        public boolean isSameLoad(Load other) {
            return (this.start_x == other.start_x
                && this.end_x == other.end_x
                && this.start_y == other.start_y
                && this.end_y == other.end_y)
                || (this.start_x == other.end_x
                && this.end_x == other.start_x
                && this.start_y == other.end_y
                && this.end_y == other.start_y);
        }
        
        public boolean notMove(int end_x, int end_y) {
            return this.start_x == end_x
                && this.start_y == end_y;
        }

    }
}