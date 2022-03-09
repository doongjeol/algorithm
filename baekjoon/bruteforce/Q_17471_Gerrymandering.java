package baekjoon.bruteforce;
import java.io.*;
import java.util.StringTokenizer;

public class Q_17471_Gerrymandering {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] population = new int[n+1];
        int[][] section = new int[n+1][n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < population.length; i++) {
            population[i] =Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            System.out.println(i);
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                int[] temp = new int[num];
                for (int k = 0; k < num; k++) {
                    temp[k] = Integer.parseInt(st.nextToken());
                }
                for (int k = 0; k < num; k++) {
                    int r = temp[k];
                    for (int l = 0; l < num; l++) {
                        if(k == l) continue;
                        int c = temp[l];
                        section[r][c] = 1;
                        section[c][r] = 1;
                    }
                }
            }
        }

        // 입력 출력해보기
        for (int i = 0; i < section.length; i++) {
            for (int j = 0; j < section[0].length; j++) {
                System.out.print(section[i][j]+" ");
            }
            System.out.println();
        }

        br.close();
        bw.close();
    }
}
