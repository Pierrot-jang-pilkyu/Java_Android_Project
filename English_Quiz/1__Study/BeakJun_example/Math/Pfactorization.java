package BeakJun_example.Math;

import java.io.*;
import java.util.ArrayList;

public class Pfactorization {
    static int N;
    static ArrayList<Integer> result = new ArrayList<Integer>();

    static void Input() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        br.close();

    }

    static void Solution() throws IOException{

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        while(N != 1){

            for(int i = 2; i <= N; i++){

                if(N % i == 0){
                    result.add(i);
                    N /= i;
                    break;
                }
            }
        }

        for(int i : result){
            bw.write(i + "\n");
        }

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
