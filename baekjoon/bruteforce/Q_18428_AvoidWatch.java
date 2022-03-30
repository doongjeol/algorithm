package baekjoon.bruteforce;
import java.io.*;
import java.util.StringTokenizer;

public class Q_18428_AvoidWatch {
    public static int n;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    public static int result;
    public static int debug1,debug2 = 0;
    public static void solution(int count, char[][] arr) {
        if(count == 3){
            debug1 +=1 ;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(arr[i][j] == 'T'){
                        if(check(i, j, arr)){
                            result += 1;
                        };
                    }
                }
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i][j] == 'X'){
                    arr[i][j] = 'O';
                    solution(count+1, arr);
                    arr[i][j] = 'X';
                }

            }
        }
    }

    public static boolean check(int curR, int curC, char[][] arr){
        // 위
        for (int i = curR; i >= 0; i--) {
            if(arr[i][curC] == 'O'){
                break;
            }
            if(arr[i][curC] == 'S'){
                debug2 += 1;
                return false;
            }
        }

        // 왼쪽
        for (int i = curC; i >= 0; i--) {
            if(arr[curR][i] == 'O'){
                break;
            }
            if(arr[curR][i] == 'S'){
                debug2 += 1;
                return false;
            }
        }

        // 아래
        for (int i = curR; i < n; i++) {
            if(arr[i][curC] == 'O'){
                break;
            }
            if(arr[i][curC] == 'S'){
                debug2 += 1;
                return false;
            }
        }

        // 오른쪽
        for (int i = curC; i < n; i++) {
            if(arr[curR][i] == 'O'){
                break;
            }
            if(arr[curR][i] == 'S'){
                debug2 += 1;
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        char[][] arr = new char[n][n];

        for (int i = 0; i < n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n ; j++) {
                arr[i][j] = st.nextToken().charAt(0);
            }
        }

        solution(0, arr);
        bw.write(debug1 +" "+debug2+" "+result);
        if(result > 0){
            bw.write("YES");
        } else{
            bw.write("NO");
        }
        br.close();
        bw.close();
    }
}
