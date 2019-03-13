package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_1652_FindLyingSpace {
	
	static int N;
	static char[][] matrix;
	static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
	static boolean[][] visited;
	static boolean[][] visitedRC;
	static int[] count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		matrix = new char[N][N];
		visited = new boolean[N][N];
		visitedRC = new boolean[2][N];
		count = new int[2];
		
		for(int i=0 ; i<N ; i++) {
			String st = br.readLine();
			for(int j=0 ; j<N ; j++) {
				matrix[i][j] = st.charAt(j);
			}
		}
		
		for(int i=0 ; i<N ; i++) 
			dfsRow(i,0);
		
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++)
				visited[i][j] = false;
		}
		
		for(int i=0 ; i<N ; i++) 
			dfsCol(0,i);
		
		
		System.out.print(count[0] +" " +count[1]);
		
	}
	
	public static void dfsRow(int x, int y) {
		visited[x][y] = true;
		for(int i=0 ; i<4 ; i++) {
			int nodeY = y + dir[i][1];
			if(nodeY<0 || nodeY>=N) continue;
			if(matrix[x][nodeY] == '.' && !visited[x][nodeY]) {
				if(!visitedRC[0][x] && matrix[x][nodeY-1] != 'X') {
					count[0] ++;
					visitedRC[0][x] = true;
				}
				dfsRow(x,nodeY);
			} else if(matrix[x][nodeY] == 'X' && !visited[x][nodeY]) {
				visitedRC[0][x] = false;
				dfsRow(x,nodeY);
			}
		}
		
	}
	
	public static void dfsCol(int x, int y) {
		visited[x][y] = true;
		
		for(int i=0 ; i<4 ; i++) {
			int nodeX = x + dir[i][0];
			if(nodeX<0 || nodeX>=N) continue;
			if(matrix[nodeX][y] == '.' && !visited[nodeX][y]) {
				if(!visitedRC[1][y] && matrix[nodeX-1][y] != 'X') {
					count[1] ++;
					visitedRC[1][y] = true;
				}
				dfsCol(nodeX,y);
			} else if(matrix[nodeX][y] == 'X' && !visited[nodeX][y]) {
				visitedRC[1][y] = false;
				dfsCol(nodeX,y);
			}
		}
	}
	
}
