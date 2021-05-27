package BeakJun_example.Math;

import java.io.*;

public class HoneyComb {
    static int N;
    static int result = 0;

    static void Input() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        br.close();

    }

    static void Solution() throws IOException{

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int i = 0;

        if(N == 1) result = 1;

        N--;

        while(N > 0){

            N -= 6 * i;
            i++;
            result = i;

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
