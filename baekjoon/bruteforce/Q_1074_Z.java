package baekjoon.bruteforce;
import java.io.*;
import java.util.StringTokenizer;

public class Q_1074_Z {
    public static int count = 0;
    public static void solution(int r, int c, int n, int cnt){
        if(n == 1){
            count = cnt;
            return;
        }

        int half = n/2;
        int row = r / half;
        int col = c / half;
        int rowLeft = r % half;
        int colLeft = c % half;

        if(row == 0 && col == 0){
            // 2사분면
            solution(rowLeft,colLeft,half,cnt);
        } else if(row == 0 && col == 1){
            // 1사분면
            cnt += half * half;
            solution(rowLeft,colLeft,half,cnt);
        } else if(row == 1 && col == 0){
            // 3사분면
            cnt += half * half * 2;
            solution(rowLeft,colLeft,half,cnt);
        } else if(row == 1 && col == 1){
            // 4사분면
            cnt += half * half * 3;
            solution(rowLeft,colLeft,half,cnt);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int N = (int) Math.pow(2,n);
        solution(r, c, N, 0);
        bw.write( count+ "");


        br.close();
        bw.close();
    }
}
