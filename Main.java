package backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		String result = "666";
		String numStr = String.valueOf(m-1); 
		
		int count = 0;
		for(int i=numStr.length()-1 ; i>=0 ; i--) {
			if(numStr.charAt(i) == '6')
				count++;
			else break;
		}
		
		if(numStr.length()>3) {
			if(numStr.charAt(0) == '6' && numStr.charAt(1) == '6' && numStr.charAt(2) == '6')
				count = 3;
		}
		
		switch(count) {
		case 0 :
			if((m-1) == 0) result = "666";
			else
				result = String.valueOf(m-1) + "666";
			break;
		case 1 :
			result = String.valueOf(m-1) + "660";
			break;
		case 2 :
			result = String.valueOf(m-1) + "600";
			break;
		default :
			result = String.valueOf(m-1) + "000";
		}
		
		System.out.println(Integer.parseInt(result));
		
	}
}
