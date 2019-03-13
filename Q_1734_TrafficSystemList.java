package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Q_1734_TrafficSystemList {
	static int n;
	static boolean flag;
	static boolean[] visited;
	static List<List<Integer>> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 도시의 개수
		int e = Integer.parseInt(st.nextToken()); // 도로의 개수
		list = new ArrayList<List<Integer>>();
		
		// list 초기화
		for(int i=0 ; i<n+1 ; i++)  
			list.add(new ArrayList());
		
		// 입력받은대로 list에 저장
		for(int i=0 ; i<e ; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken()); // 연결된 도시 번호 1
			int n2 = Integer.parseInt(st.nextToken()); // 연결된 도시 번호 2
			list.get(n1).add(n2);
			list.get(n2).add(n1);
		}

		int q = Integer.parseInt(br.readLine()); // 질문의 개수
		
		for(int i=0 ; i<q ; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			visited = new boolean[n+1];
			flag = false;
			switch(first) {
			case 1:
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int g1 = Integer.parseInt(st.nextToken());
				int g2 = Integer.parseInt(st.nextToken());
				
				dfs(a,b,g1,g2,-1);
				
				if(flag)
					System.out.println("yes");
				else
					System.out.println("no");
				
				break;
			case 2:
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				dfs(a,b,-1,-1,c);
				if(flag)
					System.out.println("yes");
				else
					System.out.println("no");
				
				break;
			}
		}
	}
	
	public static void dfs(int startIndex, int endIndex, int removeIndex1, int removeIndex2, int removeIndex3) {
		visited[startIndex] = true;
		
		for(int i : list.get(startIndex)) {
			if(!visited[i]) {
				if(endIndex == i) {
					flag = true;
					break;
				} else if(removeIndex3 == i) continue;
				else if((startIndex == removeIndex1 && i == removeIndex2) ||
						(startIndex == removeIndex2 && i == removeIndex1) ) continue;
				else 
					dfs(i, endIndex, removeIndex1, removeIndex2, removeIndex3);
			}
		}
		
	}
	
	public static void write() {
		for(int i=1 ; i<n+1 ; i++) {
			for(int j=0 ; j<list.get(i).size() ; j++) {
				System.out.print(i+": "+list.get(i).get(j)+"  | ");
			}
			System.out.println();
		}
 	}
}
