import java.util.*;

public class BOJ_1744 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = 0;
        int cnt = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if(num <= 0) cnt++;
            arr.add(num);
        }
        // 숫자 array 오름차순으로 정렬
        arr.sort(Comparator.naturalOrder());
        int a = 0;
        // 음수에 대햐여 수 묶기
        for(int i = 0; i < cnt; i++) {
            if(i % 2 == 0) {
                if(i == cnt-1) {
                    answer += arr.get(i);
                    break;
                }
                a = arr.get(i);

            }
            else if(i % 2 == 1) {
                int b = a + arr.get(i);
                int c = a * arr.get(i);
                if(b >= c) answer += b;
                if(c > b) answer += c;
            }
        }
        int check = 0;
        a = 0;
        //양수에 대하여 수 묶기
        for(int i = arr.size()-1; i >= cnt; i--) {
            if (check % 2 == 0) {
                if(i == cnt) {
                    answer += arr.get(i);
                    break;
                }
                a = arr.get(i);
                check++;
            }
            else if(check % 2 == 1) {
                int b = a + arr.get(i);
                int c = a * arr.get(i);
                if(b >= c) {
                    answer += b;
                    check++;
                }
                if(c > b) {
                    answer += c;
                    check++;
                }
            }
        }
        System.out.println(answer);
    }
}