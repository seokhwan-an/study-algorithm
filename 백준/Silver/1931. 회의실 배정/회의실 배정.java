import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] meetings = new int[N][2];

        for (int i = 0; i < N; i++) {
            String[] meetingInputs = br.readLine().split(" ");
            meetings[i][0] = Integer.parseInt(meetingInputs[0]);
            meetings[i][1] = Integer.parseInt(meetingInputs[1]);
        }

        Arrays.sort(meetings, (m1, m2) ->  m1[1] == m2[1] ? m1[0] - m2[0] : m1[1] - m2[1]);

        int answer = 1;
        int endTime = meetings[0][1];
        for (int i = 1; i < N; i++) {
            int nextMeetingStartTime = meetings[i][0];
            int nextMeetingEndTime = meetings[i][1];

            if (endTime <= nextMeetingStartTime) {
                endTime = nextMeetingEndTime;
                answer++;
            }
        }

        System.out.println(answer);
    }
}
