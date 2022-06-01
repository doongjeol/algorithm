package baekjoon.string;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Q_1541_LostParentheses_timeout {
    public static List<String> aList = new ArrayList<>();
    public static List<String> bList = new ArrayList<>();
    public static void subSet(List<String> list, int n, int depth, String str, boolean isA){
        if(depth == n){
            String temp = "";
            for (int i = 0; i < list.size(); i++) {
                temp += list.get(i);
            }
            if(isA)
                aList.add(temp);
            else
                bList.add(temp);
            return;
        }

        list.add(str.charAt(depth)+"");
        subSet(list, n, depth + 1, str, isA);
        list.remove(list.size() - 1);
        subSet(list, n, depth + 1, str, isA);

    }

    public static int search(){
        int max = 0;

        for (int i = 0; i < aList.size(); i++) {
            for (int j = 0; j < bList.size(); j++) {
                if(aList.get(i).equals(bList.get(j))){
                    max = Math.max(max, aList.get(i).length());
                }
            }
        }

        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String a = br.readLine();
        String b = br.readLine();

        subSet(new ArrayList<>(), a.length(), 0, a, true);
        subSet(new ArrayList<>(), b.length(), 0, b, false);

        bw.write(search()+"");
        br.close();
        bw.close();
    }
}
