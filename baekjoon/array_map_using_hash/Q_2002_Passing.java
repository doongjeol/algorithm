package baekjoon.array_map_using_hash;
import java.io.*;
import java.util.HashMap;

/* input의 시작부터 끝까지 자기 자신을 만날 때까지 true로 처리하고 추월한 수에 더한다.
* */
public class Q_2002_Passing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] in = new String[n];
        String[] out = new String[n];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            in[i] = input;
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            String output = br.readLine();
            out[i] = output;
        }

        boolean[] checked = new boolean[n];
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n; j++) {
                if (in[i].equals(out[j])) {
                    checked[j] = true;
                    break;
                }
                if(checked[j]) continue;
                count += 1;
                checked[j] = true;
            }
        }
        bw.write(count +"");

        br.close();
        bw.close();
    }
}
