package baekjoon.array_map_using_hash;
import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Q_1269_DaechingChajiphap {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int aNum = Integer.parseInt(st.nextToken());
        int bNum = Integer.parseInt(st.nextToken());

        HashMap<Integer,Boolean> aMap = new HashMap<>();
        HashMap<Integer,Boolean> bMap = new HashMap<>();
        HashMap<Integer, Boolean> abMap = new HashMap<>();
        HashMap<Integer, Boolean> baMap = new HashMap<>();
        int[] aArr = new int[aNum];
        int[] bArr = new int[bNum];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < aNum; i++) {
            int num = Integer.parseInt(st.nextToken());
            aMap.put(num, true);
            aArr[i] = num;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < bNum; i++) {
            int num = Integer.parseInt(st.nextToken());
            bMap.put(num, true);
            bArr[i] = num;
        }

        // A - B
        for (int i = 0; i < aArr.length; i++) {
            if(!bMap.containsKey(aArr[i])){
                abMap.put(aArr[i], true);
            }
        }

        // B - A
        for (int i = 0; i < bArr.length; i++) {
            if(!aMap.containsKey(bArr[i])){
                baMap.put(bArr[i], true);
            }
        }

        bw.write(abMap.size()+baMap.size()+"");
        br.close();
        bw.close();
    }
}
