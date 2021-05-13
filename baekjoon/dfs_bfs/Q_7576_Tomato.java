package baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_7576_Tomato {
	static int row, col, result, max;
	static int[][] matrix, visited;
	static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
	static Queue<Pair> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		col = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		matrix = new int[row][col];
		visited = new int[row][col];
		q = new LinkedList<>();
		
		for(int r=0 ; r<row ; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0 ; c<col ; c++) {
				matrix[r][c] = Integer.parseInt(st.nextToken());
				visited[r][c] = -1;
				if(matrix[r][c] == 1) {
					q.add(new Pair(r,c));
					visited[r][c] = 0;
				}
			}
		}
		
		bfs();
		if(checkZero(matrix))
			System.out.println(max);
		else
			System.out.println(-1);
	}
	
	public static void bfs() {
		while(!q.isEmpty()) {
			Pair cur = q.poll();
			
			for(int i=0 ; i<4 ; i++) {
				int nodeR = cur.r + dir[i][0];
				int nodeC = cur.c + dir[i][1];
				
				if(nodeR<0 || nodeR>=row || nodeC<0 || nodeC>= col) continue;
				else if(matrix[nodeR][nodeC] == 0 && visited[nodeR][nodeC] == -1) {
					visited[nodeR][nodeC] = visited[cur.r][cur.c] + 1;
					max = Math.max(max, visited[nodeR][nodeC]);
					matrix[nodeR][nodeC] = 1;
					q.add(new Pair(nodeR, nodeC));
				}
			}
		}
			
	}
	
	public static boolean checkZero(int[][] matrix) {
		for(int i=0 ; i<row ; i++) {
			for(int j=0 ; j<col ; j++) {
				if(matrix[i][j] == 0)
					return false;
			}
		}
		return true;
	}
	
	public static void write() {
 		for(int i=0 ; i<row ; i++) {
 			for(int j=0 ; j<col ; j++) {
 				System.out.print(matrix[i][j]+" ");
 			}
 			System.out.println();
 		}
 		System.out.println();
 	}
	
	public static class Pair {
		int r;
		int c;
		
		public Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
