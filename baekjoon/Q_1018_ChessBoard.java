package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_1018_ChessBoard {
	public static char[][] newMatrix = new char[8][8];
	public static int result = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] matrix = new char[N][M];
		String stringMatrix = "";
		
		// N*M �簢�� �Է�
		for(int i=0; i<N ; i++) {
			stringMatrix = br.readLine();
			for(int j=0; j<M; j++) {
				matrix[i][j] = stringMatrix.charAt(j);
			}
		}
		
		// ���簢������ �ڸ���
		for(int i=0; i<=N-8; i++) {
			for(int j=0; j<=M-8; j++) {
				for(int k=i; k<i+8 ; k++) {
					for(int l=j; l<j+8; l++) {
						newMatrix[k-i][l-j] = matrix[k][l];
					}
				}
				detect(newMatrix);
			}
		}
		
		
//		for(int i=0; i<N ; i++) {
//			for(int j=0; j<M; j++) {
//				System.out.print(matrix[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		System.out.println(result);
	}
	
	public static void detect(char[][] newMatrix) {
		// ��-�� �˻�
		int count = 0;
		result = 0;
		for(int i=0; i<8 ; i++) {
			for(int j=0; j<7; j++) {
				if(newMatrix[i][j] == newMatrix[i][j+1]) {
					if(newMatrix[i][j] == 'W') {
						newMatrix[i][j+1] = 'B';
					} else {
						newMatrix[i][j+1] = 'W';
					}
					count ++;
					result = Math.min(count, result);
				}
			}
		}
		
		// ��-�� �˻�
		for(int i=0; i<7 ; i++) {
			for(int j=0; j<8; j++) {
				if(newMatrix[i][j] == newMatrix[i+1][j]) {
					if(newMatrix[i][j] == 'W') {
						newMatrix[i+1][j] = 'B';
					} else {
						newMatrix[i+1][j] = 'W';
					}
					count ++;
					result = Math.min(count, result);
				}
			}
		}
	}
}
