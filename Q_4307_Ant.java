package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_4307_Ant {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		
		for(int i=0 ; i<test ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int length = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			int[] ant = new int[num];
			int min = 0;
			int max = 0;
			for(int j=0 ; j<num ; j++) {
				ant[j] = Integer.parseInt(br.readLine());
				min = Math.max(min, Math.min(length-ant[j],ant[j]));
				max = Math.max(max, Math.max(length-ant[j],ant[j]));
			}
			System.out.println(min +" "+max);
		}
	}
}
