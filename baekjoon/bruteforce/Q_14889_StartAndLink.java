package baekjoon.bruteforce;

import java.io.*;
import java.util.StringTokenizer;

public class Q_14889_StartAndLink {
    public static int[][] data;
    public static int min = 200;
    public static boolean[] checked;

    public static void combination(int[] startTeam, int[] linkTeam, int n, int r, int depth, int idx){
        if(depth == r){
            int index = 0;
            checked = new boolean[n];
            for (int i = 0; i < startTeam.length; i++) {
                for (int j = index; j < n; j++) {
                    if(startTeam[i] == j){
                        checked[j] = true;
                        index = j+1;
                    }
                }
            }

            index = 0;
            for (int i = 0; i < n; i++) {
                for (int j = index; j < linkTeam.length; j++) {
                    if(!checked[i]) {
                        linkTeam[j] = i;
                        index = j + 1;
                        checked[i] = true;
                    }
                }
            }

            int start = 0;
            int link = 0;
            for (int i = 0; i < startTeam.length - 1; i++) {
                int startNum = startTeam[i];
                for (int j = i+1; j < startTeam.length; j++) {
                    if(i == j) continue;
                    int startNum2 = startTeam[j];
                    start += data[startNum][startNum2];
                    start += data[startNum2][startNum];
                }
            }

            for (int i = 0; i < linkTeam.length - 1; i++) {
                int linkNum = linkTeam[i];
                for (int j = i + 1; j < linkTeam.length; j++) {
                    if (i == j) continue;
                    int linkNum2 = linkTeam[j];
                    link += data[linkNum][linkNum2];
                    link += data[linkNum2][linkNum];
                }
            }

            min = Math.min(min, Math.abs(start - link));
            return;
        }

        for (int i = idx; i < n; i++) {
            startTeam[depth] = i;
            combination(startTeam, linkTeam, n, r, depth + 1, i + 1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        data = new int[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combination(new int[n / 2], new int[n / 2], n, n / 2, 0, 0);
        bw.write(min+"");

        br.close();
        bw.close();

    }
}

/* 실수한 점
* index처리하는 데에서 계속 실수, 전체 더하는 것에서 실수*/