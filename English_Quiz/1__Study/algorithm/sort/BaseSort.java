package algorithm.sort;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;

public class BaseSort {
    static int N;
    static HashSet<Integer> inVal = new HashSet<Integer>();
    static ArrayList<Integer> result = new ArrayList<Integer>();
    
    static void Input() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for(int i = 1; i <= N; i++){

            inVal.add(Integer.parseInt(br.readLine()));

        }

        result = new ArrayList<Integer>(inVal);

        br.close();

    }

    

    static void Solution() throws IOException{

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        result.sort(Comparator.naturalOrder());


        for(int i : result)
            bw.write(i + "\n");


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