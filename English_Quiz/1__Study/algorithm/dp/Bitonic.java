package algorithm.dp;

import java.io.*;
import java.util.StringTokenizer;

public class Bitonic {
    static int N_MAX = 1000 + 2;
    static int N;
    static int []S = new int[N_MAX];          // Input Value Array 
    static int []natureDP = new int[N_MAX];   
    // The length of the sequence in longest nature order up to the i-th among sequences from 1-N.
    static int []reverseDP = new int[N_MAX];  
    // The length of the sequence in longest reverse order up to the i-th among sequences from N-1.
    static int []bitonicDP = new int[N_MAX];  

    
    static void Input() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= N; i++){

            S[i] = Integer.parseInt(st.nextToken());

        }

        br.close();

        for(int i = 1; i <= N; i++){

            natureDP[i] = 1;
            reverseDP[i] = 1;
            bitonicDP[i] = 1;

        }

    }

    static void natureOder(int _DP[], int left, int right){


        int length;

        if(left <= right)
            for (int i = left; i <= right; i++) {

                length = _DP[i];

                for(int j = 1; j <= i; j++){

                    if(S[i] > S[j])
                        if(length < _DP[j] + 1)
                            length =  _DP[j] + 1;

                }

                _DP[i] = length;

            }

        if(left > right)
            for (int i = left; i >= right; i--) {

                length = _DP[i];

                for(int j = i; j <= left; j++){

                    if(S[i] > S[j])
                        if(length < _DP[j] + 1)
                            length =  _DP[j] + 1;

                }

                _DP[i] = length;
                
            }

    }

    static void Solution() throws IOException{

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int result = 0;

        for (int i = 1; i <= N; i++) {

            int length = natureDP[i];

            for(int j = 1; j <= i; j++){

                if(S[i] > S[j])
                    if(length < natureDP[j] + 1)
                        length =  natureDP[j] + 1;

            }

            natureDP[i] = length;

        }

        for (int i = N; i >= 1; i--) {

            int length = reverseDP[i];

            for(int j = i; j <= N; j++){

                if(S[i] > S[j])
                    if(length < reverseDP[j] + 1)
                        length =  reverseDP[j] + 1;

            }

            reverseDP[i] = length;
            
        }

        for(int i = 1; i <= N; i++){

            bitonicDP[i] = natureDP[i] + reverseDP[i] - 1;

        }

        for(int i = 1; i <= N; i++){

            result = Math.max(result, bitonicDP[i]);

        }

        bw.write(result + "\n");


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