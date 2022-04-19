package baekjoon.bruteforce;
import java.io.*;
import java.util.StringTokenizer;

public class Q_16943_RelocateNumber {
    public static String a,b;
    public static int result = -1;
    public static void permutation(String number, int depth, boolean[] selected){
        if(depth == a.length()){
            int numC = Integer.parseInt(number);
            if(numC <= Math.pow(10,a.length()-1) - 1){
                return;
            }

            int numB = Integer.parseInt(b);

            if(numC < numB){
                result = Math.max(result, numC);
            }
            return;
        }

        for (int i = 0; i < a.length(); i++) {
            if(selected[i]) continue;
            selected[i] = true;
            permutation(number + a.charAt(i), depth + 1, selected);
            selected[i] = false;

        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        a = st.nextToken();
        b = st.nextToken();

        permutation("", 0, new boolean[a.length()]);

        bw.write(result + "");

        br.close();
        bw.close();
    }
}
