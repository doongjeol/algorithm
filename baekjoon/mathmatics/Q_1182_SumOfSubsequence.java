package baekjoon.mathmatics;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q_1182_SumOfSubsequence {
    public static int count;
    public static List<Integer> data = new ArrayList<>();
    public static int n, s;
    public static void subSet(List<Integer> list ,int idx) {
        if (idx == n) {
            int sum = 0;
            for(int i=0 ; i<list.size() ; i++){
                sum += list.get(i);

            }
            if(!list.isEmpty()){
                if(sum == s) {
                    count++;
                }
            }
            return;
        }

        list.add(data.get(idx));
        subSet(list, idx + 1);
        list.remove(list.size() - 1);
        subSet(list, idx + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            data.add(Integer.parseInt(st.nextToken()));
        }

        subSet(new ArrayList<>(),0);
        bw.write(count+"");

        br.close();
        bw.close();
    }
}
