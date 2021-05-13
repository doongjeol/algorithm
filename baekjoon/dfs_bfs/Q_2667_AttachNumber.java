package baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q_2667_AttachNumber {
	static int num, countAll, count;
	static int[][] matrix;
	static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
	static boolean[][] visited;
	static List<Integer> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num = Integer.parseInt(br.readLine()); // ������ ũ��
		matrix = new int[num][num];
		visited = new boolean[num][num];
		list = new ArrayList<Integer>();
		
		// �Է�
		for(int r=0 ; r<num ; r++) {
			String temp = br.readLine();
			for(int c=0 ; c<num ; c++) {
				matrix[r][c] = temp.charAt(c) -'0';
			}
		}
		
		// dfs ��ü Ž��
		for(int r=0 ; r<num ; r++) {
			for(int c=0 ; c<num ; c++) {
				if(matrix[r][c] == 1 && !visited[r][c]) {
					dfs(r,c);
					countAll++;
					list.add(count);
					count = 0;
				}
			}
		}
		
		System.out.println(countAll);
		Collections.sort(list);
		for(int i=0 ; i<list.size() ; i++)
			System.out.println(list.get(i));
	}
	
	public static void dfs(int indexR, int indexC) {
		visited[indexR][indexC] = true;
		count++;
		
		for(int i=0 ; i<4 ; i++) {
			int nodeR = indexR + dir[i][0];
			int nodeC = indexC + dir[i][1];
			
			if(nodeR<0 || nodeR>=num || nodeC<0 || nodeC>=num) continue;
			else if(matrix[nodeR][nodeC] == 1 && !visited[nodeR][nodeC])
				dfs(nodeR, nodeC);
			}
	}
}
