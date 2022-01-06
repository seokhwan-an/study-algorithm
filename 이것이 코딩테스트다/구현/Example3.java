import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Example3 {
    // 왕실의 나이트
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[][] move = {{-2,-1},{-2,1},{2,-1},{2,1},{1,-2},{-1,-2},{1,2},{-1,2}};
        String str = sc.nextLine();
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        map.put('a',1);
        map.put('b',2);
        map.put('c',3);
        map.put('d',4);
        map.put('e',5);
        map.put('f',6);
        map.put('g',7);
        map.put('h',8);
        int answer = 0;
        int nx = -1, ny = -1;
        for(int i = 0; i < move.length; i++){
            nx = map.get(str.charAt(0)) + move[i][0];
            ny = Character.getNumericValue(str.charAt(1)) + move[i][1];
            if(nx <1 || nx > 8 || ny < 1 || ny > 8){
                continue;
            }
            answer++;
        }
        System.out.println(answer);
    }
}
