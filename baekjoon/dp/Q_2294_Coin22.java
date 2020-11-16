package baekjoon.dp;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

//2020년 11월 16일 혼자힘으로 풀어보기
public class Q_2294_Coin22 {
    public static int solution(int[] coin, int k){
        int[] a = new int[k + 1];
        
        for(int i=1; i<=k; i++)
            a[i] = 100001;

        a[0] = 0;
        for (int i = 0; i < coin.length; i++) {
            for(int j=coin[i] ; j<k ; j++)
            a[j] = Math.min(a[j], a[j - coin[i]] + 1);
        }

        if(coin[k] == 10001)
            coin[k] = -1;

        return coin[k];
    }
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coin = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            coin[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(solution(coin,k));

        br.close();
        bw.close();
    }
}
