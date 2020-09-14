package string;

import java.io.*;
import java.util.StringTokenizer;

public class Q_1406_Editor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int num = Integer.parseInt(br.readLine());
        int cursor = str.length();

        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            String c = "";
            if (st.countTokens() == 1) {
                c = st.nextToken();
            }

            switch (command) {
                case "L":
                    if (cursor != 0)
                        cursor -= 1;
                    break;
                case "D":
                    if (cursor != str.length())
                        cursor += 1;
                    break;
                case "B":
                    // substring(포함, 미포함)
                    if (cursor != 0) {
                        if(cursor == str.length())
                            str = str.substring(0, cursor-1);
                        else if(cursor == 1)
                            str = str.substring(cursor);
                        else
                            str = str.substring(0, cursor - 1) + str.substring(cursor);
                        cursor -= 1;
                    }
                    break;
                case "P":
                    if(cursor == str.length())
                        str = str.substring(0, cursor) + c;
                    else if(cursor == 0)
                        str = c + str;
                    else
                        str = str.substring(0, cursor) + c + str.substring(cursor);
                    cursor += 1;
                    break;
            }
        }
        bw.write(str + "\n");
        br.close();
        bw.close();
    }

}
