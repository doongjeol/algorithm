package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q_2455_IntelligentTrain {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[] leave = new int[10000];
		int[] ride = new int[10000];
		int[] numPeople = new int[4];
		
		// �Է�
		for(int i=0 ; i<4 ; i++) {
			st = new StringTokenizer(br.readLine());
			leave[i] = Integer.parseInt(st.nextToken());
			ride[i] = Integer.parseInt(st.nextToken());
		}
		
		numPeople[0] = ride[0];
		for(int i=0; i<3 ; i++) {
			numPeople[i+1] = numPeople[i] - leave[i+1] + ride[i+1];
		}
		
		Arrays.sort(numPeople);
		System.out.println(numPeople[3]);
	}
}
