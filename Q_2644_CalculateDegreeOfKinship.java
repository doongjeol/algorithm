package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_2644_CalculateDegreeOfKinship {
	public static int[][] matrix;
	public static int[] visited;
	public static int n,person1, person2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		matrix = new int[n+1][n+1];
		visited = new int[n+1];
		Arrays.fill(visited, -1);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		person1 = Integer.parseInt(st.nextToken());
		person2 = Integer.parseInt(st.nextToken());
		int relation = Integer.parseInt(br.readLine());
		
		for(int i=0 ; i<relation ; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			matrix[x][y] = matrix[y][x] = 1;
		}
		
		bfs();
		System.out.println(visited[person2]);
		
	}
	
	public static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(person1);
		visited[person1] = 0;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int y=1; y<n+1 ; y++) {
				if(matrix[cur][y] == 1 && visited[y] == -1) {
					visited[y] = visited[cur] + 1;
					q.add(y);
				} 
			}
		}
		
	}
}
