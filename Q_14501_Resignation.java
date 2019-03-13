package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 완전탐색 - DFS
public class Q_14501_Resignation {
	static int N, maxPrice;
	static int[][] schedule;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		schedule = new int[N][2];
		// 스케줄 입력
		for(int i=0; i<N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<2 ; j++) 
				schedule[i][j] = Integer.parseInt(st.nextToken());
		}
		
		recursiveDFS(0, 0);
		System.out.println(maxPrice);
		
	}
	
	public static void recursiveDFS(int i, int totalPrice) {
		// i가 N보다 크거나 같으면 중지
		if(i>= N) {
			if(maxPrice < totalPrice)
				maxPrice = totalPrice;
			return;
		}
		
		// i번째 날에 상담할 경우
		// i번째 날 + 상담에 필요한 일 수
		if(i+schedule[i][0] <= N) 
			recursiveDFS(i+schedule[i][0], totalPrice+schedule[i][1]);
		
		// i번째 날에 상담하지 않을 경우
		if(i+1<=N) 
			recursiveDFS(i+1, totalPrice);
	}
}
