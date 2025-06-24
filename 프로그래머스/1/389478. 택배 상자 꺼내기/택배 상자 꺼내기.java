class Solution {
    public int solution(int n, int w, int num) {
       
        int[][] map = initMap(n, w);
        int[] targetLoc = findLoc(map, num);
        int answer = countRemoveBox(map, targetLoc, n) + 1;
        return answer;
    }
    
    private int[][] initMap(int n, int w) {
        int r = n / w + 1;
        int[][] map = new int[r][w];
        
        int boxNum = 1;
        for (int i = 0; i < r; i++) {
            if (i % 2 == 1) {
                for (int j = w - 1; j >= 0; j--) {
                    map[i][j] = boxNum;
                    boxNum += 1;
                }
            } else {
                for (int j = 0; j < w; j++) {
                    map[i][j] = boxNum;
                    boxNum += 1;
                }
            }
        }
        
        return map;
    }
    
    private int[] findLoc(int[][] map, int num) {
        int[] loc = new int[] {0, 0};
        
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == num) {
                    loc[0] = i;
                    loc[1] = j;
                }
            }
        }
        
        return loc;
    }
    
    private int countRemoveBox(int[][] map, int[] loc, int n) {
        int next = loc[0] + 1;
        int count = 0;
        
        while (next < map.length) {
            int target = map[next][loc[1]];
            if (target > n) {
                break;
            }
            count += 1;
            next += 1;
        }
        
        return count;
    }
}