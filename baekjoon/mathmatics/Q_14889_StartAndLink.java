package baekjoon.mathmatics;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Q_14889_StartAndLink {
    public static int[][] data;
    public static int min = 200;
    public static void permutation(int[] arr , boolean[] selected, int depth){
        if(depth == selected.length){
            int start = 0;
            int link = 0;
            System.out.println(Arrays.toString(arr));
            for(int i=0 ; i<arr.length/2-1 ; i++){
                start += data[arr[i]][arr[i+1]];
                start += data[arr[i+1]][arr[i]];
            }
            start += data[0][arr.length/2-1];
            start += data[arr.length/2-1][0];


            for(int i=arr.length/2 ; i< arr.length-1; i++){
                link += data[arr[i]][arr[i+1]];
                link += data[arr[i+1]][arr[i]];
            }
            link += data[arr.length/2][arr.length-1];
            link += data[arr.length-1][arr.length/2];

            System.out.println(Math.abs(start-link));
            min = Math.min(min, Math.abs(start - link));

            return;
        }

        for(int i=0 ; i<selected.length ; i++){
            if(selected[i]) continue;

            selected[i] = true;
            arr[depth] = i;
            permutation(arr, selected, depth+1);
            selected[i] = false;
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

        permutation(new int[n], new boolean[n], 0);
        bw.write(min+"");

        br.close();
        bw.close();

    }
}
