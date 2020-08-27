package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q_10845_MakeQueue {
    public static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = "";
            int integer = 0;
            if (st.countTokens() == 2) {
                command = st.nextToken();
                integer = Integer.parseInt(st.nextToken());
            } else {
                command = st.nextToken();
            }
            solution(command,integer);
        }
    }

    public static void solution(String command, int integer) {
        int size = list.size();

        switch (command) {
            case "push":
                list.add(integer);
                break;
            case "pop":
                if(list.isEmpty())
                    System.out.println(-1);
                else {
                    System.out.println(list.get(0));
                    list.remove(0);
                }
                break;
            case "size":
                System.out.println(size);
                break;
            case "empty":
                if(list.isEmpty())
                    System.out.println(1);
                else
                    System.out.println(0);
                break;
            case "front":
                if (list.isEmpty())
                    System.out.println(-1);
                else
                    System.out.println(list.get(0));
                break;
            case "back":
                if(list.isEmpty())
                    System.out.println(-1);
                else
                    System.out.println(list.get(size-1));
                break;
        }
    }
}
