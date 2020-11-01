package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_11403_FindingRouteDFS {
	
	static int N, firstIndex;
	static int[][] matrix, result;
	static int[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		matrix = new int[N][N];
		result = new int[N][N];
		// �Է�(������� �����)
		for(int i=0 ; i<N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0 ; j<N ; j++) 
				matrix[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0 ; i<N ; i++) {
			visited = new int[N];		
			dfs(i);
			result[i] = visited;
		}
		
		write();
	}
	
	public static void dfs(int index) {
		
		for(int i=0 ; i<N ; i++) {
			if(matrix[index][i] == 1 && visited[i] == 0) {
				visited[i] = 1;
				dfs(i);
			}
		}
	}
	
	public static void write() {
		for(int i=0 ; i<N; i++) {
			for(int j=0 ; j<N ; j++) {
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}
 	}
}




//package backjoon;
//
//import java.baekjoon.io.BufferedReader;
//import java.baekjoon.io.IOException;
//import java.baekjoon.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Q_11403_FindingRouteDFS {
//	
//	static int N, firstIndex;
//	static int[][] matrix, result;
//	static int[] visitedRow;
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		N = Integer.parseInt(br.readLine());
//		matrix = new int[N][N];
//		result = new int[N][N];
//		
//		// �Է�(������� �����)
//		for(int i=0 ; i<N ; i++) {
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			for(int j=0 ; j<N ; j++) 
//				matrix[i][j] = Integer.parseInt(st.nextToken());
//		}
//		
//		
//		for(int i=0 ; i<N ; i++) {
//			visitedRow = new int[N];
//			dfs(i);
//			result[i] = visitedRow;
//			break;
//		}
//		
//		for(int i=0 ; i<N ; i++) {
//			for(int j=0 ; j<N ; j++)
//				System.out.print(result[i][j] + " ");
//			System.out.println();
//		}
//	}
//	
//	public static void dfs(int nodeX) {
//		
//		for(int nodeY=0 ; nodeY<N ; nodeY++) {
//			// ��尡 ���� ���ִٸ� �ش� ���� 1��(3 -> 4-> 0 -> // 5 -> 6 // -> 2)
//			if(matrix[nodeX][nodeY] == 1 && visitedRow[nodeY] == 0 ) {
//				visitedRow[nodeY] = 1;
//				dfs(nodeY);
//			}
//		}
//		
//	}
//}
