package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q_4344_OverAverage {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		
		for(int i=0 ; i<testCase ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int studentNum = Integer.parseInt(st.nextToken()); //학생 수
			List<Integer> list = new ArrayList<>(); // 점수를 담을 list
			int avg = 0; // 평균
			for(int j=0 ; j<studentNum ; j++) {
				int score = Integer.parseInt(st.nextToken());
				list.add(score);
				avg += score;
			}
			avg /= studentNum;
			
			int studentAvg = 0; // 평균을 넘는 학생 수
			for(int j=0 ; j<list.size() ; j++) {
				if((int)list.get(j)>avg) {
					++studentAvg;
				}
				
			}
			System.out.println(String.format("%.3f", (double)studentAvg/studentNum*100)+"%");
			
			
		}
		
	}

}
