package baekjoon.practice;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DfsAndBfs {
    public static int[][] map;
    public static boolean[] visited;

    public static void dfs(int index){
        visited[index] = true;
        System.out.print(index+" ");

        for(int i=0 ; i<visited.length ; i++){
            if(!visited[i] && map[index][i] == 1){
                dfs(i);
            }
        }
    }

    public static void bfs(int index){
        Queue<Integer> q = new LinkedList();
        q.add(index);
        visited[index] = true;
        System.out.print(index + " ");

        int k;
        while(!q.isEmpty()){
            k = q.poll();
            for(int i=1 ; i<visited.length ; i++){
                if(!visited[i] && map[index][i] == 1){
                    q.add(i);
                    visited[i] = true;
                    System.out.print(i+" ");
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        map = new int[n + 1][n + 1];
        for(int i=0 ; i<m ; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[r][c] = 1;
        }

        visited = new boolean[n + 1];
        dfs(v);
        System.out.println();
        visited = new boolean[n + 1];
        bfs(v);


        br.close();
        bw.close();
    }
}
