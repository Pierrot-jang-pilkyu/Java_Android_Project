package BeakJun_example.Math;

import java.io.*;

public class Fibonacci_recursion {
    static int N;
    static int result;

    static void Input() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        br.close();

    }

    static int N_fibonacci(int n){
        if(n <= 0) return 0;
        if(n == 1) return 1;
        return N_fibonacci(n - 1) + N_fibonacci(n - 2);
    }

    static void Solution() throws IOException{

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        result = N_fibonacci(N);
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
