package BeakJun_example.Math;

import java.io.*;

public class TexiGeometry {
    static double R, result_T, result_E;

    static void Input() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        R = Double.parseDouble(br.readLine());

        br.close();

    }

    static void Solution() throws IOException{

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        result_E = Math.PI * R * R ;
        result_T = Math.sqrt(2) * Math.sqrt(2) * R * R;
         // In Texi Geometry, trace of point on circle  is a Sqare whose side length root2 times R.

        bw.write(result_E + "\n");
        bw.write(result_T + "\n");

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
