package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q_1449_RepairmanHangseung {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // ???? ???? ???? ????
		int l = Integer.parseInt(st.nextToken()); // ???????? ????
		
		st = new StringTokenizer(br.readLine());
		List<Integer> list = new ArrayList<>();
		for(int i=0 ; i<n ; i++)
			list.add(Integer.parseInt(st.nextToken()));
		boolean[] check = new boolean[list.size()];
		int result = 0;
		for(int i=0 ; i<n-1 ; i++) {
			if(list.get(i+1)-list.get(i) + 1<=l && !check[i] && !check[i+1] ) {
				result ++;
				check[i] = check[i+1] = true;
			} else if(!check[i])
				result ++;
		}
		
		System.out.println(result);
	}
}
