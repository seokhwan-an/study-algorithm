import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");

        int n = Integer.parseInt(inputs[1]);

        PriorityQueue<Long> queue = new PriorityQueue<>();
        String[] numberInputs = br.readLine().split(" ");

        for (String number : numberInputs) {
            queue.add(Long.parseLong(number));
        }

        for (int i = 0; i < n; i++) {
            long number1 = queue.poll();
            long number2 = queue.poll();
            long sum = number1 + number2;

            queue.offer(sum);
            queue.offer(sum);
        }

        long answer = 0;
        while(!queue.isEmpty()) {
            answer += queue.poll();
        }

        System.out.println(answer);
    }
}
