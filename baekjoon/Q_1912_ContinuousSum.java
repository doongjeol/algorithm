package baekjoon;

import java.util.Scanner;

public class Q_1912_ContinuousSum {
	public static void main(String args[])
 	{ 
 		Scanner sc = new Scanner(System.in);
 		int n = sc.nextInt();
 		int[] num = new int[100000];
 		int sum = 0, max = -1001;
 		for(int i=0; i < n ; i++){
 			num[i] = sc.nextInt();
 		}
 		
 		for(int i = 0; i < n; i++) {
 			sum += num[i];
 			max = max > sum ? max : sum;
 			if(sum<0) {
 				sum = 0;
 			}
 		}
 		System.out.println(max);
 	}
}