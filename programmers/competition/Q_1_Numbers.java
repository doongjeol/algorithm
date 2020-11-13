package programmers.competition;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Q_1_Numbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = solution(a);

        for (int i = 0; i < result.length; i++) {
            bw.write(result[i]+" ");
        }

        br.close();
        bw.close();
    }

    public static int[] solution(int[] numbers) {
        List<Integer> list = new ArrayList<>();
        int result = 0;
        for (int i = 0; i < numbers.length-1; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                result = numbers[i] + numbers[j];
                if(!list.contains(result)) {
                    list.add(result);
                }
            }
        }

        Collections.sort(list);
        int[] answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
