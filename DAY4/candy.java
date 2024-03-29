package DAY4.boj3955;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class candy {

    static int N, A, B;

    static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in);

        N = Integer.parseInt(br.readLine());
        // X : 인당 나눠줄 사탕의 수
        // Y : 사탕 봉지의 수
        // A * x + q = B * y
        // Ax + By = C 의 형태로 변환
        // A(-x) + By = 1 의 형태로 변환

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            //1. 해 검증
            // D = gcd(A, B) = gcd(A, B).r




        }





    }



    static EGResult extendedGcd(long a, long b){
        long s0 = 1, t0 = 0, r0 = a;
        long s1 = 0, t1 = 1, r1 = b;

        long temp;
        while ( r1 !=0 ){
            long q = r0/r1;

            temp = r0 - q * r1;
            r0 = r1;
            r1 = temp;

            temp = s0 - q * s1;
            s0 = s1;
            s1 = temp;

            temp = t0 - q * t1;
            t0 = t1;
            t1 = temp;
        }
        return new EGResult(s0, t0, r0);

    }

    static class EGResult {
        long s;
        long t;
        long r;

        public EGResult(long s, long t, long r){
            super();
            this.s = s;
            this.t = t;
            this.r = r;

        }

    }




}
