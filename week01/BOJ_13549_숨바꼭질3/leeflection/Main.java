package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ13549_숨바꼭질3 {
    static int N,K;
    static int[] dist;
    static final int INF = Integer.MAX_VALUE/1000;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dist = new int[100001];

        Arrays.fill(dist , INF);

        dijkstra();
        System.out.println(dist[K]);
    }

    private static void dijkstra() {
        Queue<int[]> pq = new ArrayDeque<>();
        dist[N] = 0;
        pq.add(new int[] {N,0});

        while(!pq.isEmpty()){
            int[] tmp = pq.poll();
            int pos = tmp[0];
            int time = tmp[1];
            if(pos == K) return;
            for(int i=0; i<3; i++){
                if(i==0){
                    //+1
                    if(pos+1<=100000 && dist[pos+1] > time+1){
                        dist[pos+1] = time+1;
                        pq.add(new int[]{pos+1,time+1});
                    }
                }
                else if(i==1){
                    //-1
                    if(pos-1>=0 && dist[pos-1] > time+1){
                        dist[pos-1] = time+1;
                        pq.add(new int[]{pos-1,time+1});
                    }
                }
                else{
                    //*2
                    if(pos*2<=100000 && dist[pos*2] > time){
                        dist[pos*2] = time;
                        pq.add(new int[]{pos*2,time});
                    }
                }
            }
        }
    }
}
