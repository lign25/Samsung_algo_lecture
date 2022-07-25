package DAY06.boj1922;

import java.util.*;
import java.io.*;

//컴퓨터끼리 네트워크 연결
public class network {
    static PriorityQueue<Node> pq;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n=Integer.parseInt(br.readLine());
        int m=Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>();
        parent=new int[n+1];
        for(int i=1;i<=n;i++){
            parent[i]=i; // 부모는 자기 자신
        }

        for(int i=0;i<m;i++) {
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            pq.offer(new Node(a, b, c));
        }

        System.out.println(connect());
    }

    public static int connect() {
        int sum=0;

        while(!pq.isEmpty()) { // 가중치 작은 것부터 뽑기
            Node node=pq.poll();
            int parentS=find(node.start);
            int parentE=find(node.end);
            if(parentS!=parentE) { // 부모끼리 연결 시 사이클이 돌지 않으면 진행
                union(parentS, parentE);
                sum += node.weight;
            }
        }

        return sum;
    }

    public static int find(int x) { // 최상위 부모 탐색
        if(x==parent[x]) return x;
        else return parent[x]=find(parent[x]);
    }

    public static void union(int a, int b) { // 정점끼리 연결
        parent[a]=b;
    }

}
 class Node implements Comparable<Node>{
    int start;
    int end;
    int weight;

    public Node(int s, int e, int w) {
        this.start=s;
        this.end=e;
        this.weight=w;
    }

    @Override
    public int compareTo(Node n) {
        return this.weight-n.weight;
    }
}


