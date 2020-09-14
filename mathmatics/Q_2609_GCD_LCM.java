package etc;

import java.io.*;
import java.util.StringTokenizer;

public class Q_2609_GCD_LCM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int max = Math.max(a, b);
        int min = Math.min(a, b);

        bw.write(getGCD(max, min)+"\n");
        // 최소공배수 : a*b 나누기 최대공약수
        bw.write(a*b/getGCD(max, min)+"\n");

        br.close();
        bw.close();

    }

    /*
    1) 입력받은 두 수중 큰 수를 A, 작은 수를 B로 정한다.
    2) A를 B로 나눈값의 나머지를 R로 지칭한다. (R = A%B)
       e.g. A = 24, B = 18 이면 R = 6
       3 | 24 18
           ㅡㅡㅡ
       2 | 8 6
           ㅡㅡ
           4 3
    3) R이 0이라면 A는 B로 나누어지기때문에 최대 공약수는 B가 된다.
    4) 만약 R이 0이 아니라면 A값은 B로. B값은 R로 변경한 뒤 3번 과정을 반복한다.
       e.g. 18 % 6 = 0 => 최대공약수 6
     */
    public static int getGCD(int a, int b) {
        while(b>0){
            int temp = a;
            a = b;
            b = temp%b;
        }

        return a;
    }
}
