package DAY03.boj1927;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;


public class min_heap {

    public static void main(String[] args) throws IOException{
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());

        int[] arr = new int[input];

        for (int i = 0; i < input; i++) {
            arr[i] = Integer.parseInt(br.readLine());
          try {
              if (arr[i] == 0) {
                  System.out.println(priorityQueue.remove());
              } else {
                  priorityQueue.add(arr[i]);
              }
          } catch (Exception e) {
              System.out.println("0");
          }

        }

    }

}
