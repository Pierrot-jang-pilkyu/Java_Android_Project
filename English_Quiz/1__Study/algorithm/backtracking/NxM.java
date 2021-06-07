package algorithm.backtracking;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class NxM {
    static int N, M;
    static ArrayList<Integer> result = new ArrayList<Integer>();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    static void Input() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(st.nextToken());

        br.close();

    }

    static void NxMsequence(int m) throws IOException{

        if(m < 1) {
            
            for(int i : result)
                bw.write(i + " ");
            bw.newLine();

            return;

        }

        for(int i = 1; i <= N; i++){

            boolean promising = true;

            for(int j = 0; j < result.size(); j++){

                if(result.get(j) == i){

                    promising = false;
                    break;

                }

            }

            if(promising){

                result.add(i);
                NxMsequence(m - 1);
                result.remove(result.size() - 1);

            }

        }

    }

    

    static void Solution() throws IOException{

        NxMsequence(M);

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