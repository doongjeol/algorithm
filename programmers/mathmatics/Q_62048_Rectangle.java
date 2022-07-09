package programmers.mathmatics;
import java.io.*;

/* 사용 가능한 직사각형 수 = 전체 직사각형 수 = (패턴에서 제외되는 직사각형 수 * 최대 공약수*/
public class Q_62048_Rectangle {
    public static long solution(int w, int h) {
        long answer = 1;
        long ref = gcd(w, h);
        answer = ((long) w * h) - (((w / ref) + (h / ref) - 1) * ref);
        return answer;
    }

    // 최대 공약수 구하기
    public static int gcd(int n, int m) {
        while (m != 0) {
            int r = n % m;

            n = m;
            m = r;
        }

        return n;
    }
    public static void main(String[] args) throws IOException {
        int w = 8;
        int h = 12;

        System.out.println(solution(w, h));
    }
}
