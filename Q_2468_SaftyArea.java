package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_2468_SaftyArea {
	static int n, result, maxHigh, maxNum;
	static int[][] matrix;
	static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		matrix = new int[n][n];
		
		for(int i=0 ; i<n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0 ; j<n ; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
				maxHigh = Math.max(matrix[i][j],maxHigh);
			}
		}
		for(int w=0 ; w<=100; w++) {
			visited = new boolean[n][n];
			result = 0;
			for(int i=0 ; i<n ; i++) {
				for(int j=0 ; j<n ; j++) {
					if(matrix[i][j]>w && !visited[i][j]) {
						dfs(i,j,w);
						result++;
						maxNum = Math.max(maxNum, result);
					}
				}
			}
		}
		
		System.out.println(maxNum);
	}
	
	public static void dfs(int indexR, int indexC, int water) {
		visited[indexR][indexC] = true;
		
		for(int i=0 ; i<4 ; i++) {
			int nodeR = indexR + dir[i][0];
			int nodeC = indexC + dir[i][1];
			
			if(nodeR<0 || nodeR>=n || nodeC<0 || nodeC>=n) continue;
			else if(matrix[nodeR][nodeC]>water && !visited[nodeR][nodeC])
				dfs(nodeR, nodeC, water);
		}
	}
}
