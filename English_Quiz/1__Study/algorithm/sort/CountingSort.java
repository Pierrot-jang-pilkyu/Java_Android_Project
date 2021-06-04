package algorithm.sort;

import java.io.*;

public class CountingSort {
    static int N_MAX = 10000 + 1;
    static int N;
    static int []inVal;
    static int []Count = new int[N_MAX];
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    static void Input() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        inVal = new int[N + 1];

        for(int i = 1; i <= N; i++){

            inVal[i] = Integer.parseInt(br.readLine());

        }

        br.close();

    }

    static void countingSort(int n) throws IOException{

        for(int i = 1; i <= n; i++){

            Count[inVal[i]] += 1;

        }

        for(int i = 1; i < N_MAX; i++){

            if(Count[i] == 0) continue;

            for(int j = 1; j <= Count[i]; j++){

                bw.write(i + "\n");

            }
        }

    }

    

    static void Solution() throws IOException{

        countingSort(N);

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