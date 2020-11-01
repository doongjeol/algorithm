package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_1652_FindLyingSpaceSimple {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[][] matrix = new char[N][N];
		int[] count = new int[2];
		boolean flag = false;
		
		for(int i=0 ; i<N ; i++) {
			String st = br.readLine();
			for(int j=0 ; j<N ; j++) {
				matrix[i][j] = st.charAt(j);
			}
		}
		
		// ����
		for(int i=0 ; i<N ; i++) {
			flag = false;
			for(int j=0 ; j+1<N ; j++) {
				if(matrix[i][j] == '.' && matrix[i][j+1] == '.' && !flag) { 
					count[0]++;
					flag = true;
				} else if(matrix[i][j] == 'X')
					flag = false;
			}
		}
		// ����
		for(int j=0 ; j<N ; j++) {
			flag = false;
				for(int i=0 ; i+1<N ; i++) {
				if(matrix[i][j] == '.' && matrix[i+1][j] == '.' && !flag) { 
					count[1]++;
					flag = true;
				} else if(matrix[i][j] == 'X')
					flag = false;
			}
		}
		
		System.out.print(count[0] +" " +count[1]);
		
	}
	
}
