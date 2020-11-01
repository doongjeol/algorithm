package baekjoon;

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
		
		// N���� �Ҽ��� Ŭ �� �����Ƿ� max�� �ι�ũ��� ����
		int max = 2000002;
		boolean[] prime = new boolean[max];
		prime[0] = prime[1] = true;
		
		// �Ҽ� ���ϱ� - �����佺�׳׽��� ü ���
		for(int i=0 ; i*i<max ; i++) {
			if(!prime[i]) {
				for(int j=i*2 ; j<max ; j+=i) {
					prime[j] = true;
				}
			}
		}
		
		// N���� ū �Ҽ��߿��� �Ųٷ��ص� �Ȱ��� ��� ���ϱ�
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
