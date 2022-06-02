package baekjoon.string;
import java.io.*;
import java.util.*;

public class Q_5430_AC {
    public static List<String> result;
    public static boolean solution_fail(String func, List<String> list){
        result = new ArrayList<>(list);

        for (int i = 0; i < func.length(); i++) {
            switch (func.charAt(i)){
                case 'R':
                    List<String> temp = new ArrayList<>();
                    for (int j = result.size()-1; j >= 0; j--) {
                        temp.add(result.get(j));
                    }
                    result = new ArrayList<>(temp);

                    break;
                case 'D':
                    if(result.size() == 0){
                        return true;
                    } else {
                        result.remove(0);
                    }
                    break;
            }
        }

        return false;

    }

    public static String solution(Deque<Integer> dq, String func){
        boolean reverse = false;

        for (int i = 0; i < func.length(); i++) {
            switch (func.charAt(i)){
                case 'R':
                    reverse = !reverse;
                    break;
                case 'D':
                    if(dq.size() == 0){
                        return "error";
                    }
                    if (!reverse) {
                        dq.removeFirst();
                    } else{
                        dq.removeLast();
                    }
                    break;

            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        while(!dq.isEmpty()){
            sb.append(reverse ? dq.removeLast() : dq.removeFirst());
            if(dq.size() != 0){
                sb.append(',');
            }
        }
        sb.append(']');

        return sb.toString();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String func = br.readLine();
            int num = Integer.parseInt(br.readLine());
            String arrStr = br.readLine();

            arrStr = arrStr.substring(1,arrStr.length()-1);
            StringTokenizer st = new StringTokenizer(arrStr,",");
            List<String> list = new ArrayList<>();
            Deque<Integer> dq = new LinkedList<>();
            for (int j = 0; j < num; j++) {
                String token = st.nextToken();
                if(!token.equals(""))
                    dq.add(Integer.parseInt(token));
            }

            bw.write(solution(dq, func)+"\n");
        }

        br.close();
        bw.close();
    }
}
