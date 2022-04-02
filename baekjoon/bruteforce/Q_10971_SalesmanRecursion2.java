package baekjoon.bruteforce;
import java.io.*;
import java.util.StringTokenizer;

public class Q_10971_SalesmanRecursion2 {
    public static int n;
    public static int[][] map;
    public static int min = Integer.MAX_VALUE;
    public static void permutationUp(int[] arrUp, int depth, boolean[] checkedUp, boolean[][] checked){
        if(depth == n){
            int sum = 0;
            for (int i = 0; i < arrUp.length-1; i++) {
                int from = arrUp[i];
                int to = arrUp[i + 1];

                if(map[from][to] == 0) return;
                checked[from][to] = true;
                sum += map[from][to];
            }
            int statIndex = arrUp[0];
            int lastIndex = arrUp[arrUp.length - 1];

            if(map[lastIndex][statIndex] == 0 || checked[lastIndex][statIndex]) return;

            sum += map[lastIndex][statIndex];
            min = Math.min(sum, min);

            return;
        }

        for (int i = 0; i < n; i++) {
            if (checkedUp[i]) continue;
            checkedUp[i] = true;
            arrUp[depth] = i;
            permutationUp(arrUp,depth + 1, checkedUp, checked);
            checkedUp[i] = false;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        permutationUp(new int[n], 0, new boolean[n], new boolean[n][n]);
        bw.write(min+"");

        br.close();
        bw.close();
    }
}
