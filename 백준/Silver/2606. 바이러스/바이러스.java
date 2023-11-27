import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{
	public static ArrayList<ArrayList<Integer>> computer;
	static boolean[] check;
	
    public static void main(String[] args) throws IOException{ // BufferedReader를 사용하기 위해서는 해당 메소드에 throws IOException 구문이 필수입니다.
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        computer = new ArrayList<ArrayList<Integer>>();
        check = new boolean[N+1];
        for(int i = 1; i < check.length; i++) {
        	check[i] = false;
        }
        for (int i = 0; i <= N; i++)
			computer.add(new ArrayList<Integer>());
        for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			computer.get(p).add(q);
			computer.get(q).add(p);
		}
        dfs(1);
        int answer = 0;
        for(int i = 2; i <= N; i++) {
        	if(check[i]) answer++;
        }
        System.out.println(answer);
   }
    public static void dfs(int i) {
    	check[i] = true;
    	for(int y : computer.get(i)) {
    		if(check[y] == false)
    			dfs(y);
    	}
    }
}