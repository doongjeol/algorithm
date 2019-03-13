package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q_11399_ATM {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] people = new int[num];
		
		for(int i=0 ; i<num ; i++)
			people[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(people);
		int result = people[0];
		for(int i=1 ; i<num ; i++) {
			people[i] += people[i-1];
			result += people[i];
		}
		
		System.out.println(result);
	}
}
