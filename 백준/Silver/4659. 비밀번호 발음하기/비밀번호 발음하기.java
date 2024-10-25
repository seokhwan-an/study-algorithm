import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 모음을 반드시 하나 포함해야한다.
 * 모음 혹은 자음이 3개 연속으로 오면 안된다.
 * 같은 글자가 연속적으로 두번 오면 안되나, ee나 oo는 허용
 */
public class Main {

    static Set<Character> vowel;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        vowel = new HashSet<>();
        vowel.addAll(List.of('a', 'e', 'i', 'o', 'u'));

        StringBuilder sb = new StringBuilder();
        while(!input.equals("end")) {
            boolean available = true;
            if (!checkHasVowel(input)) {
                available = false;
            }

            if (!checkContinuous(input)) {
                available = false;
            }

            if (!checkSameContinuous(input)) {
                available = false;
            }

            if (available) {
                sb.append(String.format("<%s> is acceptable.%n", input));
            } else {
                sb.append(String.format("<%s> is not acceptable.%n", input));
            }
            input = br.readLine();
        }
        System.out.println(sb.toString());
    }

    private static boolean checkHasVowel(String input) {
        for (Character c : input.toCharArray()) {
            if (vowel.contains(c)) {
                return true;
            }
        }

        return false;
    }

    private static boolean checkContinuous(String input) {
        // 모음
        int check1 = 0;
        // 자음
        int check2 = 0;

        for (Character c : input.toCharArray()) {
            if (vowel.contains(c)) {
                check1 += 1;
                check2 = 0;
            } else {
                check1 = 0;
                check2 += 1;
            }

            if (check1 >= 3 || check2 >= 3) {
                return false;
            }
        }

        return true;
    }

    private static boolean checkSameContinuous(String input) {
        char pre = input.charAt(0);

        for (int i = 1; i < input.length(); i++) {
            char next = input.charAt(i);

            if (pre == next) {
                if (pre != 'e' && pre != 'o') {
                    return false;
                }
            }

            pre = next;
        }

        return true;
    }
}
