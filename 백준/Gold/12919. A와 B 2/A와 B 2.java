import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();
        find(S, T);
        System.out.println(answer);
    }

    private static void find(String s, String t) {
        if (s.length() == t.length()) {
            if (s.equals(t)) {
                answer = 1;
                return;
            }
        }

        if (answer == 1) {
            return;
        }

        if (t.length() < s.length()) {
            return;
        }

        if (t.startsWith("B")) {
            String next = reverse(t);
            find(s, next);
        }

        if (t.endsWith("A")) {
            find(s, t.substring(0, t.length() - 1));
        }
    }

    private static String reverse(String t) {
        StringBuilder sb = new StringBuilder();
        char[] chars = t.toCharArray();

        for (int i = t.length() - 1; i > 0; i--) {
            sb.append(chars[i]);
        }

        return sb.toString();
    }
}
