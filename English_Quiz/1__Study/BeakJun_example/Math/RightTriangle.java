package BeakJun_example.Math;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Arrays;

public class RightTriangle {
    static ArrayList<Integer> A = new ArrayList<Integer>();
    static ArrayList<Integer> B = new ArrayList<Integer>();
    static ArrayList<Integer> C = new ArrayList<Integer>();

    static void Input() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = "1";

        while(input.charAt(0) != '0'){

            input = br.readLine();

            StringTokenizer st = new StringTokenizer(input);

            A.add(Integer.parseInt(st.nextToken()));
            B.add(Integer.parseInt(st.nextToken()));
            C.add(Integer.parseInt(st.nextToken()));

        }

        br.close();

    }

    static void Solution() throws IOException{

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean []result = new boolean[A.size() + 1];
        
        for(int i = 0; i < A.size(); i++){

            int []val = new int[3];

            val[0] = A.get(i);
            val[1] = B.get(i);
            val[2] = C.get(i);

            Arrays.sort(val);

            if(Math.pow(val[2], 2) == (Math.pow(val[0], 2) + Math.pow(val[1], 2)) && A.get(i) != 0)
                result[i + 1] = true;
            

        }

        for(int i = 1; i < A.size(); i++){

            if(result[i]) bw.write("right" + "\n");
            else bw.write("wrong" + "\n");

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
