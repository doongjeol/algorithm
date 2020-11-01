package baekjoon;

import java.util.Scanner;

public class Q_2503_NumberBaseball {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] num = new int[N];
		String yeongsu = "324";
		
		int ballCount = 0;
				int strikeCount = 0;
		int result = 0;
		
		for(int i=0; i<N ; i++) {
			ballCount = 0;
			strikeCount = 0;
			num[i] = sc.nextInt();
			for(int j=0; j<3 ; j++) {
								for(int k=0; k<3 ; k++) {
					if(Integer.toString(num[i]).charAt(j) == yeongsu.charAt(k) && Integer.toString(num[i]).charAt(j) != yeongsu.charAt(j)) {
						ballCount++;
					} else if(Integer.toString(num[i]).charAt(j) == yeongsu.charAt(j)) {
						strikeCount++;
						break;
					}
				}
			}
			System.out.print(strikeCount +" ");
			System.out.println(ballCount);
		}
		
		if(strikeCount == 3) {
			result = 1;
		} else if(ballCount == 3) {
			result = 3*2*1;
		} else if(ballCount == 2) {
			result = 6*7;
		} else if(ballCount == 0) {
			 
		}
		
	}
}
