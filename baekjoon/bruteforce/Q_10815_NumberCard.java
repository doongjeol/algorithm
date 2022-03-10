package baekjoon.bruteforce;
import java.io.*;
import java.util.*;

public class Q_10815_NumberCard {
    public static int[] result;
    public static int startt;
    public static void solution(int[] card, int[][] compareCard, int depth, int start){
        if(depth == card.length){
            return;
        }

        out : for (int i = startt; i < compareCard.length ; i++) {
            if(card[depth] == compareCard[i][0]){
                result[compareCard[i][1]] = 1;
                startt += 1;
                solution(card, compareCard, depth+1, start+1);
                continue out;
            }
        }
        solution(card, compareCard, depth + 1, start);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] card = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(card);

        int m = Integer.parseInt(br.readLine());
        int[][] compareCard = new int[m][2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            compareCard[i][0] = Integer.parseInt(st.nextToken());
            compareCard[i][1] = i;
        }

        Arrays.sort(compareCard,(o1, o2) -> {
            if(o1[0] == o2[1]){
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });

        result = new int[m];

        solution(card,compareCard,0,0);
        for (int i = 0; i < result.length; i++) {
            bw.write(result[i]+" ");
        }

        br.close();
        bw.close();
    }
}
