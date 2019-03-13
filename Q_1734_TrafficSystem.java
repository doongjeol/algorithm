package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Q_1734_TrafficSystem {
	static int n;
	static boolean flag;
	static int[][] matrix;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 도시의 개수
		int e = Integer.parseInt(st.nextToken()); // 도로의 개수
		matrix = new int[n+1][n+1];
		visited = new boolean[n+1];
		
		for(int i=0 ; i<e ; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken()); // 연결된 도시 번호 1
			int n2 = Integer.parseInt(st.nextToken()); // 연결된 도시 번호 2
			
			matrix[n1][n2] = matrix[n2][n1] = 1;
			
		}

		
		int q = Integer.parseInt(br.readLine()); // 질문의 개수
		
		for(int i=0 ; i<q ; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			switch(first) {
			case 1:
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int g1 = Integer.parseInt(st.nextToken());
				int g2 = Integer.parseInt(st.nextToken());
				
				matrix[g1][g2] = matrix[g2][g1] = 0;
				
				dfs(a,b);
				
				if(flag)
					System.out.println("yes");
				else
					System.out.println("no");
				init();
				matrix[g1][g2] = matrix[g2][g1] = 1;
				
				break;
			case 2:
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				for(int j=1 ; j<n+1 ; j++) {
					if(matrix[j][c] == 1 ) 
						matrix[j][c] = matrix[c][j] = 0;
				}
				
				dfs(a,b);
				if(flag)
					System.out.println("yes");
				else
					System.out.println("no");
				
				init();
				for(int j=1 ; j<n+1 ; j++) {
					if(matrix[j][c] == 0 ) 
						matrix[j][c] = matrix[c][j] = 1;
				}
				
				break;
			}
		}
	}
	
	public static void dfs(int startIndex, int endIndex) {
		visited[startIndex] = true;
		
		for(int i=1 ; i<n+1 ; i++) {
			if(matrix[startIndex][i] == 1 && !visited[i]) {
//				System.out.println(startIndex+" "+i + " ");
				if(endIndex == i) { 
					flag = true;
					break;
				} else
					dfs(i, endIndex);
			}
		}
		
	}
	
	public static void init() {
		Arrays.fill(visited, false);
		flag = false;
	}
	
	public static void write() {
 		for(int i=0 ; i<n+1 ; i++) {
 			for(int j=0 ; j<n+1 ; j++) {
 				System.out.print(matrix[i][j]+" ");
 			}
 			System.out.println();
// 			System.out.print(visited[i]+" ");
 		}
 		System.out.println();
 	}
	
}
