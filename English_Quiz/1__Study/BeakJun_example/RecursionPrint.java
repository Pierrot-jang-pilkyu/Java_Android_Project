package BeakJun_example;

import java.io.*;

public class RecursionPrint {
    static int N;
    static char [][]result;

    static void Input() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        result = new char[N + 1][N + 1];

        br.close();

    }

    static void starPettern(int n, int _n, int i, int j){

        if(n <= 1) return;

        if(n == _n){

            for(int x = i; x < (n + i); x++){
    
                for(int y = j; y < (n + j); y++){
    
                    result[x][y] = '*';
    
                }
            }

        }


        for(int x = 1; x <= 3; x++){

            for(int y = 1; y <= 3; y++){

                starPettern(n / 3, _n, i + (n/3) * (x - 1), j + (n/3) * (y - 1));

            }

        }

        for(int x = i; x < (n + i); x++){

            for(int y = j; y < (n + j); y++){

                if(((n/3 + (i - 1)) < x) && (x <= (2* (n/3) + (i - 1))) && ((n/3 + (j - 1)) < y) && (y <= (2* (n/3) + (j - 1))))
                    result[x][y] = ' ';

            }
        }
        
    }

    static void Solution() throws IOException{

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        starPettern(N, N, 1, 1);

        for(int i = 1; i <= N; i++){
            
            for(int j = 1; j <= N; j++){

                bw.write(result[i][j]);
            }
            bw.newLine();
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
