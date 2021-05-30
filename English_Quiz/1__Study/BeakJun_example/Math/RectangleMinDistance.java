package BeakJun_example.Math;

import java.io.*;
import java.util.StringTokenizer;


public class RectangleMinDistance { 
    static int X, Y, W, H;
    static int result;

    static void Input() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        br.close();

    }

    static void Solution() throws IOException{

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        result = Math.min(Math.min(X, Y), Math.min(W - X, H - Y));

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

