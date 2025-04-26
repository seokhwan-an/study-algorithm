import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        List<int[]> mineralGroups = new ArrayList<>();
        int maxPicks = (picks[0] + picks[1] + picks[2]);
        
        // 광물 5개씩 그룹핑 (최대 곡괭이 수까지만)
        for (int i = 0; i < minerals.length && i / 5 < maxPicks; i += 5) {
            int[] group = new int[3]; // [다이아, 철, 돌]
            for (int j = i; j < i + 5 && j < minerals.length; j++) {
                if (minerals[j].equals("diamond")) {
                    group[0]++;
                } else if (minerals[j].equals("iron")) {
                    group[1]++;
                } else {
                    group[2]++;
                }
            }
            mineralGroups.add(group);
        }

        // 가치 높은 그룹부터 (다이아 > 철 > 돌 많은 순)
        mineralGroups.sort((a, b) -> {
            if (b[0] != a[0]) return b[0] - a[0];
            if (b[1] != a[1]) return b[1] - a[1];
            return b[2] - a[2];
        });

        int fatigue = 0;
        int groupIndex = 0;

        for (int pickType = 0; pickType < 3; pickType++) {
            while (picks[pickType] > 0 && groupIndex < mineralGroups.size()) {
                int[] group = mineralGroups.get(groupIndex);
                fatigue += calculateFatigue(pickType, group);
                picks[pickType]--;
                groupIndex++;
            }
        }

        return fatigue;
    }

    private int calculateFatigue(int pickType, int[] group) {
        int fatigue = 0;
        int dia = group[0];
        int iron = group[1];
        int stone = group[2];
        
        if (pickType == 0) { // 다이아곡괭이
            fatigue += (dia + iron + stone) * 1;
        } else if (pickType == 1) { // 철곡괭이
            fatigue += dia * 5 + (iron + stone) * 1;
        } else { // 돌곡괭이
            fatigue += dia * 25 + iron * 5 + stone * 1;
        }
        return fatigue;
    }
}
