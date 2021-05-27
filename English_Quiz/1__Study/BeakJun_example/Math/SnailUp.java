package BeakJun_example.Math;

import java.io.*;
import java.util.StringTokenizer;

public class SnailUp {
    static double A, B, V;
    static double result;

    static void Input() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Double.parseDouble(st.nextToken());
        B = Double.parseDouble(st.nextToken());
        V = Double.parseDouble(st.nextToken());

        br.close();

    }

    static void Solution() throws IOException{

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        result = Math.ceil((V - A) / (A - B)) + 1;

        bw.write((int)result + "\n");
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
