package baekjoon.bruteforce;
import java.io.*;
import java.util.StringTokenizer;

public class Q_15686_ChickenBaedal {
    public static int[][] map;
    public static int[][] chicken;
    public static int[][] home;
    public static int min = 2147483647;

    public static void combination(int[][] arr, int numHome, int numChicken, int r, int depth, int idx){
        if(depth == r){
            int disX = 0;
            int disY = 0;
            int[] disArr = new int[numHome];

            for (int i = 0; i < numHome; i++) {
                int disMin = 2147483647;
                for(int j = 0 ; j<r ; j++) {
                    disX = Math.abs(home[i][0] - arr[j][0]);
                    disY = Math.abs(home[i][1] - arr[j][1]);
                    disMin = Math.min(disMin, disX+disY);
                }
                disArr[i] = disMin;
            }

            int distance = 0;
            for (int i = 0; i < disArr.length; i++) {
                distance += disArr[i];
            }

            min = Math.min(distance, min);


            return;
        }

        for (int i = idx; i <numChicken ; i++) {
            arr[depth][0] = chicken[i][0];
            arr[depth][1] = chicken[i][1];

            combination(arr, numHome, numChicken, r, depth+1, i+1);
        }

    }

    public static int saveChickenIndex(){
        int index = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if(map[i][j] == 2){
                    chicken[index][0] = i;
                    chicken[index][1] = j;
                    index++;
                }
            }
        }

        return index;
    }

    public static int saveHomeIndex(){
        int index = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if(map[i][j] == 1){
                    home[index][0] = i;
                    home[index][1] = j;
                    index++;
                }
            }
        }

        return index;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        chicken = new int[13][2];
        home = new int[2*n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int numChicken = saveChickenIndex();
        int numHome = saveHomeIndex();

        combination(new int[m][2], numHome ,numChicken, m, 0, 0);

        bw.write(min+"");

        br.close();
        bw.close();
    }
}
