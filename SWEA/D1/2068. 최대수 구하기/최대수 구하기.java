import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] answer = new int[n];
		
		for (int i = 0; i < n; i++) {
			int big = 0;
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < 10; j++) {
				int num = Integer.parseInt(input[j]);
				
				big = Math.max(big, num);
			}
			
			answer[i] = big;
		}
		
		for (int i = 0; i < n; i++) {
			System.out.println("#" + (i + 1) + " " + answer[i]);
		}
	}
}