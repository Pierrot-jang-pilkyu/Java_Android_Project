package algorithm.dp;

import java.io.*;
import java.util.StringTokenizer;

public class Knapsack {
    static int N, K;        // Input Value Array 
    static int DP[];

    
    static void Input() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        K = Integer.parseInt(st.nextToken());

        DP = new int[K + 1];

        for(int i = 0; i < N; i++){

            st = new StringTokenizer(br.readLine());

            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            for(int j = K; j >= weight; j--){

                if(DP[j] < DP[j - weight] + value) DP[j] = DP[j - weight] + value;

            }

        }

        br.close();

    }

    static void Solution() throws IOException{

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(DP[K] + "\n");

        bw.flush();
        bw.close();

    }

    static void Solve() throws IOException {

        Input();

        Solution();

    }

    public static void main(String[] args) throws IOException{
        
        Solve();

    }
} 