package baekjoon;

import java.util.Scanner;

public class Q_10448_EurekaTheory {
	
	public static int[] T = new int[45];
	public static boolean isThree = false;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] num = new int[N]; 
		
		for(int i=2; i<T.length ; i++) {
			T[i-2] = i*(i-1)/2;
		}
		
		for(int i=0; i<num.length ; i++) {
			num[i] = sc.nextInt();
		}
		
		for(int i=0; i<num.length; i++) {
			isThree(num[i]);
		}
		
	}
	
	public static void isThree(int num) {
		isThree = false;
		for(int i=0; i<T.length; i++) {
			for(int j=0; j<T.length ; j++) {
				for(int k=0; k<T.length ; k++) {
					if(T[i]+T[j]+T[k] == num && T[i] != 0 && T[j] != 0 && T[k] != 0) {
						isThree = true;
						break;
					} 
				}
			}
		}
		
		if(isThree) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
		
	}
}
