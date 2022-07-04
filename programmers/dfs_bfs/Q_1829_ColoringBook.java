package programmers.dfs_bfs;

public class Q_1829_ColoringBook {

    public static int sizeOfArea;
    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        sizeOfArea = 0;

        int color = 0;

        // dfs 수행
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if(picture[row][col] > 0){
                    color = picture[row][col];
                }

                if (picture[row][col] == color) {
                    dfs(row, col, n, m, picture, color);
                    numberOfArea +=1 ;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, sizeOfArea);
                    sizeOfArea = 0;
                }
            }
        }
        System.out.println(numberOfArea);
        System.out.println(maxSizeOfOneArea);
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public static void dfs(int row, int col, int n, int m, int[][] picture, int color) {
        if(row < 0 || col < 0 || row >= m || col >= n) return;

        if (picture[row][col] == color) {
            // 방문처리
            picture[row][col] = 0;
            sizeOfArea += 1;
            // 상, 하, 좌, 우 방문 수행
            dfs(row - 1, col, n, m, picture, color);
            dfs(row + 1, col, n, m, picture, color);
            dfs(row, col - 1, n, m, picture, color);
            dfs(row, col + 1, n, m, picture, color);
        }
    }

    public static void main(String[] args) {
        int m = 6;
        int n = 10;
//        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        int[][] picture = {
                {1,1,0,0,0,0,0,0,5,0},
                {0,1,0,0,0,2,0,0,0,0},
                {0,0,0,0,2,0,0,0,0,0},
                {0,0,0,2,2,2,0,0,0,0},
                {0,0,2,2,2,0,0,4,4,4},
                {0,0,0,0,2,0,0,4,4,4}
        };

        solution(m, n, picture);
    }
}
