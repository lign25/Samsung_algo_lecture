package DAY03.boj1072;

import java.util.Scanner;

public class game {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        long X = sc.nextLong();
        long Y = sc.nextLong();

        long Z = 100 * Y / X;

        if(Z >= 99) {
            System.out.println(-1);
        } else {
            long start = 0;
            long end = X;
            while(start < end){
                long mid = (start + end) / 2;
                long newRate = (100 * (Y + mid) / (X + mid));
                //승률이 그대로인 경우
                if(newRate==Z) {
                    start = mid + 1;
                }
                //승률이 변한 경우
                else {
                    end = mid;
                }
            }
            System.out.println(end);
        }



    }
}
