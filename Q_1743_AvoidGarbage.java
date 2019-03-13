package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_1743_AvoidGarbage {
	static int n, m, max, count;
	static int[][] matrix;
	static boolean[][] visited;
	static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 통로의 세로 길이
		m = Integer.parseInt(st.nextToken()); // 통로의 가로 길이
		int k = Integer.parseInt(st.nextToken()); // 음식물 쓰레기의 개수
		matrix = new int[n+1][m+1];
		visited = new boolean[n+1][m+1];
		
		for(int i=0 ; i<k ; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			matrix[r][c] = 1;
		}
		
		for(int i=1 ; i<n+1 ; i++) {
			for(int j=1 ; j<m+1 ; j++) {
				if(matrix[i][j] == 1 && !visited[i][j]) {
					visited[i][j] = true;
					dfs(i, j);
					count = 0;
				}
			}
		}
		
		System.out.println(max);
	}
	
	public static void dfs(int indexR, int indexC) {
		visited[indexR][indexC] = true;
		count++;
		max = Math.max(max, count);
		
		for(int i=0 ; i<4 ; i++) {
			int nodeR = indexR + dir[i][0];
			int nodeC = indexC + dir[i][1];
			
			if(nodeR<=0 || nodeR>n || nodeC<=0 || nodeC>m) continue;
			else if(matrix[nodeR][nodeC] == 1 && !visited[nodeR][nodeC]) {
//				System.out.println("index: "+indexR +" "+indexC+" node: "+nodeR +" "+nodeC + " " + count);
				dfs(nodeR, nodeC);
			}
		}
		
	}
	
	public static void write() {
 		for(int i=1 ; i<n+1 ; i++) {
 			for(int j=1 ; j<m+1 ; j++) {
 				System.out.print(matrix[i][j]+" ");
 			}
 			System.out.println();
 		}
 		System.out.println();
 	}
}
