package baekjoon;
import java.io.*;
import java.util.Random;

public class Sadari {
    public static void solution(String[] from, String[] to){
        Random rand = new Random();
        boolean[] chkFrom = new boolean[4];
        boolean[] chkTo = new boolean[4];
        for(int i=0 ; i<4 ; i++) {
            while (!chkFrom[i]) {
                int fromI = rand.nextInt(4);
                int toI = rand.nextInt(4);
                if (!chkFrom[fromI] && !chkTo[toI] && fromI != toI) {
                    System.out.print(from[fromI] + " ");
                    System.out.println(to[toI] + " ");
                    chkFrom[fromI] = true;
                    chkTo[toI] = true;
                }
            }
        }

    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] from = new String[4];
        String[] to = new String[4];

        from[0] = "뚜니가";
        from[1] = "하블리가";
        from[2] = "방구가";
        from[3] = "디니가";

        to[0] = "뚜니에게";
        to[1] = "하블리에게";
        to[2] = "방구에게";
        to[3] = "디니에게";

        solution(from, to);

        br.close();
        bw.close();
    }
}
