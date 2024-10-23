import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split("");

        int cnt = 0;
        int redRightCnt = 0;
        int blueRightCnt = 0;
        String pre = "";
        for (String type : input) {
            if (pre.equals("")) {
                cnt++;
                pre = type;
                continue;
            }

            if (!pre.equals(type)) {
                if (pre.equals("R")) {
                    redRightCnt += cnt;
                } else {
                    blueRightCnt += cnt;
                }
                pre = type;
                cnt = 1;
                continue;
            }
            cnt++;
        }
        int rightMin = Math.min(redRightCnt, blueRightCnt);

        cnt = 0;
        int redLeftCnt = 0;
        int blueLeftCnt = 0;
        pre = "";
        for (int i = input.length - 1; i >= 0; i--) {
            String type = input[i];
            if (pre.equals("")) {
                cnt++;
                pre = type;
                continue;
            }

            if (!pre.equals(type)) {
                if (pre.equals("R")) {
                    redLeftCnt += cnt;
                } else {
                    blueLeftCnt += cnt;
                }
                pre = type;
                cnt = 1;
                continue;
            }
            cnt++;
        }

        int leftMin = Math.min(redLeftCnt, blueLeftCnt);

        System.out.println(Math.min(rightMin, leftMin));
    }
}
