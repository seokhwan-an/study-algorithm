import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Main {

    static class Point implements Comparable<Point> {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo (Point other) {
            return this.x - other.x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Point> points = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] pointInfo = br.readLine().split(" ");
            int x = Integer.parseInt(pointInfo[0]);
            int y = Integer.parseInt(pointInfo[1]);
            points.add(new Point(x, y));
        }

        Collections.sort(points);

        // 가장 높은 벽 찾기
        int maxHeight = 0;
        int index = 0;
        for (int i = 0; i < N; i++) {
            Point point = points.get(i);
            if (point.y > maxHeight) {
                maxHeight = point.y;
                index = i;
            }
        }

        int answer = 0;

        // 왼쪽
        Stack<Point> leftStack = new Stack<>();
        for (int i = 0; i <= index; i++) {
            Point current = points.get(i);
            if (leftStack.isEmpty()) {
                leftStack.push(current);
                continue;
            }
            boolean available = false;
            while (!leftStack.isEmpty() && leftStack.peek().y <= current.y) {
                Point pre = leftStack.pop();
                answer += pre.y * (current.x - pre.x);
                available = true;
            }
            if (available) {
                leftStack.push(current);
            }
        }

        // 오른쪽
        Stack<Point> rightStack = new Stack<>();
        for (int i = N - 1; i >= index; i--) {
            Point current = points.get(i);
            if (rightStack.isEmpty()) {
                rightStack.push(current);
                continue;
            }
            boolean available = false;
            while (!rightStack.isEmpty() && rightStack.peek().y <= current.y) {
                Point pre = rightStack.pop();
                answer += pre.y * (pre.x - current.x);
                available = true;
            }
            if (available) {
                rightStack.push(current);
            }
        }

        answer += maxHeight;
        System.out.println(answer);
    }
}
