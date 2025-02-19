// 장르별로 가장 많이 재생된 노래 두 개씩 모아 베스트 앨범 출리
// 속한 노래가 많이 재싱된 장르를 먼저 수록
// 장르 내에서 많이 재생된 노래 먼저 수록
// 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래 먼저 수록

import java.util.*;

class Solution {
    
    class Song implements Comparable<Song>{
        int index;
        int playCnt;
        
        public Song(int index, int playCnt) {
            this.index = index;
            this.playCnt = playCnt;
        }
        
        @Override
        public int compareTo(Song other) {
            if (this.playCnt == other.playCnt) {
                return this.index - other.index;
            }
            return other.playCnt - this.playCnt;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> playCount = new HashMap<>();
        Map<String, List<Song>> songs = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            
            if (!playCount.containsKey(genre)) {
                playCount.put(genre, play);
            } else {
                playCount.put(genre, playCount.get(genre) + play);
            }
            
            if (!songs.containsKey(genre)) {
                List<Song> songList = new ArrayList<>();
                songList.add(new Song(i, play));
                songs.put(genre, songList);
            } else {
                songs.get(genre).add(new Song(i, play));
            }
        }
        
        
        List<Map.Entry<String, Integer>> genreList = new ArrayList<>(playCount.entrySet());
        genreList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        List<Song> check = new ArrayList<>();
        
        for (Map.Entry<String, Integer> entry : genreList) {
            String genre = entry.getKey();
            
            List<Song> s = songs.get(genre);
            Collections.sort(s);
            
            if (s.size() >= 2) {
                check.add(s.get(0));
                check.add(s.get(1));
            } else if (s.size() == 1) {
                check.add(s.get(0));
            } 
        }
        
        int[] answer = new int[check.size()];
        int index = 0;
        for (Song song : check) {
            answer[index++] = song.index;
        }
        
        return answer;
    }
}