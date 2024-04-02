import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> check = new HashSet<>();

        String input = br.readLine();

        for (int i = 1; i <= input.length(); i++) {
            for (int j = 0; j <= input.length() - i; j++) {
                check.add(input.substring(j, j + i));
            }
        }

        System.out.println(check.size());
    }
}
