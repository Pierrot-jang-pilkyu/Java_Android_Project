package algorithm.dp;

import java.io.*;

public class MakeToOne {
    static int N_MAX = 1000000 + 1;
    static int N;
    static int []DP = new int[N_MAX];
    
    static void Input() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        br.close();

        DP[0] = Integer.MAX_VALUE;
        DP[1] = 0;
        DP[2] = 1;
        DP[3] = 1;

    }

    static int makeToOne(int n){

        if(n < 1) return Integer.MAX_VALUE;
        if(n == 1) return 0;
        if(n == 2) return 1;
        if(n == 3) return 1;
    
        if(DP[n] != 0) return DP[n];
    
        return DP[n] = Math.min(Math.min(makeToOne(n % 3 == 0? n / 3 : 0), makeToOne(n % 2 == 0? n / 2 : 0)), makeToOne(n - 1)) + 1;
    
    }

    static void Solution() throws IOException{

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 4; i <= N; i++){

            DP[i] = Math.min(Math.min(DP[i % 3 == 0? i / 3 : 0], DP[i % 2 == 0? i / 2 : 0]), DP[i - 1]) + 1;

        }

        bw.write(DP[N] + " ");

        bw.flush();
        bw.close();

    }
    
    static void Solve() throws IOException{

        Input();

        Solution();

    }

    public static void main(String[] args) throws IOException{
        
        Solve();

    }
}