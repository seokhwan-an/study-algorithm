import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String infos = br.readLine();
            int n = Integer.parseInt(br.readLine());
            Deque<Integer> num_arr = new ArrayDeque<>();
            String num = br.readLine();
            String[] numbers = num.substring(1, num.length() - 1).split(",");
            for (String nums : numbers) {
                if (!nums.equals("")) {
                    num_arr.add(Integer.parseInt(nums));
                }
            }
            boolean check = true;
            boolean reverse = false;
            for (char info : infos.toCharArray()) {
                if (info == 'R') {
                    reverse = !reverse;
                } else {
                    if (num_arr.size() == 0) {
                        check = false;
                        break;
                    }
                    if (reverse) {
                        num_arr.pollLast();
                    } else {
                        num_arr.pollFirst();
                    }
                }
            }
            if (check == true) {
                sb.append("[");
                while (!num_arr.isEmpty()) {
                    if (reverse == true) {
                        sb.append(num_arr.pollLast());
                    } else {
                        sb.append(num_arr.pollFirst());
                    }
                    if (num_arr.size() != 0) {
                        sb.append(",");
                    }
                }
                sb.append("]\n");
            } else {
                sb.append("error\n");
            }
        }
        System.out.println(sb);
    }
}