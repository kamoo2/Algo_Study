

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int N,ans;
    static int[] map;
    static boolean[] visited;
    static int[] target;
    static HashMap<Integer, Integer> hashMap;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N];
        visited = new boolean[N];
        target = new int[2];
        hashMap = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            map[i] = Integer.parseInt(st.nextToken());
            hashMap.put(map[i],hashMap.getOrDefault(map[i],0)+1);
        }

        comb(0);
        System.out.println(ans);
    }

    private static void comb(int depth) {
        if(depth == 2){
            int sum = map[target[0]] + map[target[1]];
            if(hashMap.containsKey(sum)){
                int add = hashMap.get(sum);
                if(map[target[0]] == 0 && map[target[1]]==0){
                    if(add >= 3){
                        ans += add;
                        hashMap.remove(sum);
                    }
                }
                else if(map[target[0]] == 0 || map[target[1]]==0){
                    if(add >= 2){
                        ans += add;
                        hashMap.remove(sum);
                    }
                }
                else{
                    ans += add;
                    hashMap.remove(sum);
                }
            }
            return;
        }

        for(int i=0; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                target[depth] = i;
                comb(depth+1);
                visited[i]=false;
            }
        }

    }
}