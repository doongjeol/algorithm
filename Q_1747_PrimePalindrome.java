package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q_1747_PrimePalindrome {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List list = new ArrayList<Integer>();
		
		// N보다 소수가 클 수 있으므로 max를 두배크기로 설정
		int max = 2000002;
		boolean[] prime = new boolean[max];
		prime[0] = prime[1] = true;
		
		// 소수 구하기 - 에라토스테네스의 체 기법
		for(int i=0 ; i*i<max ; i++) {
			if(!prime[i]) {
				for(int j=i*2 ; j<max ; j+=i) {
					prime[j] = true;
				}
			}
		}
		
		// N보다 큰 소수중에서 거꾸로해도 똑같은 경우 구하기
		for(int i=N ; i<max ; i++) {
			if(!prime[i]) {
				String temp = String.valueOf(i);
				int equalCount = 0;
				for(int j=0 ; j<temp.length()/2+1 ; j++) {
					if(temp.charAt(j) == temp.charAt(temp.length()-1-j)) 
						equalCount ++;
				}
				
				if(equalCount == temp.length()/2+1)
					list.add(i);
			} 
		}
		
		System.out.println(list.get(0));
		
	}
}
