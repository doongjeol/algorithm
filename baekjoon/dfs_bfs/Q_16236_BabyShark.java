package baekjoon.dfs_bfs;
import java.io.*;
import java.util.*;

public class Q_16236_BabyShark {
    public static int[][] map, time;
    public static boolean[][] visited;
    public static int n, curSize, eaten, answer;
    public static Pair shark;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    public static ArrayList<Pair> feedList = new ArrayList<>();
    public static void bfs(){
        Queue<Pair> q = new LinkedList<>();
        q.add(shark);
        visited[shark.r][shark.c] = true;

        while (!q.isEmpty()) {
            Pair cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextR = cur.r + dx[i];
                int nextC = cur.c + dy[i];

                if(nextR < 0 || nextC < 0 || nextR >= n || nextC >= n || visited[nextR][nextC]) continue;
                if(cur.time < map[nextR][nextC]) continue;

                // <식사 가능> 사이즈가 더 크고 비어있지 않을 때 먹이 리스트에 추가
                if(cur.time > map[nextR][nextC] && map[nextR][nextC] != 0) {
                    q.add(new Pair(nextR, nextC, cur.time +1));
                    visited[nextR][nextC] = true;
                    feedList.add(new Pair(nextR, nextC, cur.time + 1));
                }

                // <이동만 가능> 사이즈랑 동일하거나 비어있을 때
                if(cur.time == map[nextR][nextC] || map[nextR][nextC] == 0){
                    time[nextR][nextC] = time[cur.r][cur.c] + 1;
                    q.add(new Pair(nextR, nextC, cur.time));
                    if(isEnd(cur.time)) return;
                }
            }
        }

        if(!feedList.isEmpty()){
            eat();
            q.clear();
            visited = new boolean[n][n];
            q.add(shark);
            visited[shark.r][shark.c] = true;

        } else {
            return;
        }
    }

    public static void eat(){
        // 정렬을 통해 우선순위별로 먹이 리스트 재정렬
        Collections.sort(feedList, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if(o1.time == o2.time){
                    if(o1.r == o2.r){
                        if(o1.c > o2.c){
                            return 1;
                        } else {
                            return -1;
                        }
                    } else {
                        if(o1.r > o2.r){
                            return 1;
                        } else {
                            return -1;
                        }
                    }
                } else if(o1.time > o2.time){
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        Pair now = feedList.get(0);

        // 상어 위치 이동
        shark.r = now.r;
        shark.c = now.c;

        // 상어가 먹은 횟수 증가
        if(++eaten == curSize){
            curSize ++;
            eaten = 0;
        }

        // 시간 증가
        answer += now.time;

        // 물고기를 먹었으므로 0으로 변경
        map[now.r][now.c] = 0;

        // 먹이 리스트 초기화
        feedList.clear();

    }
    public static boolean isEnd(int curSize){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(curSize < map[i][j]) return false;
            }
        }

        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        time = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9){
                    shark = new Pair(i, j, 0);
                    map[i][j] = 0;
                }
            }
        }
        bfs();
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result = Math.max(result, time[i][j]);
            }
        }

        bw.write(result +"");

        br.close();
        bw.close();
    }
    public static class Pair{
        int r;
        int c;
        int time;

        Pair(int r, int c, int time){
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }
}
