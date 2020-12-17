package baekjoon.bruteforce;

import java.util.Scanner;

public class Q_3085_Candy {
	public static int n;
	public static int result;
	
	public static void main(String[] args) {
		// �޴°�
		Scanner sc = new Scanner(System.in);
		// ũ�� �Է� ����
		n = sc.nextInt();
		char[][] candy = new char[n][n];
		String candyString = "";
		
		
		sc.nextLine();
		// ĵ�� �Է� �޾Ƽ� �迭�� ����
		for(int i=0 ; i<n ; i++) {
			candyString = sc.nextLine();
			for(int j=0 ; j<n ; j++)
				candy[i][j] = candyString.charAt(j);
		}
		
		// ĵ�� Ȯ��
		for(int i=0; i<n ; i++) {
			for(int j=0; j<n ; j++)
				swap(candy,i,j);
		}		
		System.out.println(result);		
	}
	
	public static void swap(char[][] candy, int x, int y) {
		char temp = candy[x][y];
		if(y<n-1) {
			// ���� �ٲ㺸��
			candy[x][y] = candy[x][y+1];
			candy[x][y+1] = temp;
			// ���� �ٲ۰ɷ� Ȯ���� ����
			getCount(candy);
			// ���� �ٽ� �ǵ����ֱ�
			candy[x][y+1] = candy[x][y];
			candy[x][y] = temp;
		}
		
		if(x<n-1) {
			// ���� �ٲ㺸��
			temp = candy[x][y];
			candy[x][y] = candy[x+1][y];
			candy[x+1][y] = temp;
			// ���� �ٲ۰ɷ� Ȯ���� ����
			getCount(candy);
			// ���� �ٽ� �ǵ����ֱ�
			candy[x+1][y] = candy[x][y];
			candy[x][y] = temp;
		}
	}
	
	public static void getCount(char[][] candy) {
		int count = 1;
		
		// ���� Ž��
		for(int i=0;i<n;i++) {
			count = 1;
			for(int j=0;j<n-1;j++) {
				if(candy[i][j]==candy[i][j+1]) {
					count++;
				}else {
					result = Math.max(result, count);
					count = 1;
				}
			}
			result = Math.max(result, count);
		}
		
		// ���� Ž��
		for(int i=0;i<n;i++) {
			count = 1;
			for(int j=0;j<n-1;j++) {
				if(candy[j][i]==candy[j+1][i]) {
					count++;
				}else {
					result = Math.max(result, count);
					count = 1;
				}
			}
			result = Math.max(result, count);
		}
	}
}


//int[][] numC = new int[2][5];
//int[][] numP = new int[2][5];
//int[][] numZ = new int[2][5];
//int[][] numY = new int[2][5];
//
//for(int i=0; i<n; i++) {
//	for(int j=0 ; j<n ; j++) {
//		// �� ������ �� ����
//		if(candy[i][j]=='C') {
//			numC[0][i]++;
//		} else if(candy[i][j]=='P') {
//			numP[0][i]++;
//		} else if(candy[i][j]=='Z') {
//			numZ[0][i]++;
//		} else if(candy[i][j]=='Y') {
//			numY[0][i]++;
//		}
//		
//		// �� ������ �� ����
//		if(candy[j][i]=='C') {
//			numC[1][i]++;
//		} else if(candy[j][i]=='P') {
//			numP[1][i]++;
//		} else if(candy[j][i]=='Z') {
//			numZ[1][i]++;
//		} else if(candy[j][i]=='Y') {
//			numY[1][i]++;
//		}
//	}
//}
//
//for(int i=0; i<n; i++) {
//	System.out.println("C"+i+": "+numC[0][i]);
//	System.out.println("P"+i+": "+numP[1][i]);
//	System.out.println("Z"+i+": "+numZ[0][i]);
//	System.out.println("Y"+i+": "+numY[0][i]);
//}
