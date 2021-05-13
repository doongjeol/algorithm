package baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_10026_ColorWeakness {
	static int num, count;
	static int dir[][] = {{1,0},{0,1},{-1,0},{0,-1}};
	static char matrix[][];
	static boolean visited[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num = Integer.parseInt(br.readLine());
		matrix = new char[num][num];
		visited = new boolean[num][num];
		
		for(int i=0 ; i<num ; i++) {
			String temp = br.readLine();
			for(int j=0 ; j<num ; j++) 
				matrix[i][j] = temp.charAt(j);
		}
		
		for(int i=0 ; i<num ; i++) {
			for(int j=0 ; j<num ; j++) {
				if(matrix[i][j] == 'R' && !visited[i][j]) {
					dfs(i,j,'R');
					count++;
				} else if(matrix[i][j] == 'G' && !visited[i][j]) {
					dfs(i,j,'G');
					count++;
				} else if(matrix[i][j] == 'B' && !visited[i][j]) {
					dfs(i,j,'B');
					count++;
				}
			}
		}
		
		System.out.print(count+" ");
		visited = new boolean[num][num];
		count = 0;
		for(int i=0 ; i<num ; i++) {
			for(int j=0 ; j<num ; j++) {
				if((matrix[i][j] == 'R' || matrix[i][j] == 'G') && !visited[i][j]) {
					dfs(i,j,'A');
					count++;
				} else if(matrix[i][j] == 'B' && !visited[i][j]) {
					dfs(i,j,'B');
					count++;
				}
			}
		}
		System.out.print(count);
	}
	
	public static void dfs(int indexR, int indexC, char c) {
		visited[indexR][indexC] = true;
		
		for(int i=0 ; i<4 ; i++) {
			int nodeR = indexR + dir[i][0];
			int nodeC = indexC + dir[i][1];
			
			if(nodeR<0 || nodeR>=num || nodeC<0 || nodeC>=num) continue;
			else if(matrix[nodeR][nodeC] == c && !visited[nodeR][nodeC])
				dfs(nodeR,nodeC,c);
			else if((matrix[nodeR][nodeC] == 'R' || matrix[nodeR][nodeC] == 'G') && !visited[nodeR][nodeC] && c=='A')
				dfs(nodeR,nodeC,'A');
				
		}
	}
}
