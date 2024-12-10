import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            String[] input = br.readLine().split(" ");
            // 팀의 수
            int n = Integer.parseInt(input[0]);
            // 문제의 수
            int k = Integer.parseInt(input[1]);
            // 내 팀
            int t = Integer.parseInt(input[2]);
            // 로그 수
            int m = Integer.parseInt(input[3]);

            int[] scores = new int[n + 1];
            int[] count = new int[n + 1];
            int[] last = new int[n + 1];
            List<int[]> logs = new ArrayList<>();
            List<int[]> rank = new ArrayList<>();

            for (int j = 0; j < m; j++) {
                String[] logInput = br.readLine().split(" ");
                int team = Integer.parseInt(logInput[0]);
                int problem = Integer.parseInt(logInput[1]);
                int score = Integer.parseInt(logInput[2]);
                count[team]++;
                last[team] = j;
                boolean isContain = false;
                for (int h = 0;  h < logs.size(); h++) {
                    int[] log = logs.get(h);
                    if (log[0] == team && log[1] == problem) {
                        if (score > log[2]) {
                            scores[team] -= log[2];
                            scores[team] += score;
                            log[2] = score;
                        }
                        isContain = true;
                        break;
                    }
                }

                if (!isContain) {
                    logs.add(new int[] {team, problem, score});
                    scores[team] += score;
                }
            }

            for (int j = 1; j <= n; j++) {
                rank.add(new int[] {j, scores[j], count[j], last[j]});
            }
            Collections.sort(rank, (r1, r2) -> r1[1] == r2[1] ? r1[2] == r2[2] ? r1[3] - r2[3] : r1[2] - r2[2] : r2[1] - r1[1]);

            for (int j = 0; j < rank.size(); j++) {
                int[] rankInfo = rank.get(j);
                if (rankInfo[0] == t) {
                    sb.append(j + 1).append("\n");
                    break;
                }
            }
        }

        System.out.println(sb.toString());
    }
}
