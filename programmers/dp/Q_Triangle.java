package programmers.dp;
import java.io.*;

//정수 삼각형
public class Q_Triangle {
    public static int solution(int[][] triangle){

        int[][] result = new int[triangle.length][triangle.length];

        for (int i = triangle.length-2; i >=0; i--) {
            for (int j = 0; j < triangle[i].length; j++) {
                result[i][j] += Math.max(triangle[i + 1][j], triangle[i + 1][j + 1]);
                /*result[i+1][j] // 왼쪽 아래
                *result[i+1][j+1] // 오른쪽 아래
                 */
            }
        }

        return result[0][0];
    }

    public static void main (String[] args) throws IOException {

        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};;

        System.out.println(solution(triangle));
    }
}
