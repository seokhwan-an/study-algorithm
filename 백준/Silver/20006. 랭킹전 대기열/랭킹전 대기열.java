import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static class Player {
        int level;
        String name;

        public Player(int level, String name) {
            this.level = level;
            this.name = name;
        }
    }

    static class Room {
        int level;
        List<Player> players;

        public Room(int level, List<Player> players) {
            this.level = level;
            this.players = players;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int p = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < p; i++) {
            String[] pInput = br.readLine().split(" ");
            int level = Integer.parseInt(pInput[0]);
            String name = pInput[1];

            if (rooms.isEmpty()) {
                List<Player> players = new ArrayList<>();
                players.add(new Player(level, name));
                rooms.add(new Room(level, players));
                continue;
            }

            boolean makeNew = true;
            for (Room room : rooms) {
                int diff = room.level - level;
                if (-10 <= diff && diff <= 10) {
                    if (room.players.size() < m) {
                        room.players.add(new Player(level, name));
                        makeNew = false;
                        break;
                    }
                }
            }

            if (makeNew) {
                List<Player> players = new ArrayList<>();
                players.add(new Player(level, name));
                rooms.add(new Room(level, players));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Room room : rooms) {
            if (room.players.size() == m) {
                sb.append("Started!").append("\n");
            } else {
                sb.append("Waiting!").append("\n");
            }
            
            Collections.sort(room.players, (p1, p2) -> p1.name.compareTo(p2.name));
            for (Player player : room.players) {
                sb.append(player.level).append(" ").append(player.name).append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}
