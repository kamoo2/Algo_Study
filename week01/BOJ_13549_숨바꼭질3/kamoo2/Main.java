package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 문제 제목 : 숨바꼭질3
 * 문제 번호 : 13549
 * 문제 난이도 : 골드 5
 * https://www.acmicpc.net/problem/13549
 */
public class Main {
	static int S,E;
	static int[] times;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		S = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		times = new int[100001];
		for(int i=0;i<100001;i++) {
			times[i] = Integer.MAX_VALUE/1000;
		}

		bfs(S);

		System.out.println(times[E]);
	}

	static void bfs(int S) {
		PriorityQueue<Info> PQ = new PriorityQueue<Info>((o1,o2) -> o1.time - o2.time);
		times[S] = 0;
		PQ.offer(new Info(S,0));


		while(!PQ.isEmpty()) {
			Info info = PQ.poll();
			if(info.pos == E) break;

			if(times[info.pos] < info.time) continue;
//			System.out.println("pos : " + info.pos + " & time : " + info.time);
			for(int i=0;i<3;i++) {
				if(i == 0) {
					if(info.pos + 1 > 100000) continue;
					if(times[info.pos + 1] > info.time + 1) {
						times[info.pos + 1] = info.time + 1;
						PQ.offer(new Info(info.pos + 1,info.time + 1));
					}
				}else if(i == 1) {
					if(info.pos -1 < 0) continue;
					if(times[info.pos - 1] > info.time + 1) {
						times[info.pos - 1] = info.time + 1;
						PQ.offer(new Info(info.pos - 1,info.time + 1));
					}
				}else {
					if(info.pos * 2 > 100000) continue;
					if(times[info.pos * 2] > info.time) {
						times[info.pos * 2] = info.time;
						PQ.offer(new Info(info.pos * 2,info.time));
					}
				}
			}
		}
	}

	static class Info{
		int pos;
		int time;
		public Info(int pos,int time) {
			this.pos = pos;
			this.time =time;
		}
	}
}
