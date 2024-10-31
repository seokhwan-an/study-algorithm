import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] positionInfo = br.readLine().split(" ");
        int a = Integer.parseInt(positionInfo[0]);
        int b = Integer.parseInt(positionInfo[1]);

        boolean[] visited = new boolean[100001];
        int[] track = new int[100001];
        int[] time = new int[100001];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(a);
        visited[a] = true;
        while(!queue.isEmpty()) {
            int p = queue.poll();

            if (p == b) {
                List<Integer> trackLog = new ArrayList<>();
                trackLog.add(p);
                while (p != a) {
                    trackLog.add(track[p]);
                    p = track[p];
                }

                StringBuilder sb = new StringBuilder();
                for (int i = trackLog.size() - 1; i >= 0; i--) {
                    sb.append(trackLog.get(i)).append(" ");
                }
                System.out.println(time[b]);
                System.out.println(sb.toString());

                break;
            }

            int forward = p + 1;
            if (forward <= 100000 && !visited[forward]) {
                visited[forward] = true;
                time[forward] = time[p] + 1;
                track[forward] = p;
                queue.offer(forward);
            }

            int back = p - 1;
            if (back >= 0 && !visited[back]) {
                visited[back] = true;
                time[back] = time[p] + 1;
                track[back] = p;
                queue.offer(back);
            }

            int teleport = p * 2;
            if (teleport <= 100000 && !visited[teleport]) {
                visited[teleport] = true;
                time[teleport] = time[p] + 1;
                track[teleport] = p;
                queue.offer(teleport);
            }
        }
    }
}
