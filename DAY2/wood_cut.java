package DAY02.boj2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class wood_cut {
    static int[] trees;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        trees = new int[N];

        int max = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            max = Math.max(trees[i], max);
        }

        long s = 0;
        long e = max;
        long mid;
        long result = 0;

        while(true){
            mid = (s + e) / 2;
            long sum = calc(mid);
            // sum == M -> 정답, 탈출
            if(sum ==M){
                result = mid;
                break;
            }
            // sum < M -> mid -> end
            else if(sum<M){
                e = mid - 1;
            }
            // sum > M -> mid -> s, 정답 후보
            else {
                result = mid;
                s = mid+1;
            }

            if(s > e){
                break;
            }
        }
        System.out.println(result);

    }

    public static long calc(long value) {
        long result =0;
        for (int i = 0; i < trees.length; i++) {
            int tree = trees[i];
            if(tree > value) {
                result += tree - value;
            }
        }
        return result;
    }
}
