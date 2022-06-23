package baekjoon.array_map_using_hash;
import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class Q_4358_Ecology {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<String, Integer> hashMap = new HashMap();
        int total = 0;
        while(true){
            String tree = br.readLine();
            if(tree == null){
                break;
            }
            total += 1;
            if(hashMap.containsKey(tree)){
                int count = hashMap.get(tree) + 1;
                hashMap.replace(tree, count);
            } else {
                hashMap.put(tree, 1);
            }
        }

        Object[] key = hashMap.keySet().toArray();
        Arrays.sort(key);

        for (int i = 0; i < key.length; i++) {
            double value = hashMap.get(key[i]);
            double percent = value * 100 / total ;

            bw.write(key[i]+" "+String.format("%.4f",percent)+"\n");
        }
        br.close();
        bw.close();
    }
}
