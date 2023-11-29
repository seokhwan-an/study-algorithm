import java.util.*;

public class Main {

    static List<Integer>[] graph;
    static List<Integer> knowPeople;
    static List<Party> parties;
    static boolean[] canKnowTrue;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        // 그래프 초기화
        graph = new ArrayList[N + 1];
        canKnowTrue = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 진실을 아는 사람 추가
        int knowPeopleCnt = sc.nextInt();
        knowPeople = new ArrayList<>();
        if (knowPeopleCnt > 0) {
            for (int i = 0; i < knowPeopleCnt; i++) {
                knowPeople.add(sc.nextInt());
            }
        }

        // 파티 추가
        parties = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int peopleCnt = sc.nextInt();
            List<Integer> participants = new ArrayList<>();
            for (int j = 0; j < peopleCnt; j++) {
                participants.add(sc.nextInt());
            }
            parties.add(new Party(peopleCnt, participants));
        }

        // 그래프 만들기
        for (Party party : parties) {
            List<Integer> participants = party.participants;
            for (int i = 0; i < participants.size(); i++) {
                int participant = participants.get(i);
                for (int j = 0; j < participants.size(); j++) {
                    if (i == j) {
                        continue;
                    }
                    int other = participants.get(j);

                    graph[participant].add(other);
                    graph[other].add(participant);
                }
            }
        }

        // 진실을 알 수 있는 사람들 체크
        checkPeopleCanKnowTrue();

        int answer = 0;
        for (Party party : parties) {
            final List<Integer> participants = party.participants;
            boolean check = true;
            for (int pariticipant : participants) {
                if (canKnowTrue[pariticipant]) {
                    check = false;
                    break;
                }
            }
            if (check) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static void checkPeopleCanKnowTrue() {
        Queue<Integer> queue = new LinkedList<>();

        for (int knowPerson : knowPeople) {
            if (canKnowTrue[knowPerson]) {
                continue;
            }
            canKnowTrue[knowPerson] = true;
            queue.add(knowPerson);

            while (!queue.isEmpty()) {
                final Integer person = queue.poll();
                final List<Integer> nexts = graph[person];

                for (int next : nexts) {
                    if (!canKnowTrue[next]) {
                        canKnowTrue[next] = true;
                        queue.add(next);
                    }
                }
            }
        }
    }

    static class Party {
        int participantCnt;
        List<Integer> participants;

        public Party(int participantCnt, List<Integer> participants) {
            this.participantCnt = participantCnt;
            this.participants = participants;
        }
    }
}
