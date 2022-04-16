package baekjoon.bruteforce;
import java.io.*;
import java.util.HashSet;

public class Q_16922_MakeRomeNumber {
    public static int n,result;
    public static int[] data;
    public static HashSet<Integer> hashset = new HashSet();
    public static void combination(int[] arr, int depth, int idx) throws IOException{

        if(depth == n){
            int resultTmp = 0;
            for(int i=0 ; i <n ; i++){
                resultTmp += arr[i];
            }
            if(!hashset.contains(resultTmp)){
                hashset.add(resultTmp);
                result += 1;
            }
            return;
        }

        for (int i = idx; i < 4; i++) {
            arr[depth] = data[i];
            combination(arr, depth+1, i);

        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        data = new int[4];

        data[0] = 1;
        data[1] = 5;
        data[2] = 10;
        data[3] = 50;

        combination(new int[n], 0,0);
        bw.write(result+"");

        br.close();
        bw.close();
    }
}