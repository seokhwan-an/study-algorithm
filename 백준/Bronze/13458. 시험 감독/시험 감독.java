import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] classRoom = new int[N];
        String[] students = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            classRoom[i] = Integer.parseInt(students[i]);
        }

        String[] viewerInfo = br.readLine().split(" ");
        int master = Integer.parseInt(viewerInfo[0]);
        int subMaster = Integer.parseInt(viewerInfo[1]);


        long answer = 0;

        for (int i = 0; i < N; i++) {
            int subMasterTotalStudent = classRoom[i] - master;

            if (subMasterTotalStudent <= 0) {
                answer += 1;
                continue;
            }

            int divide = subMasterTotalStudent % subMaster;
            if (divide == 0) {
                answer += (subMasterTotalStudent / subMaster + 1);
            } else {
                answer += (subMasterTotalStudent / subMaster + 2);
            }
        }
        System.out.println(answer);
    }
}
