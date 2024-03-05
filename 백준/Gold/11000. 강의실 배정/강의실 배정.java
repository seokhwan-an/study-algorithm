import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Lesson> lessons = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] lessonInput = br.readLine().split(" ");
            int startTime = Integer.parseInt(lessonInput[0]);
            int endTime = Integer.parseInt(lessonInput[1]);
            lessons.add(new Lesson(startTime, endTime));
        }

        lessons.sort((l1, l2) ->
                         l1.getStart() == l2.getStart() ? l1.getEnd() - l2.getEnd() : l1.getStart() - l2.getStart());

        Queue<Integer> timeTable = new PriorityQueue<>();
        timeTable.add(lessons.get(0).getEnd());

        for (int i = 1; i < N; i++) {
            if (timeTable.peek() <= lessons.get(i).getStart()) {
                timeTable.poll();
            }
            timeTable.offer(lessons.get(i).getEnd());
        }

        System.out.println(timeTable.size());
    }

    static class Lesson {

        private int start;
        private int end;

        public Lesson(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

    }
}
