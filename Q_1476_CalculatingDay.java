package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_1476_CalculatingDay {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int e = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int resultE = 0;
		int resultS = 0;
		int resultM = 0;
		int year = 0;
		while(true) {
			if(resultE == e && resultS == s && resultM == m)
				break;
			resultE++;
			resultS++;
			resultM++;
			if(resultE>15)
				resultE = resultE/15;
			if(resultS>28)
				resultS = resultS/28;
			if(resultM>19)
				resultM = resultM/19;
			year++;
		}
		System.out.println(year);
	}
}
