import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int index = Integer.parseInt(input[0]);
            int move = 0;
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < 20; j++) {
                int num = Integer.parseInt(input[j + 1]);
                if (list.isEmpty()) {
                    list.add(num);
                } else {
                    int next = 0;
                    for (int k = 0; k < list.size(); k++) {
                        if (list.get(k) > num) {
                            break;
                        }
                        next++;
                    }

                    move += list.size() - next;
                    list.add(num);
                    Collections.sort(list);
                }
            }

            sb.append(index).append(" ").append(move).append("\n");
        }

        System.out.println(sb.toString());
    }
}
