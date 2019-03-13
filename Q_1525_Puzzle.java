package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_1525_Puzzle {
	static int[][] matrix, visited;
	static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
	static int startR, startC;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		matrix = new int[3][3];
		visited = new int[3][3];
		for(int r=0 ; r<3 ; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int c=0 ; c<3 ; c++) {
				matrix[r][c] = Integer.parseInt(st.nextToken());
				visited[r][c] = -1;
				if(matrix[r][c] == 0) {
					startR = r ; startC = c;
				}
			}
		}
		check();
		bfs();
		System.out.println(visited[2][2]);
		
	}
	
	public static void bfs() {
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(startR, startC));
		visited[startR][startC] = 0;
		
		while(!q.isEmpty()) {
			Pair cur = q.poll();
			
			for(int i=0 ; i<4 ; i++) {
				int nodeR = cur.r + dir[i][0];
				int nodeC = cur.c + dir[i][1];
				
				if(nodeR<0 || nodeR>=3 || nodeC<0 || nodeC>=3) continue;
				else if( visited[nodeR][nodeC] == -1) {
					int temp = matrix[cur.r][cur.c];
					matrix[cur.r][cur.c] = matrix[nodeR][nodeC];
					matrix[nodeR][nodeC] = temp;
					visited[nodeR][nodeC] = visited[cur.r][cur.c] + 1;
					q.add(new Pair(nodeR, nodeC));
					System.out.println("현재 " +cur.r +" "+cur.c);
					System.out.println("이동할 " +nodeR +" "+nodeC);
					write();
				}
				
			}
		}
	}
	
	public static boolean check() {
		String check = "";
		
		for(int r=0 ; r<3 ; r++) {
			for(int c=0 ; c<3 ; c++) {
				check = check + matrix[r][c];
			}
		}
		
		return true;
	}
	
	public static boolean checkFail() {
		int number = 0;
		for(int r=0 ; r<3 ; r++) {
			for(int c=0 ; c<3 ; c++) {
				if(r==2 && c==2)
					break;
				if(matrix[r][c] != ++number)
					return false;
			}
		}
		return true;
	}
	
	public static void write() {
 		for(int i=0 ; i<3 ; i++) {
 			for(int j=0 ; j<3 ; j++) {
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
