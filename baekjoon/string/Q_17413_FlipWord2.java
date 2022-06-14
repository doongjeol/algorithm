package baekjoon.string;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Q_17413_FlipWord2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        List<String> list = new ArrayList<>();
        String temp = "";
        boolean isWord = true;
        for (int i = 0; i < str.length(); i++) {


            if(str.charAt(i) == '<'){
                list.add(temp);
                temp = "<";
                isWord = false;
            } else if(str.charAt(i) == '>'){
                temp += ">";
                list.add(temp);
                temp = "";
                isWord = true;
            } else if(str.charAt(i)== ' ' && isWord){
                list.add(temp);
                temp = "";
            } else if(i == str.length()-1){
                temp += str.charAt(i);
                list.add(temp);
            } else {
                temp += str.charAt(i);
            }


        }

        isWord = false;
        String result = "";
        for (int i = 0; i < list.size(); i++) {
            if(!list.get(i).contains("<")){
                if(isWord){
                    result += " ";
                }
                for (int j = list.get(i).length() -1 ; j >=0 ; j--) {
                    result += list.get(i).charAt(j);
                }
                isWord = true;
            } else {
                result += list.get(i);
                isWord = false;
            }
        }

        bw.write(result);
        br.close();
        bw.close();
    }
}
