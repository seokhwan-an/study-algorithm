import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<String> words = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            words.add(word);
        }

        int maxLength = 0;
        String answer1 = "";
        String answer2 = "";
        for (int i = 0; i < words.size() - 1; i++) {
            String now = words.get(i);
            if (now.length() <= maxLength) {
                continue;
            }
            for (int j = i + 1; j < words.size(); j++) {
                String next = words.get(j);
                if (next.length() <= maxLength) {
                    continue;
                }
                int similarity = checkSimilarity(now, next);
                if (similarity > maxLength) {
                    maxLength = similarity;
                    answer1 = now;
                    answer2 = next;
                }
            }
        }

        System.out.println(answer1);
        System.out.println(answer2);
    }

    private static int checkSimilarity(String word1, String word2) {
        int length = Math.min(word1.length(), word2.length());
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (word1.charAt(i) == word2.charAt(i)) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}
