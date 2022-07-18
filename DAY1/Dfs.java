package DAY01.DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Dfs {
    static int N, K;
    static String[] words;
    static boolean[] visited;
    static int selectedCount = 0;
    static int max = 0;

    public static void main (String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        words = new String[N];
        visited = new boolean[26];
        visited['a' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['c' - 'a'] = true;

        for (int i = 0; i < N; i++){
            words[i] = (br.readLine()).toString().replaceAll("[antic]", "");
        }

        if(K < 5){
            System.out.println(0);
            return;
        }
        else if(26 == K) {
            System.out.println(N);
            return;
        }

        selectedCount = 5;
        max = countWords();


        for (int i=0;i<26;i++){
            if(!visited[i]){
                dfs(i);
            }
        }
        System.out.println(max);

    }

    static void dfs(int index){
        //1. 체크인
        visited[index] = true;
        selectedCount++;
        //2. 목적지인가?
        if(selectedCount == K){
            //계산
            max = Math.max(max, countWords());
        }else {
            //3. 연결된 곳을 순회 : index + 1 ~ 25
            for (int i = index + 1; i <= 25; i++) {
                //4. 갈 수 있는가? : 방문 여부
                if (!visited[i]) {
                    //5. 간다
                    dfs(i);
                }
            }
        }
        //6. 체크아웃
        visited[index] = false;
        selectedCount--;


   }


   static int countWords(){
        int count = 0;
        for (int n=0;n<N;n++){
            boolean isPossible = true;
            String word = words[n];
                    for(int i=0;i<word.length();i++){
                        //알파벳을 인덱스로 치환
                        if(!visited[word.charAt(i) - 'a']){
                            isPossible = false;
                            break;
                        }
                    }
                    if(isPossible){
                        count++;
                    }
        }
        return count;

   }

}

