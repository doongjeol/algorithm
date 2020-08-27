package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_11726_2xnTileing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] a = new int[1001];

        a[0] = 1;
        a[1] = 1;

        for(int i=2 ; i<=num ; i++){
            // a[n-2]의 사각형 오른쪽에 누워진 직사각형 2개가 붙음
            // a[n-1]의 사각형 오른쪽에 세워진 직사각형 1개가 붙음
            a[i] = a[i - 2] + a[i - 1];
            a[i] %= 10007; // 왜 최종 값에다 해주지 않고 반복분안에서 해줘야하는거지..?
        }
        System.out.println(a[num]);

    }
}
