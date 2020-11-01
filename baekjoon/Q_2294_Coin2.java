package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_2294_Coin2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // n���� ������ ��ġ
		int k = Integer.parseInt(st.nextToken()); // ��ġ�� ��
		int[] coin = new int[n];
        int[] dp = new int[k+1];
		
		for(int i=0; i<n ; i++) 
			coin[i] = Integer.parseInt(br.readLine());
		
		
		dp[0] = 0;
		// ��ġ�� �ձ��� �ݺ�
		for(int i=1; i<=k; i++)
            dp[i] = 100001;
		
		// ���� ��ȹ��
        for(int i=0; i<n ; i++) {
            for(int j=coin[i]; j<=k; j++) 
               dp[j] = Math.min(dp[j], dp[j-coin[i]]+1);
            
        }
        
        if(dp[k] == 100001)
        	dp[k] = -1;
        System.out.print(dp[k]);
	}
}
