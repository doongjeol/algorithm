package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_2178_Maze {
	public static int n,m;
	public static int[][] maze, visited;
	public static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		maze = new int[m][n];
		visited = new int[m][n];
		
		for(int i=0 ; i<m ; i++) {
			String temp = br.readLine();
			for(int j=0 ; j<n ; j++) {
				maze[i][j] = temp.charAt(j) - '0';
				visited[i][j] = -1;
			}
		}
		
		bfs();
		System.out.println(visited[m-1][n-1]);
	}
	
	public static void bfs() {
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(0,0));
		visited[0][0] = 1;
		
		while(!q.isEmpty()) {
			Pair cur = q.poll();
			
			for(int i=0 ; i<4 ; i++) {
				int nodeX = cur.x + dir[i][0];
				int nodeY = cur.y + dir[i][1];
				if(nodeX <0 || nodeX >=m || nodeY <0 || nodeY >= n) continue;
				else if(maze[nodeX][nodeY] == 1 && visited[nodeX][nodeY] == -1) {
					q.add(new Pair(nodeX, nodeY));
					visited[nodeX][nodeY] = visited[cur.x][cur.y] + 1;
				}
			}
			
			
		}
	}
	
	public static class Pair {
		int x;
		int y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
}
