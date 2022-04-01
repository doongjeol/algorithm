package baekjoon.bruteforce;
import java.io.*;
import java.util.StringTokenizer;

public class Q_2529_Inequality {
    public static int num;
    public static char[] inequality;
    public static Long max = Long.MIN_VALUE;
    public static Long min = Long.MAX_VALUE;
    public static String maxStr = "";
    public static String minStr = "";
    public static void permutation(int[] arr, int depth, boolean[] checked){
        if (depth == num + 1) {
            String result = "";
            for (int i = 0; i < arr.length; i++) {
                result += String.valueOf(arr[i]);
            }
            Long resultNum = Long.parseLong(result);
            if(max < resultNum){
                maxStr = result;
            }
            if(min > resultNum){
                minStr = result;
            }
            max = Math.max(max, resultNum);
            min = Math.min(min, resultNum);

            return;
        }

        for (int i = 0; i < 10; i++) {
            if(checked[i]) continue;
            checked[i] = true;
            arr[depth] = i;
            if(depth > 0){
                if(inequality[depth-1] == '>'){
                    if(arr[depth-1] > arr[depth]) {
                        permutation(arr, depth + 1, checked);
                    }
                } else if (inequality[depth - 1] == '<') {
                    if(arr[depth-1] < arr[depth]) {
                        permutation(arr, depth + 1, checked);
                    }
                }
            } else {
                permutation(arr, depth + 1, checked);
            }
            checked[i] = false;

        }
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        inequality = new char[num];

        for (int i = 0; i < num; i++) {
            inequality[i] = st.nextToken().charAt(0);
        }

        permutation(new int[num + 1], 0, new boolean[10]);
        bw.write(maxStr + "\n");
        bw.write(minStr+"");

        br.close();
        bw.close();
    }
}
