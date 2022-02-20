package baekjoon.mathmatics;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q_10819_MaxDiff {
    public static int[] data;
    public static void combination(int[] arr, int n, int r, int cnt, int idx) {
        if (cnt == r) {
            int sum = 0;
            int temp = 0;
            for(int i= 0 ; i<arr.length ; i++){
                if(i%2 != 0){
                    temp = arr[i];
                } else {
                    temp -= arr[i];
                    if(temp < 0){
                        temp *= -1;
                    }
                    sum += temp;
                    temp = 0;
                }
            }
            System.out.println(Arrays.toString(arr));
            return;
        }

        for (int i = idx; i < n; i++) {
            arr[cnt] = data[i];
            combination(arr, n, r, cnt + 1, i + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        combination(new int[n], n, 2, 0, 0);

        br.close();
        bw.close();
    }
}
