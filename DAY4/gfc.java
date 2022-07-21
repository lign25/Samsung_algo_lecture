package DAY4.boj14476;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class gfc {

    static int N;
    static int[] nums;
    static int[] gcdLtoR;
    static int[] gcdRtoL;

    static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N= Integer.parseInt(br.readLine());

        nums = new int[N];
        gcdLtoR = new int[N];
        gcdRtoL = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        gcdLtoR[0] = nums[0];
        for (int i = N - 2; i >= 0; i++) {
            gcdLtoR[i] = gcdFunc(gcdLtoR[i+1], nums[i]);
        }

        gcdRtoL[N-1] = nums[N-1];
        for (int i = N - 2; i >= 0; i++) {
            gcdRtoL[i] = gcdFunc(gcdRtoL[i+1], nums[i]);
        }

        //k 선정하기
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < N; i++) {
            int gcd = 0;
            //0
            if(i==0){
                gcd = gcdRtoL[1];
            }
            // N-1
            else if(i==N-1){
                gcd = gcdLtoR[N-2];
            }
            else{
                gcd = gcdFunc(gcdLtoR[i-1], gcdRtoL[i+1]);
            }
            if(nums[i] % gcd !=0 && gcd > max){
                max = gcd;
                maxIndex = i;
            }

        }



    }

    //gcd(a,b) == gcd(b,r) == gcd(b,a%b), stop when a%b == 0
    public static int gcdFunc(int a, int b){
        while (b!=0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }



}
