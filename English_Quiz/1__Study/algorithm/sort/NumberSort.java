package algorithm.sort;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;


public class NumberSort {
    static String N;
    static ArrayList<Integer> result = new ArrayList<Integer>();
    
    static void Input() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = br.readLine();

        br.close();

    }

    

    static void Solution() throws IOException{

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        for(int i = 0; i < N.length(); i++)
            result.add(N.charAt(i) - '0');

        result.sort(Comparator.reverseOrder());

        for(int i : result)
            bw.write(i + "");

        bw.newLine();

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