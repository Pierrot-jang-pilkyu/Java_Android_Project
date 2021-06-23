package algorithm.dp;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class LIS2 {
    static int N;        // Input Value Array 
    static ArrayList<Integer> Si = new ArrayList<Integer>();

    
    static void Input() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){

            int inVal = Integer.parseInt(st.nextToken());

            if(Si.isEmpty() || Si.get(Si.size() - 1) < inVal) Si.add(inVal);

            else Si.set(BS(inVal, Si), inVal);

        }

        br.close();

    }

    static int BS(int key, ArrayList<Integer> arr) throws IOException{

        int i = 0, j = arr.size();
        int mid = 1;
    
        while(i < j){
    
            mid = (i + j) / 2;
    
            if(arr.get(mid) >= key) j = mid;
            else i = mid + 1;
    
        }
    
        return j;
    
    }

    static void Solution() throws IOException{

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(Si.size() + "\n");


        bw.flush();
        bw.close();

    }

    static void Solve() throws IOException {

        Input();

        Solution();

    }

    public static void main(String[] args) throws IOException{
        
        Solve();

    }
} 