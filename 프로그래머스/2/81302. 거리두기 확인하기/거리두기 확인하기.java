class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for (int i = 0; i < places.length; i++) {
            String[] place = places[i];
            String[][] map = getMap(place);
            answer[i] = checkDistance(map);
        }
        return answer;
    }
    
    private String[][] getMap(String[] place) {
        String[][] map = new String[place.length][place[0].length()];
        for (int i = 0; i < place.length; i++) {
            String line = place[i];
            for (int j = 0; j < line.length(); j++) {
                String unit = line.substring(j, j+1);
                map[i][j] = unit;
            }
        }
        return map;
    }
    
    private int checkDistance(String[][] map) {
        boolean check = true;
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                String unit = map[i][j];
                if (unit.equals("P")) {
                    if (!(checkWidth(map, i, j) && checkHeight(map, i, j) && checkDiagonal(map, i, j))) {
                        check = false;
                        break;
                    } 
                }
            }
        }
        
        if (check) {
            return 1;
        }
        return 0;
    }
    
    private boolean checkWidth(String[][] map, int x, int y) {
        boolean available = true;
        for (int i = y + 1; i < 5; i++) {
            if (map[x][i].equals("X")) {
                break;
            }
            if (map[x][i].equals("P") && i - y <= 2) {
                available = false;
                break;
            }
        }
        
        for (int i = y - 1; i >= 0; i--) {
            if (map[x][i].equals("X")) {
                break;
            }
            if (map[x][i].equals("P") && y - i <= 2) {
                available = false;
                break;
            }
        }
        return available;
    }
    
    private boolean checkHeight(String[][] map, int x, int y) {
        boolean available = true;
        for (int i = x + 1; i < 5; i++) {
            if (map[i][y].equals("X")) {
                break;
            }
            if (map[i][y].equals("P") && i - x <= 2) {
                available = false;
                break;
            }
        }
        
        for (int i = x - 1; i >= 0; i--) {
            if (map[i][y].equals("X")) {
                break;
            }
            if (map[i][y].equals("P") && x - i <= 2) {
                available = false;
                break;
            }
        }
        return available;
    }
    
    private boolean checkDiagonal(String[][] map, int x, int y) {
        int[] dx = {1, -1, 1, -1};
        int[] dy = {1, 1, -1, -1};
        boolean available = true;
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length) {
                continue;
            }
            
            if (map[nx][ny].equals("P")) {
                String nextWidth = map[x + dx[i]][y];
                String nextHeight = map[x][y + dy[i]];
                if (!(nextWidth.equals("X") && nextHeight.equals("X"))) {
                    available = false;
                    break;
                }
            }
        }
        return available;
    }
}