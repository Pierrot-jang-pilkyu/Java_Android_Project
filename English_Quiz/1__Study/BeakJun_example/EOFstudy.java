package BeakJun_example;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class EOFstudy {
    static ArrayList<Integer> A = new ArrayList<Integer>();
    static ArrayList<Integer> B = new ArrayList<Integer>();
    static int []SQ;

    static void Input() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;

        while((input = br.readLine()) != null){

            StringTokenizer st = new StringTokenizer(input);

            A.add(Integer.parseInt(st.nextToken()));
            B.add(Integer.parseInt(st.nextToken()));

        }

        br.close();

    }

    static void Solution() throws IOException{

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        Iterator<Integer> iterA = A.iterator();
        Iterator<Integer> iterB = B.iterator();

        while(iterA.hasNext() && iterB.hasNext()){

            bw.write(iterA.next() + iterB.next() + "\n");

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
