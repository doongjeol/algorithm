package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q_11047_Coin0 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		List<Integer> list = new ArrayList<>();
		int maxIndex = 0;
		int result = 0;
		for(int i=0 ; i<n ; i++) {
			int num = Integer.parseInt(br.readLine());
			list.add(num);
			if(num <= k)
				maxIndex = i;
		}
		
		for(int i=maxIndex ; i>=0 ; i--) {
			if(k-list.get(i)<0) continue;
			else {
				while(true) {
					k -= list.get(i);
					result ++;
					if(k<list.get(i))
						break;
				}
			}
			if(k == 0)
				break;
		}
		
		System.out.println(result);
		
		
	}
}
