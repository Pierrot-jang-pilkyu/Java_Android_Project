package algorithm.bruteforce;

import java.io.*;
import java.util.StringTokenizer;

public class CompareBodyArray {
    static int N_MAX = 50 + 1;
    static int N;
    static int [][]result = new int[N_MAX][3];
    
    static void Input() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for(int i = 1; i <= N; i++){

            StringTokenizer st = new StringTokenizer(br.readLine());

            result[i][0] = Integer.parseInt(st.nextToken());
            result[i][1] = Integer.parseInt(st.nextToken());
            result[i][2] = 1;

        }

        br.close();

    }

    static void Solution() throws IOException{

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 1; i <= N; i++){

            for(int j = 1; j <= N; j++){
    
                if(i != j){
                    int count = 0;
    
                    if (result[i][0] > result[j][0])
                        count++;
                    if (result[i][1] > result[j][1])
                        count++;
                    if (result[i][0] == result[j][0] || result[i][1] == result[j][1])
                        count = 1;
    
                    result[i][2] += count == 0 ? 1 : count == 1 ? 0 : 0;
    
                }
            }
        }

        for(int i = 1; i <= N; i++){

            bw.write(result[i][2] + " ");
            
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


