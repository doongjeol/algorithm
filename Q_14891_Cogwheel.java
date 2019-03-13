package backjoon;

import java.util.Scanner;

public class Q_14891_Cogwheel {
	static int[][] wheel = new int[4][8];
	static int K, result ;
	static int [] wheelNumber, wheelDirection;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String temp = "";
		
		for(int i=0 ; i<4 ; i++) {
			temp = sc.nextLine();
			for(int j=0 ; j<4 ; j++) 
				wheel[i][j] = temp.charAt(j)-'0';
		}
		
		K = sc.nextInt();// È¸ÀüÈ½¼ö
		wheelNumber = new int[K];
		wheelDirection = new int[K];
		sc.nextLine();
		
		for(int i=0 ; i<K ; i++) {
			temp = sc.nextLine();
			wheelNumber[i] = temp.charAt(0) - 48;
			if(temp.charAt(2) == 45)
				wheelDirection[i] = temp.charAt(2) - 46;
			else
				wheelDirection[i] = temp.charAt(2) - 48;
		}
		
	}
	
	public static void check() {
		for(int i=0 ; i<K ; i++) {
			switch(wheelNumber[i]) {
			case 1:
				if(wheelDirection[i] == 1)
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			}
			}
		}
	
	public static void score() {
		if(wheel[0][0] == 1)
			result++;
		else if(wheel[1][0] == 1)
			result += 2;
		else if(wheel[2][0] == 1)
			result += 4;
		else if(wheel[3][0] == 1)
			result += 8;
	}
}
