import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, ArrayList<Integer>> loc = new HashMap<Integer, ArrayList<Integer>>();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(loc.keySet().contains(y)){
                loc.get(y).add(x);
            }
            else{
                loc.put(y,new ArrayList<Integer>());
                loc.get(y).add(x);
            }
        }
        Object[] check = loc.keySet().toArray();
        Arrays.sort(check);
        for(Object y : check){
            loc.get(y).sort(Comparator.naturalOrder());
            for(int i = 0; i < loc.get(y).size(); i++){
                System.out.println(loc.get(y).get(i)+" "+y);
            }
        }
    }
}