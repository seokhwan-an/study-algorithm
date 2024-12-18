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

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int d = Integer.parseInt(input[1]);
        int k = Integer.parseInt(input[2]);
        int c = Integer.parseInt(input[3]);

        Map<Integer, Integer> sushiCheck = new HashMap<>();

        List<Integer> sushiList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            sushiList.add(Integer.parseInt(br.readLine()));
        }
        int count = 0;
        int answer = 0;
        for (int i = 0; i < k; i++) {
            int sushi = sushiList.get(i);
            if (sushiCheck.containsKey(sushi)) {
                sushiCheck.put(sushi, sushiCheck.get(sushi) + 1);
            } else {
                answer++;
                count++;
                sushiCheck.put(sushi, 1);
            }
        }

        if (!sushiCheck.containsKey(c) || sushiCheck.get(c) == 0) {
            answer++;
        }

        int start = 1;
        int end = k;
        while(start != N) {
            start %= N;
            end %= N;

            int delete = sushiList.get(start - 1);
            int add = sushiList.get(end);

            // 삭제
            int sushiCount = sushiCheck.get(delete);
            if (sushiCount == 1) {
                count--;
                sushiCheck.remove(delete);
            } else {
                sushiCheck.put(delete, sushiCount - 1);
            }

            // 추가
            if (sushiCheck.containsKey(add)) {
                sushiCheck.put(add, sushiCheck.get(add) + 1);
            } else {
                count++;
                sushiCheck.put(add, 1);
            }

            // 쿠폰 체크
            if (sushiCheck.containsKey(c)) {
                answer = Math.max(answer, count);
            } else {
                answer = Math.max(answer, count + 1);
            }

            // 다음
            start++;
            end++;
        }

        System.out.println(answer);
    }
}
