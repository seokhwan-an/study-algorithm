import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static class Track {
        int cnt;
        int position;

        public Track(int cnt, int position) {
            this.cnt = cnt;
            this.position = position;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] pointInfo = br.readLine().split(" ");
        boolean[] visited = new boolean[100001];

        int subin = Integer.parseInt(pointInfo[0]);
        int sister = Integer.parseInt(pointInfo[1]);

        int answer = Integer.MAX_VALUE;

        Queue<Track> queue = new LinkedList<>();
        queue.offer(new Track(0, subin));
        while(!queue.isEmpty()) {
            Track p = queue.poll();
            visited[p.position] = true;

            if (p.position == sister) {
                answer = Math.min(answer , p.cnt);
                continue;
            }

            int pre = p.position - 1;
            if (pre >= 0 && !visited[pre]) {
                queue.add(new Track(p.cnt + 1, pre));
            }

            int next = p.position + 1;
            if (next <= 100000 && !visited[next]) {
                queue.add(new Track(p.cnt + 1, next));
            }

            int teleport = p.position * 2;
            if (teleport <= 100000 && !visited[teleport]) {
                queue.add(new Track(p.cnt, teleport));
            }
        }
        System.out.println(answer);
    }
}
