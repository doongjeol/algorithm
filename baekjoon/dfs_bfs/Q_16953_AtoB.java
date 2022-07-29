package baekjoon.dfs_bfs;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_16953_AtoB {
    public static long a, b;
    public static int count;

    public static int bfs(){
        Queue<Long> q = new LinkedList();
        q.add(a);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                long temp = q.poll();
                if (temp == b) {
                    return count +1;
                }
                if (temp * 2 <= b) {
                    q.add(temp * 2);
                }
                if (temp * 10 + 1 <= b) {
                    q.add(temp * 10 + 1);
                }
            }
            count += 1;
        }
        return  -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());

        bw.write(bfs()+"");

        br.close();
        bw.close();
    }
}
