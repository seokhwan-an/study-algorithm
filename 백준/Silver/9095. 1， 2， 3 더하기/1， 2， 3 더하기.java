import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int[] dt;
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	int N = Integer.parseInt(br.readLine());
    	dt = new int[12];
    	int[] answer = new int[N];
    	for(int i = 0; i < N; i++) {
    		int num = Integer.parseInt(br.readLine());
    		answer[i] = dp(num);
    	}
    	for(int i = 0; i < N; i++) {
    		System.out.println(answer[i]);
    	}
    }
    public static int dp(int x) {
    	if(dt[x] != 0) {
    		return dt[x];
    	}
    	if(x == 1) {
    		return 1;
    	}
    	if(x == 2) {
    		return 2;
    	}
    	if(x == 3) {
    		return 4;
    	}
    	return dt[x] = dp(x-1) + dp(x-2) + dp(x-3);
    }
}