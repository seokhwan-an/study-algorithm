import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    static class Word implements Comparable<Word>{
        String word;
        int count;

        public Word(String word, int count) {
            this.word = word;
            this.count = count;
        }

        @Override
        public int compareTo(Word o) {
            if (this.count == o.count) {
                if (this.word.length() == o.word.length()) {
                    return this.word.compareTo(o.word);
                }
                return o.word.length() - this.word.length();
            }
            return o.count - this.count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        Map<String, Integer> count = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String word = br.readLine();

            if (word.length() < M) {
                continue;
            }
            if (count.containsKey(word)) {
                count.put(word, count.get(word) + 1);
            } else {
                count.put(word, 1);
            }
        }

        List<Word> words = new ArrayList<>();
        for (String key : count.keySet()) {
            words.add(new Word(key, count.get(key)));
        }
        Collections.sort(words);

        StringBuilder sb = new StringBuilder();
        for (Word word : words) {
            sb.append(word.word).append("\n");
        }
        System.out.println(sb.toString());
    }
}
