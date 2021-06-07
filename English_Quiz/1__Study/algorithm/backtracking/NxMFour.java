package algorithm.backtracking;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class NxMFour {
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

            boolean naturalOrder = true;

            for(int i = 0; i < result.size() - 1; i++){

                if(result.get(i) > result.get(i + 1)) {

                    naturalOrder = false;
                    break;

                }
                
            }

            if(naturalOrder){

                for(int i : result)
                    bw.write(i + " ");
                bw.newLine();

            }

            return;

        }

        for(int i = 1; i <= N; i++){

            result.add(i);
            NxMsequence(m - 1);
            result.remove(result.size() - 1);

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