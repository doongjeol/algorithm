package mathmatics;

import java.io.*;
import java.util.StringTokenizer;

public class Q_1979_Multiple {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 어떤 숫자에 n을 곱했는데 n-극적인 숫자가 되는 수 중 마지막 숫자가 k이며 가장 작은 것을 출력
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for(int i=1 ; i<238609294 ; i++) {
            int m = i * n;
            StringBuilder sb = new StringBuilder(String.valueOf(i));
            String iStr_minus = sb.charAt(sb.length()-1)+sb.substring(0, sb.length()-1);
            String iStr = String.valueOf(i);
            String mStr = String.valueOf(m);

            if(iStr_minus.equals(mStr) && (iStr.charAt(iStr.length()-1)-'0') == k) {
                bw.write(i + "\n");
                break;
            }
        }

        br.close();
        bw.close();
    }
}
