package BeakJun_example.Math;

import java.io.*;
import java.util.ArrayList;


public class Bertrand {
    static ArrayList<Integer> N = new ArrayList<Integer>();
    static ArrayList<Boolean> primeNum;
    static ArrayList<Integer> result = new ArrayList<Integer>();

    static void Input() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int i = 0, max = 0;
        N.add(-1);

        while(N.get(i) != 0){

            N.add(Integer.parseInt(br.readLine()));
            i++;
            max = Math.max(max, N.get(i));

        }

        primeNum = new ArrayList<Boolean>(max + 1);

        N.remove(i);

    }

    static void Eratosfunc(int n){

        if(n <= 1) return;

        primeNum.add(false);
        primeNum.add(false);

        for(int i = 2; i <= n; i++){

            primeNum.add(true);

        }

        for(int i = 2; i * i <= n; i++){
            
            if(primeNum.get(i))
                for(int j = i * i; j <= n; j += i)
                    primeNum.set(j, false);

        }

    }

    static void Solution() throws IOException{

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 1; i < N.size(); i++)
            result.add(0);

        for(int i = 1; i < N.size(); i++){

            Eratosfunc(2 * N.get(i));

            for (int j = N.get(i) + 1; j <= 2 * N.get(i); j++) {

                if (primeNum.get(j))
                    result.set(i - 1, result.get(i - 1) + 1);

            }

            primeNum.clear();

        }

        for(int i : result)
            bw.write(i + "\n");

    
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

