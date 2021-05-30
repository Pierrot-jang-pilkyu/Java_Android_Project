package BeakJun_example.Math;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Eratos {
    static int M, N;
    static boolean []primeNum;
    static ArrayList<Integer> result = new ArrayList<Integer>();

    static void Input() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());

        N = Integer.parseInt(st.nextToken());

        primeNum = new boolean[N + 1];

        br.close();

    }

    static void Eratosfunc(int n){

        if(n <= 1) return;

        for(int i = 0; i < 2; i++){

            primeNum[i] = false;

        }

        for(int i = 2; i <= n; i++){

            primeNum[i] = true;

        }

        for(int i = 2; i * i <= n; i++){
            
            if(primeNum[i])
                for(int j = i * i; j <= n; j += i)
                    primeNum[j] = false;

        }


    }

    static void Solution() throws IOException{

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Eratosfunc(N);

        for(int i = M; i <= N; i++){

            if(primeNum[i])
                result.add(i);

        }

        for(int i : result)
            bw.write(i + "\n");
    
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

