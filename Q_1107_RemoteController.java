package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_1107_RemoteController {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String goalStr = br.readLine();
		int errorNum = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		char[] error = new char[errorNum];
		char[] goal = new char[goalStr.length()];

		int result = 0;
		for(int i=0 ; i<goalStr.length() ; i++) {
			goal[i] = goalStr.charAt(i);
		}
		
		for(int i=0 ; i<errorNum ; i++) {
			error[i] = st.nextToken().charAt(0);
		}
		
		for(int i=0 ; i<goalStr.length() ; i++) {
			for(int j=0 ; j<goalStr.length() ; j++) {
//				if(goal[i] == error[j])
					
			}
		}
		
		
	}
}
