package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// ����Ž�� - DFS
public class Q_14501_Resignation {
	static int N, maxPrice;
	static int[][] schedule;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		schedule = new int[N][2];
		// ������ �Է�
		for(int i=0; i<N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<2 ; j++) 
				schedule[i][j] = Integer.parseInt(st.nextToken());
		}
		
		recursiveDFS(0, 0);
		System.out.println(maxPrice);
		
	}
	
	public static void recursiveDFS(int i, int totalPrice) {
		// i�� N���� ũ�ų� ������ ����
		if(i>= N) {
			if(maxPrice < totalPrice)
				maxPrice = totalPrice;
			return;
		}
		
		// i��° ���� ����� ���
		// i��° �� + ��㿡 �ʿ��� �� ��
		if(i+schedule[i][0] <= N) 
			recursiveDFS(i+schedule[i][0], totalPrice+schedule[i][1]);
		
		// i��° ���� ������� ���� ���
		if(i+1<=N) 
			recursiveDFS(i+1, totalPrice);
	}
}
