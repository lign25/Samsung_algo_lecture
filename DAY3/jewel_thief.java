package DAY03.boj.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class jewel_thief {
    static int N, K;
    static Jewelry[] jewelries;
    static int[] bags;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        jewelries = new Jewelry[N];
        bags = new int[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            jewelries[i] =
                    new Jewelry(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        //가방 오름차순 정렬
        Arrays.sort(bags);
        //보석 무게 오름차순 정렬
        Arrays.sort(jewelries, Comparator.comparing(Jewelry::getWeight));
        //보석 가격이 높은값 기준 합
        PriorityQueue<Jewelry> pq = new PriorityQueue<>(Comparator.comparing(Jewelry::getValue).reversed());

        int jIndex = 0;
        long result = 0;
        //1. 남은 가방 중 제일 작은 가방을 선택 <- 정렬
        for (int i = 0; i < bags.length; i++) {
            //2. 선택된 가방에 넣을 수 있는 남은 보석 중 가장 비싼 보석을 선택
            while(jIndex < N && jewelries[jIndex].weight <= bags[i]){
                pq.add(jewelries[jIndex++]);
            }
            if(!pq.isEmpty()){
                result += pq.poll().value;
            }
        }
        System.out.println(result);

    }
}


class Jewelry {
    int weight;
    int value;

    public int getWeight() { return  weight;}
    public int getValue() { return  value;}

    public Jewelry(int weight, int value){
        this.weight = weight;
        this.value = value;
    }


    @Override
    public String toString() {return " " +weight + value + " ";}



}
