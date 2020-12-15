package baekjoon.dp;
import java.io.*;

public class Q_16500_IdentifyString {
    public static int solution(String S, String[] A){
        int[] a = new int[S.length()];

        for(int j=0 ; j<A.length ; j++) {
            String curStr = A[j];
            for(int k=0 ; k<curStr.length() ; k++){
                for(int i=0 ; i<S.length() ; i++){
                    char cur = S.charAt(i);
                    if (cur == A[j].charAt(k)) {
                        a[i] = 1;
                    }
                }

            }
        }


        for (int i = 0; i < a.length; i++) {
            if(a[i] == 0) {
                a[a.length - 1] = 0;
                break;
            }
        }

        return a[a.length-1];

    }
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();
        int n = Integer.parseInt(br.readLine());
        String[] A = new String[n];
        for (int i = 0; i < n; i++) {
            A[i] = br.readLine();
        }


        bw.write(solution(S,A)+"\n");

        br.close();
        bw.close();
    }
}
