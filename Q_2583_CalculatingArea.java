package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Q_2583_CalculatingArea {
	static int n, m, countAll, count;
	static int[][] matrix;
	static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
	static boolean[][] visited;
	static List<Integer> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		matrix = new int[n][m];
		visited = new boolean[n][m];
		list = new ArrayList<Integer>();
		
		for(int i=0 ; i<k ; i++) {
			st = new StringTokenizer(br.readLine());
			int c1 = Integer.parseInt(st.nextToken());
			int r1 = n-1 - Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken()) - 1;
			int r2 = n-Integer.parseInt(st.nextToken());
			
//			System.out.println(r1+" "+c1+" "+r2+" "+c2);
			
			for(int r=r1 ; r>=r2 ; r--) {
				for(int c=c1 ; c<=c2 ; c++) {
					matrix[r][c] = 1;
				}
			}
		}
		
		for(int r=0 ; r<n ; r++) {
			for(int c=0 ; c<m ; c++) {
				if(matrix[r][c] == 0 && !visited[r][c]) {
					dfs(r,c);
					list.add(count);
					countAll++;
					count = 0;
				}
			}
		}
		
		Collections.sort(list);
		System.out.println(countAll);
		for(int i=0 ; i<list.size() ; i++) {
			System.out.println(list.get(i));
		}
		
	}
	
	public static void dfs(int indexR, int indexC) {
		visited[indexR][indexC] = true;
		count++;
		
		for(int i=0 ; i<4 ; i++) {
			int nodeR = indexR + dir[i][0];
			int nodeC = indexC + dir[i][1];
			
			if(nodeR<0 || nodeR>=n || nodeC<0 || nodeC>=m) continue;
			else if(matrix[nodeR][nodeC] == 0 && !visited[nodeR][nodeC]) 
				dfs(nodeR,nodeC);
		}
		
	}
	
	public static void write() {
 		for(int i=0 ; i<n ; i++) {
 			for(int j=0 ; j<m ; j++) {
 				System.out.print(matrix[i][j]+" ");
 			}
 			System.out.println();
 		}
 		System.out.println();
 	}
}
