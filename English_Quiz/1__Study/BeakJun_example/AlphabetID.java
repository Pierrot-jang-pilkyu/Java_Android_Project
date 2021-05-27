package BeakJun_example;

import java.io.*;
import java.util.HashMap;

public class AlphabetID {
    static HashMap<Integer, Integer> result = new HashMap<Integer,Integer>();
    static String in;
    static char cp;

    static void Input() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        in = br.readLine();

        br.close();

        for(int i = 97; i <= 122; i++){

            result.put(i, -1);
        }

    }

    static void Solution() throws IOException{

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 97; i <= 122; i++){

            cp = (char)i;

            for(int j = 0; j < in.length(); j++){

                if(cp == in.charAt(j) && (result.get((int)cp) == -1))
                    result.put((int)cp, j);

            }

        }

        for(int i = 97; i <= 122; i++){

            bw.write(result.get(i) + " ");
            
        }bw.newLine();

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
