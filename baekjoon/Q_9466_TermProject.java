package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q_9466_TermProject {
	static int num, result, resultTemp;
	static List<ArrayList<Integer>> list;
	static boolean[] visited;
	static int[] success;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		
		// �Է�
		for(int i=0 ; i<testcase ; i++) {
			num = Integer.parseInt(br.readLine());
			visited = new boolean[num+1];
			success = new int[num+1]; // ?:0 1:F 2:T
			list = new ArrayList<ArrayList<Integer>>();
			result = 0;
			for(int j=0 ; j<=num ; j++) {
				list.add(new ArrayList());
			}
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int r=1 ; r<=num ; r++) {
				int c = Integer.parseInt(st.nextToken());
				list.get(r).add(c);
			}
			
			for(int r=1 ; r<=num ; r++) {
				if(!visited[r])
					dfs(r);
//				System.out.println(resultTemp);
			}
//			for(int a=1 ; a<success.length ; a++)
//				System.out.print(success[a]+" ");
//			System.out.println();
			
			System.out.println(num - result);
		}
		
		
	}
	
	public static void dfs(int index) {
		visited[index] = true;
		int to = list.get(index).get(0); // index�� ���� �ִ� ��
		
		// index�� ������ �ִ� ���� �湮���� �ʾҴٸ�
		if(!visited[to]) {
			dfs(to);
		} 
		// index�� ������ �ִ� ���� �湮�Ͽ��µ� ���� cycle���� �𸥴ٸ� cycle
		if(visited[to] && success[to] == 0) {
			success[to] = 2;
			result++;
		// index�� ������ �ִ� ���� �湮�Ͽ��µ� cycle�̶�� ���� index�� not cycle
		} else if(visited[to] && success[to] != 0) {
			success[index] = 1;
		} 
		
	}
	
	
}
