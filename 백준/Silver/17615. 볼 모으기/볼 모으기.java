import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split("");
        List<Integer> redCnt = new ArrayList<>();
        List<Integer> blueCnt = new ArrayList<>();

        int cnt = 0;
        String pre = "";
        for (String type : input) {
            if (pre.equals("")) {
                cnt++;
                pre = type;
                continue;
            }

            if (!pre.equals(type)) {
                if (pre.equals("R")) {
                    redCnt.add(cnt);
                } else {
                    blueCnt.add(cnt);
                }
                pre = type;
                cnt = 1;
                continue;
            }
            cnt++;
        }

        int totalRed = sum(redCnt);
        int totalBlue = sum(blueCnt);

        System.out.println(Math.min(totalRed, totalBlue));
    }

    private static int sum(List<Integer> cnt) {
        int result = 0;
        for (int number : cnt) {
            result += number;
        }

        return result;
    }
}
