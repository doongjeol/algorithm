package baekjoon;

import java.util.Scanner;

public class Q_2231_FactorizationSum {
	//���������� ����
	public static int num;
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		int result = 0;
		
		//�Է��� num���� ���� Ž��
		for(int i=0; i < num ; i++) {
			if(isEqual(i)) {
				result = i;
				break;
			}
		}
		
		System.out.println(result);
	
	}
	
	public static boolean isEqual(int i) {
		//0~num���� Ž���� ���ڸ� String���� �����Ͽ� �� ���� �и�
		String numString = String.valueOf(i);
		//��������
		int k = i ;
		for(int j=0; j<numString.length(); j++) {
			//���� ���� + �� �ڸ��� ������ ��
			k += numString.charAt(j)-48;
		}
		
		//��������� num�̶� ������
		return num == k;
	}
}
