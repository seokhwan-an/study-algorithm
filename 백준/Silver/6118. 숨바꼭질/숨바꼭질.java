import java.util.*;

public class Main {

    static List<Integer>[] graph;
    static boolean[] visited;
    static int maxLength = 0;
    static List<Load> loads = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            graph[start].add(end);
            graph[end].add(start);
        }

        bfs(1);

        int minSite = Integer.MAX_VALUE;
        int cnt = 0;
        for (Load load : loads) {
            if (load.length == maxLength) {
                minSite = Math.min(minSite, load.site);
                cnt++;
            }
        }

        System.out.println(minSite + " " + maxLength + " " + cnt);
    }

    private static void bfs(int start) {
        Queue<Load> queue = new LinkedList();
        visited[start] = true;
        Load thisSite = new Load(start, 0);
        queue.add(thisSite);

        while(!queue.isEmpty()) {
            final Load site = queue.poll();
            List<Integer> nextSites = graph[site.site];

            for (int nextSite : nextSites) {
                if (!visited[nextSite]) {
                    visited[nextSite] = true;
                    maxLength = Math.max(maxLength, site.length + 1);
                    final Load next = new Load(nextSite, site.length + 1);
                    loads.add(next);
                    queue.add(next);
                }
            }
        }
    }

    static class Load {
        int site;
        int length;

        public Load(int site, int length) {
            this.site = site;
            this.length = length;
        }
    }
}
