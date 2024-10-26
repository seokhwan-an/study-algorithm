import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    static class Stone implements Comparable<Stone> {
        int weight;
        int value;

        public Stone(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        @Override
        public int compareTo(Stone o) {
            if (this.weight != o.weight) {
                return this.weight - o.weight;
            }
            return o.value - this.value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        Stone[] stones = new Stone[N];
        for (int i = 0; i < N; i++) {
            String[] stoneInput = br.readLine().split(" ");
            int weight = Integer.parseInt(stoneInput[0]);
            int value = Integer.parseInt(stoneInput[1]);
            stones[i] = new Stone(weight, value);
        }

        Arrays.sort(stones);

        int[] bags = new int[K];

        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bags);
        long answer = 0;
        Queue<Integer> queue = new PriorityQueue<>((j1, j2) -> j2 - j1);
        int index = 0;
        for (int i = 0; i < K; i++) {
            while(index < N && stones[index].weight <= bags[i]) {
                queue.offer(stones[index++].value);
            }

            if (!queue.isEmpty()) {
                answer += queue.poll();
            }
        }

        System.out.println(answer);
    }
}
