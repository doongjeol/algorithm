package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_11724_TheNumberOfConnecting {
	static int[][] matrix;
	static boolean[] visited;
	static int number, startR, startC;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		number = Integer.parseInt(st.nextToken()); 
		int line = Integer.parseInt(st.nextToken());
		
		matrix = new int[number+1][number+1];
		visited = new boolean[number+1];
		for(int i=0 ; i<line ; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			matrix[u][v] = matrix[v][u] = 1;
		}
		
		System.out.println(dfsAll());
				
	}
	
	public static int dfsAll() {
		int component = 0;
		
		for(int i=1 ; i<number+1 ; i++) {
			if(!visited[i]) {
				dfs(i);
				component ++;
			}
		}
		
		return component;
	}
	
	public static void dfs(int index) {
		visited[index] = true;
		
		for(int i=1 ; i<number+1 ; i++) {
			if(matrix[index][i] == 1 && !visited[i])
				dfs(i);
		}
	}
}