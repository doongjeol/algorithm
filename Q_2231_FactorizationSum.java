package backjoon;

import java.util.Scanner;

public class Q_2231_FactorizationSum {
	//전역변수로 선언
	public static int num;
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		int result = 0;
		
		//입력한 num까지 완전 탐색
		for(int i=0; i < num ; i++) {
			if(isEqual(i)) {
				result = i;
				break;
			}
		}
		
		System.out.println(result);
	
	}
	
	public static boolean isEqual(int i) {
		//0~num까지 탐색할 숫자를 String으로 선언하여 각 숫자 분리
		String numString = String.valueOf(i);
		//원래숫자
		int k = i ;
		for(int j=0; j<numString.length(); j++) {
			//원래 숫자 + 각 자리의 숫자의 합
			k += numString.charAt(j)-48;
		}
		
		//최종결과가 num이랑 같은지
		return num == k;
	}
}
