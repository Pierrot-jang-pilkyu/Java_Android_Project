package BeakJun_example;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CroatiaAlphabet {
    static ArrayList<String> check = new ArrayList<String>();
    static String []cp = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
    static int result = 0;

    static void Input() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        while(st.hasMoreTokens()) check.add(st.nextToken());

        br.close();

    }

    static void Solution() throws IOException{

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        result = check.get(0).length();
        
        int i, bp = 0;

        check.set(0, " " + check.get(0));       // when input data is  a or b or l etc one character, error. so fix it.

        for(i = 0; i < check.get(0).length() - 2; i++){

            for(int j = 0; j < 8; j++){

                if(check.get(0).substring(i, i + 2).compareToIgnoreCase(cp[j]) == 0) { 
                    result -= 1; 
                    i++;
                    if(check.get(0).length() - i == 1) bp = 1;
                    break;
                }
                else if(check.get(0).substring(i, i + 3).compareToIgnoreCase(cp[j]) == 0) {
                    result -= 2;
                    i += 2;
                    if(check.get(0).length() - i == 1) bp = 2;
                    break; 
                }
                
            }
            if(bp != 0) break;

        }

        if((check.get(0).length() - i == 0)) i -= 2;
        else if(check.get(0).length() - i == 1) i--;

        if(bp != 2) {
            
            for(int j = 0; j < 8; j++){
    
                if(check.get(0).substring(i, i + 2).compareToIgnoreCase(cp[j]) == 0) { result -= 1; break; }
                
            }

        }
        

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
