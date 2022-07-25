package DAY06.boj1717;

import java.io.*;
import java.util.*;


public class operation_set {

    static int N, M;
    static int type, a, b;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int [N+1];

        for (int i = 1; i<= N; i++) {
            parent[i] = i;
        }

        for (int i = 1; i<= M; i++) {
            st = new StringTokenizer(br.readLine());
            type = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            // 0 일 경우 union
            if (type == 0) {
                union(a,b);
            }

            // 1 일 경우 find
            else if (type == 1)
            {
                if (find(a)==find(b)) {
                    bw.write("YES\n");
                }
                else {
                    bw.write("NO\n");
                }
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }

    // a와 b를 하나의 집합으로 만드는 함수
    static void union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        parent[pa] = pb;
    }

    // id의 조상을 찾는 함수
    static int find(int id) {
        if (parent[id]==id) return id;
        return parent[id] = find(parent[id]);
    }
}