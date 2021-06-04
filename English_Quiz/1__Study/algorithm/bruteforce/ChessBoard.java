package algorithm.bruteforce;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;


public class ChessBoard {
    static int NM_MAX = 50 + 1;
    static int N, M;
    static String W_Line = "WBWBWBWB";
    static String B_Line = "BWBWBWBW";
    static ArrayList<String> NxM = new ArrayList<String>();
    static ArrayList<Integer> result = new ArrayList<Integer>();
    
    static void Input() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= N; i++){

            NxM.add(br.readLine());

        }

        br.close();

    }

    static int check(int i, int j){

        int count_B = 0, count_W = 0, _i = i, _j = j;;

        for(; i < _i + 8; i++){
            
            int k = 0;

            for(; j < _j + 8; j++){

                for(int color = 0; color < 2; color++){ // color == 0 -> B_Board, color == 1 -> W_Board

                    if(color == 0 && (i % 2) == (_i % 2) || color == 1 && (i % 2) != (_i % 2)){
    
                        if(NxM.get(i).charAt(j) == B_Line.charAt(k));
                        else if(NxM.get(i).charAt(j) != B_Line.charAt(k)) {
                            if(color == 0) count_B++;
                            else if(color == 1) count_W++;
                        }
                        
                    }
                    else if(color == 0 && (i % 2) != (_i % 2) || color == 1 && (i % 2) == (_i % 2)){
    
                        if(NxM.get(i).charAt(j) == W_Line.charAt(k));
                        else if(NxM.get(i).charAt(j) != W_Line.charAt(k)) {
                            if(color == 0) count_B++;
                            else if(color == 1) count_W++;
                        }
    
                    }

                }


                k++;

            }
            
            j = _j;
            
        }

        return Math.min(count_B, count_W);

    }

    static void Solution() throws IOException{

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 0; i < N - 7; i++){

            for(int j = 0; j < M - 7; j++){

                result.add(check(i, j));

            }
        }

        result.sort(Comparator.naturalOrder());

        bw.write(result.get(0) + "\n");

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

