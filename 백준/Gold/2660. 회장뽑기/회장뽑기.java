import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[][] graph;
    static int[] chairmanPoints;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        graph = new int[N + 1][N + 1];
        chairmanPoints = new int[N + 1];

        int start = sc.nextInt();
        int end = sc.nextInt();

        while (start != -1 && end != -1) {
            graph[start][end] = 1;
            graph[end][start] = 1;

            start = sc.nextInt();
            end = sc.nextInt();
        }

        calculateChairmanPoint(N);

        int minChairmanPoint = Integer.MAX_VALUE;

        for (int i = 1; i < chairmanPoints.length; i++) {
            int point = chairmanPoints[i];
            if (point < minChairmanPoint) {
                minChairmanPoint = point;
            }
        }
        int chairmanCnt = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < chairmanPoints.length; i++) {
            int point = chairmanPoints[i];
            if (point == minChairmanPoint) {
                chairmanCnt++;
                sb.append(i).append(" ");
            }
        }
        System.out.println(minChairmanPoint + " " + chairmanCnt);
        System.out.println(sb.toString());
    }

    private static void calculateChairmanPoint(int memberCount) {
        for (int i = 1; i <= memberCount; i++) {
            Queue<Member> queue = new LinkedList<>();
            boolean[] visited = new boolean[memberCount + 1];

            visited[i] = true;
            queue.add(new Member(i, 0));
            int chairmanPoint = 0;

            while (!queue.isEmpty()) {
                final Member member = queue.poll();
                chairmanPoint = member.friendLength;
                final int[] friends = graph[member.memberNumber];

                for (int j = 0; j < friends.length; j++) {
                    if (!visited[j] && friends[j] == 1) {
                        visited[j] = true;
                        queue.add(new Member(j, member.friendLength + 1));
                    }
                }
            }
            chairmanPoints[i] = chairmanPoint;
        }
    }

    static class Member {

        int memberNumber;
        int friendLength;

        public Member(int memberNumber, int friendLength) {
            this.memberNumber = memberNumber;
            this.friendLength = friendLength;
        }
    }
}
