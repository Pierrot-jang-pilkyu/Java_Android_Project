package BeakJun_example.Math;

import java.io.*;

public class Factorial {
    static int N;
    static int result;

    static void Input() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        br.close();

    }

    static int N_factorial(int n){
        if(n <= 0) return 1;
        return n * N_factorial(n - 1);
    }

    static void Solution() throws IOException{

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        result = N_factorial(N);
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
