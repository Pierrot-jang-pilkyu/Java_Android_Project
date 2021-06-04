package algorithm.bruteforce;

import java.io.*;

public class DomsdayNumber {
    static int Range = 2700000;
    static int N;
    
    static void Input() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        br.close();

    }

    static void Solution() throws IOException{

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = 0, result = 0;

        for(int i = 666; i < Range; i++){

            String compare = Integer.toString(i);

            if (compare.indexOf("666") != -1) {

                count++;
                if (count == N)
                    result = i;

            }

            
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