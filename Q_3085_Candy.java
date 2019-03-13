package backjoon;

import java.util.Scanner;

public class Q_3085_Candy {
	public static int n;
	public static int result;
	
	public static void main(String[] args) {
		// 받는거
		Scanner sc = new Scanner(System.in);
		// 크기 입력 받음
		n = sc.nextInt();
		char[][] candy = new char[n][n];
		String candyString = "";
		
		
		sc.nextLine();
		// 캔디를 입력 받아서 배열로 저장
		for(int i=0 ; i<n ; i++) {
			candyString = sc.nextLine();
			for(int j=0 ; j<n ; j++)
				candy[i][j] = candyString.charAt(j);
		}
		
		// 캔디를 확인
		for(int i=0; i<n ; i++) {
			for(int j=0; j<n ; j++)
				swap(candy,i,j);
		}		
		System.out.println(result);		
	}
	
	public static void swap(char[][] candy, int x, int y) {
		char temp = candy[x][y];
		if(y<n-1) {
			// 가로 바꿔보기
			candy[x][y] = candy[x][y+1];
			candy[x][y+1] = temp;
			// 가로 바꾼걸로 확인해 보기
			getCount(candy);
			// 가로 다시 되돌려주기
			candy[x][y+1] = candy[x][y];
			candy[x][y] = temp;
		}
		
		if(x<n-1) {
			// 세로 바꿔보기
			temp = candy[x][y];
			candy[x][y] = candy[x+1][y];
			candy[x+1][y] = temp;
			// 세로 바꾼걸로 확인해 보기
			getCount(candy);
			// 세로 다시 되돌려주기
			candy[x+1][y] = candy[x][y];
			candy[x][y] = temp;
		}
	}
	
	public static void getCount(char[][] candy) {
		int count = 1;
		
		// 가로 탐색
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
		
		// 세로 탐색
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
//		// 각 사탕의 행 갯수
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
//		// 각 사탕의 열 갯수
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
