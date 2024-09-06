import java.util.*;
import java.util.stream.Collectors;

class Solution {
    
    class Music {
        int index;
        String startTime;
        String endTime;
        String name;
        String melody;
        
        public Music(int index, String startTime, String endTime, String name, String melody) {
            this.index = index;
            this.startTime = startTime;
            this.endTime = endTime;
            this.name = name;
            this. melody = melody;
        }
        
        public boolean containNeoMelody(String neoMelody) {
            int playTime = getPlayTime();
            List<String> soundList = getSoundList();
            StringBuilder sb = new StringBuilder();
            
            for (int i = 0; i < playTime; i++) {
                sb.append(soundList.get(i % soundList.size()));
            } 
            return checkContainNeoMelody(sb.toString(), neoMelody);
        }
        
        private int getPlayTime() {
            int totalStartTime = changeToMinute(startTime);
            int totalEndTime = changeToMinute(endTime);
            
            return totalEndTime - totalStartTime;
        }
        
        private int changeToMinute(String time) {
            String[] timeInfo = time.split(":");
            return 60 * Integer.parseInt(timeInfo[0]) + Integer.parseInt(timeInfo[1]);
        }
        
        private List<String> getSoundList() {
            List<String> soundList = new ArrayList<>();
            for (int i = 0; i < melody.length(); i++) {
                String sound = melody.substring(i, i + 1);
                if (i == melody.length() - 1) {
                    soundList.add(sound);
                    break;
                }
                String next = melody.substring(i + 1, i + 2);
                if (next.equals("#")) {
                    soundList.add(sound + next);
                    i++;
                    continue;
                }
                soundList.add(sound);
            }
            
            return soundList;
        }
        
        private boolean checkContainNeoMelody(String totalMelody, String neoMelody) {
            String[] split = totalMelody.split(neoMelody);
            if (split.length == 1) {
                if (totalMelody.contains(neoMelody)) {
                    return true;
                }
                return false;
            }
            
            int cnt = 0;
            for (String next : split) {
                if (next.startsWith("#")) {
                    cnt++;
                }
            }
            
            if (cnt == split.length - 1) {
                return false;
            }
            
            return true;
        }
        
        public int compareTo(Music other) {
            int playTime = getPlayTime();
            int otherPlayTime = other.getPlayTime();
            if (playTime > otherPlayTime) {
                return -1;
            } else if (playTime > otherPlayTime) {
                return 1;
            } else {
                if (index < other.index) {
                    return -1;
                }
            }
            return 1;
        }
    }
    
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        List<Music> musics = new ArrayList<>();
        
        for (int i = 0; i < musicinfos.length; i++) {
            String[] musicInfo = musicinfos[i].split(",");
            musics.add(new Music(i, musicInfo[0], musicInfo[1], musicInfo[2], musicInfo[3]));
        }
        
        List<Music> filteredMusic = musics.stream()
            .filter(music -> music.containNeoMelody(m))
            .collect(Collectors.toList());
        
        if (filteredMusic.size() == 0) {
            return "(None)";
        }
        
        filteredMusic.sort((m1, m2) -> m1.compareTo(m2));
        
        return filteredMusic.get(0).name;
    }
}