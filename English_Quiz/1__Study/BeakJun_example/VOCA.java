package BeakJun_example;

import java.io.*;
import java.util.HashMap;

public class VOCA {
    static HashMap<Integer,Integer> cp = new HashMap<Integer,Integer>();
    static int N_MAX = 100 + 1;
    static int N;
    static String []VOCA = new String[N_MAX];
    static int result = 0;

    static void Input() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());

        for(int i = 1; i <= N; i++){

            VOCA[i] = br.readLine();

        }

        br.close();

    }

    static void Solution() throws IOException{

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int compareSize, nonGV = 0;
        
        for(int i = 1; i <= N; i++){

            for(int j = 0; j < VOCA[i].length(); j++){

                compareSize = cp.size();

                for(int k = 97; k <= 122; k++){

                    if(VOCA[i].charAt(j) == ((char) k)) cp.put(k, j);

                }

                if((cp.size() == compareSize) && (j != 0)){     // duplicate check

                    if(VOCA[i].charAt(j) != VOCA[i].charAt(j - 1)){
                        
                        nonGV++;
                        break;

                    }
                }
            }

            for(int k = 97; k <= 122; k++){

                if(cp.containsKey(k)) cp.remove(k);
                
            }

        }

        result = N - nonGV;
        

        bw.write(result + "\n");

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
