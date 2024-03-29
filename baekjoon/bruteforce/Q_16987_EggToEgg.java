package baekjoon.bruteforce;
import java.io.*;
import java.util.StringTokenizer;

public class Q_16987_EggToEgg {
    public static int n;
    public static int max = Integer.MIN_VALUE;
    public static int[][] egg;
    public static void solution(int[][] arr, int depth, boolean[] isPossible, int result, int idx){
        if(depth == n-1){
            max = Math.max(max, result);
            return;
        }
        for (int i = idx; i < arr.length; i++) {
            if (isPossible[i]) continue;
            if(depth == i) continue;
            arr[depth][0] -= arr[i][1];
            arr[i][0] -= arr[depth][1];
            if (arr[i][0] < 0) {
                isPossible[i] = true;
                result += 1;
            } else if (arr[depth][0] < 0) {
                isPossible[depth] = true;
                result += 1;
            }
            System.out.println(depth + " " + i + " result : " + result);
//            System.out.println("i : "+i);
            max = Math.max(result, max);
            solution(arr, depth + 1, isPossible, result, i + 1);
            isPossible[i] = false;
            isPossible[depth] = false;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        egg = new int[n][2]; // 0 : 내구도, 1 : 무게

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            egg[i][0] = Integer.parseInt(st.nextToken());
            egg[i][1] = Integer.parseInt(st.nextToken());
        }

        solution(egg, 0, new boolean[n], 0,0);
        bw.write(max + "");

        br.close();
        bw.close();
    }
}
