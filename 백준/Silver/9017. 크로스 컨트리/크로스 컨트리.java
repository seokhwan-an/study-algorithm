import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            Map<Integer, List<Integer>> team = new HashMap<>();
            Map<Integer, Integer> teamScore = new HashMap<>();
            Map<Integer, Integer> count = new HashMap<>();
            Map<Integer, Boolean> available = new HashMap<>();

            int N = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            // team 추가
            for (int j = 0; j < N; j++) {
                int teamId = Integer.parseInt(input[j]);
                if (!team.containsKey(teamId)) {
                    List<Integer> member = new ArrayList<>();
                    member.add(j + 1);
                    team.put(teamId, member);
                    teamScore.put(teamId, 0);
                    count.put(teamId, 0);
                } else {
                    team.get(teamId).add(j + 1);
                }
            }

            // 점수 계산 가능 팀 확인
            for (int key : team.keySet()) {
                if (team.get(key).size() != 6) {
                    available.put(key, false);
                } else {
                    available.put(key, true);
                }
            }

            // 점수 계산
            int score = 1;
            for (int j = 0; j < N; j++) {
                int teamId = Integer.parseInt(input[j]);
                if (available.get(teamId)) {
                    if (count.get(teamId) < 4) {
                        teamScore.put(teamId, teamScore.get(teamId) + score);
                        count.put(teamId, count.get(teamId) + 1);
                    }
                    score++;
                }
            }


            // 우승 팀 구하기
            int win = Integer.MAX_VALUE;
            int winTeam = 0;
            for (int key : team.keySet()) {
                if (teamScore.get(key) != 0) {
                    if (teamScore.get(key) < win) {
                        win = teamScore.get(key);
                        winTeam = key;
                    } else if (teamScore.get(key) == win) {
                        int winTeamFive = team.get(winTeam).get(4);
                        int teamFive = team.get(key).get(4);
                        if (teamFive < winTeamFive) {
                            win = teamScore.get(key);
                            winTeam = key;
                        }
                    }
                }
            }
            sb.append(winTeam).append("\n");
        }
        System.out.println(sb.toString());
    }
}
