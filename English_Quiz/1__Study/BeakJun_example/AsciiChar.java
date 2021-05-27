package BeakJun_example;

import java.io.*;

public class AsciiChar{
    
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String in = br.readLine();
        br.close();
        
        bw.write(((int) in.charAt(0)) + "\n");
        bw.flush();
        bw.close();
    }
}