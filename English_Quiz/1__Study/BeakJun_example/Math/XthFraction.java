package BeakJun_example.Math;

import java.io.*;

public class XthFraction {
    static int X;
    static String result = "";

    static void Input() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        X = Integer.parseInt(br.readLine());

        br.close();

    }

    static void Solution() throws IOException{

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int i = 1;

        while(X > 0){

            X -= i;
            i++;

        }

        if((i - 1) % 2 == 0){

            result = Integer.toString((i - 1) + X) + "/" + Integer.toString(i - ((i - 1) + X));

        }
        else if((i - 1) % 2 == 1){

            result = Integer.toString(i - ((i - 1) + X)) + "/" + Integer.toString((i - 1) + X);

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
