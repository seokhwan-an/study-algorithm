import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        final int aLength = Integer.parseInt(inputs[0]);
        final int bLength = Integer.parseInt(inputs[1]);

        int[] A = new int[aLength];
        int[] B = new int[bLength];

        String[] aInput = br.readLine().split(" ");
        for (int i = 0; i < aLength; i++) {
            A[i] = Integer.parseInt(aInput[i]);
        }

        String[] bInput = br.readLine().split(" ");
        for (int i = 0; i < bLength; i++) {
            B[i] = Integer.parseInt(bInput[i]);
        }
        Arrays.sort(A);
        Arrays.sort(B);

        StringBuilder sb = new StringBuilder();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < aLength; i++) {
            if (binarySearch(A[i], B)) {
                set.add(A[i]);
            }
        }

        int cnt = set.size();
        sb.append(cnt).append("\n");
        if (cnt > 0) {
            for (int number : A) {
                if (set.contains(number)) {
                    sb.append(number).append(" ");
                }
            }
        }

        System.out.println(sb.toString().trim());
    }

    private static boolean binarySearch(int number, int[] B) {
        int start = 0;
        int end = B.length - 1;

        while(start <= end) {
            int mid = (start + end) / 2;
            int check = B[mid];

            if (check == number) {
                return false;
            }
            if (check > number) {
                end = mid - 1;
            } else if (check < number) {
                start = mid + 1;
            }
        }

        return true;
    }
}
