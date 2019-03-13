package backjoon;

import java.util.Scanner;

public class Q_11403_FindingRoute {
	
	public static int N = 0;
	public static int row = 0;
	public static int[][] matrix;
	public static int[][] result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		matrix = new int[N][N];
		result = new int[N][N];
		
		for(int i=0; i<N ; i++) {
			for(int j=0; j<N ; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0; i<N ; i++) {
			row = i;
			for(int j=0; j<N ; j++) {
				if(matrix[i][j] == 1) {
					find(j);
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
	
	public static void find(int col) {
		for(int i=0 ; i<N ; i++) {
			if(matrix[col][i]==1) {
				matrix[row][i] = 1;
			}
		}
	}
}
