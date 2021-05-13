package baekjoon.dfs_bfs;

import java.util.Scanner;

public class Q_11403_FindingRoute_JY {
	
	public static int N = 0;
	public static int[][] matrix;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		matrix = new int[N][N];
		
		for(int i=0; i<N ; i++) {
			for(int j=0; j<N ; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0; i<N ; i++) {
			for(int j=0; j<N ; j++) {
				for(int k=0;k<N;k++) {
					if(matrix[j][i] == 1 && matrix[i][k] == 1) {
						matrix[j][k]=1;
					}
				}
			}
		}
		
		for(int i=0; i<N ; i++) {
			for(int j=0; j<N ; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
}
