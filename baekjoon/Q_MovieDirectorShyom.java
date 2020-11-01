package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_MovieDirectorShyom {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int number = Integer.parseInt(br.readLine());
		int result = 0;
		
		while(number > 0) {
			result ++;
			String str = Integer.toString(result);
			
			if(str.contains("666")) {
				System.out.println(result);
				number--;
			}
		}
		
		System.out.println(result);
		
		
	}
}
