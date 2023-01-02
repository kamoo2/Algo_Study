package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ4485_녹색_옷_입은_애가_젤다지 {
    static int N;
    static int[][] map;
    static int[][] dist;
    static int[] dx={0,0,-1,1};
    static int[] dy={-1,1,0,0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 1;
        while(true){
            N = Integer.parseInt(br.readLine());
            if(N==0){
                break;
            }
            map = new int[N][N];
            dist = new int[N][N];

            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    dist[i][j] = Integer.MAX_VALUE/1000;
                }
            }

            bfs();
            System.out.println("Problem "+t+": "+dist[N-1][N-1]);
            t++;
        }
    }

    private static void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0,0,map[0][0]});
        dist[0][0] = 0;

        while(!q.isEmpty()){
            int[] tmp = q.poll();

            for(int i=0; i<4; i++){
                int nx = dx[i]+tmp[0];
                int ny = dy[i]+tmp[1];
                if(nx<0||ny<0||nx>=N||ny>=N) continue;
                if(dist[nx][ny] > map[nx][ny]+tmp[2]){
                    q.add(new int[] {nx,ny,map[nx][ny]+tmp[2]});
                    dist[nx][ny] = map[nx][ny]+tmp[2];
                }
            }
        }
    }
}
