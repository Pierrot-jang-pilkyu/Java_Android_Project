package BeakJun_example;

import java.io.*;

public class BeakJunIO {
    static int N;
    static int result;
    static int [][]AB;

    static void Input() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        AB = new int[N + 1][2];

        String temp;
        String []tokens;

        for(int i = 1; i <= N; i++){

            temp = br.readLine();
            tokens = temp.split(" ");

            AB[i][0] = Integer.parseInt(tokens[0]);
            AB[i][1] = Integer.parseInt(tokens[1]);

        }

        br.close();

    }

    static void Solution() throws IOException{

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        for(int i = 1; i <= N; i++){
            result = AB[i][0] + AB[i][1];
            bw.write(result + "\n");
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
