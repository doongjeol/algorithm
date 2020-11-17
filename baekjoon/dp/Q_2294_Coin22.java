package baekjoon.dp;
import java.io.*;
import java.util.StringTokenizer;

//2020년 11월 16일 혼자힘으로 풀어보기
public class Q_2294_Coin22 {
    public static int solution(int[] coin, int k){
        int[] a = new int[k + 1];
        
        for(int i=1; i<=k; i++)
            a[i] = 10001;

        a[0] = 0;
        for (int i = 0; i < coin.length; i++) {
            for(int j=coin[i] ; j<=k ; j++)
            a[j] = Math.min(a[j], a[j - coin[i]] + 1);
        }

        if(a[k] == 10001)
            a[k] = -1;

        return a[k];
    }
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 동전의 가치
        int k = Integer.parseInt(st.nextToken()); // 가치의 합

        int[] coin = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        bw.write(solution(coin,k)+"\n");

        br.close();
        bw.close();
    }
}
