package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_10845_Queue {
    public static Queue<Integer> queue = new LinkedList<>();
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
            } else
                command = st.nextToken();
            solution(command,integer);


        }
    }

    public static void solution(String command, int integer) {
        int size = queue.size();

        switch (command) {
            case "push":
                queue.add(integer);
                break;
            case "pop":
                if(queue.isEmpty())
                    System.out.println(-1);
                else
                    System.out.println(queue.poll());
                break;
            case "size":
                System.out.println(size);
                break;
            case "empty":
                if(queue.isEmpty())
                    System.out.println(1);
                else
                    System.out.println(0);
                break;
            case "front":
                if(queue.isEmpty())
                    System.out.println(-1);
                else
                    System.out.println(queue.peek());
                break;
            case "back":
                if(queue.isEmpty())
                    System.out.println(-1);
                else
                    System.out.println(findLast());
                break;
        }
    }

    public static int findLast(){
        Iterator<Integer> iterator = queue.iterator();
        int current = 0;
        while(iterator.hasNext()){
            current = iterator.next();
        }

        return current;
    }
}
