import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution{
	public static void main(String args[]) throws Exception{
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
		//System.setIn(new FileInputStream("res/input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] answer = new int[n];
		
		for (int i = 0; i < n; i++) {
			int sum = 0;
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < 10; j++) {
				int num = Integer.parseInt(input[j]);
				
				if (num % 2 == 1) {
					sum += num;
				}
			}
			
			answer[i] = sum;
		}
		
		for (int i = 0; i < n; i++) {
			System.out.println("#" + (i + 1) + " " + answer[i]);
		}
	}
}