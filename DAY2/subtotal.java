package DAY02.boj1806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class subtotal {


    static int[] nums;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        nums = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());

        }

        int low = 0, high = 0, sum = nums[0], minLength = Integer.MAX_VALUE;
        while(true) {
            if(sum>=M){
                minLength = Math.min(high - low + 1, minLength);
                sum -= nums[low++];

            }
            else {
                sum += nums[++high];
            }

            if (high == N){
                break;
            }
        }
        if (minLength==Integer.MAX_VALUE){
            System.out.println(0);
        }else
        System.out.println(minLength);

    }
}
