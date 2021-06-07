package algorithm.backtracking;

import java.io.*;

public class Nqueen {
    static int N;
    static int result = 0;
    static int []column;
    
    static void Input() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        column = new int[N];

        br.close();

    }

    static boolean promising(int row){

        for(int i = 0; i < row; i++){

            // Compare before column and current column
            if(column[i] == column[row])
                return false;

            // Check same cross
            if(Math.abs(row - i) == Math.abs(column[row] - column[i]))
                return false;

        }

        return true;

    }

    static void N_Queen(int row) throws IOException{

        if(row == N){
            
            result++;

            return;

        }

        for(int i = 0; i < N; i++){

            column[row] = i;

            if(promising(row)) {

                N_Queen(row + 1);

            }

        }


    }

    

    static void Solution() throws IOException{

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N_Queen(0);

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