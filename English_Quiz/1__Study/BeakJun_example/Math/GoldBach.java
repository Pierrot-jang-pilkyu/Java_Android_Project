package BeakJun_example.Math;

import java.io.*;
import java.util.ArrayList;


public class GoldBach { 
    static int T;
    static ArrayList<Integer> N = new ArrayList<Integer>();
    static boolean []primeArray;
    static ArrayList<Integer> primeNumber = new ArrayList<Integer>();
    static String []result;

    static void Input() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        N.add(-1);
        int max = 0;

        result = new String[T + 1];

        for(int i = 1; i <= T; i++){

            N.add(Integer.parseInt(br.readLine()));
            max = Math.max(max, N.get(i));

        }

        primeArray = new boolean[10001];

        br.close();

    }

    static void Eratosfunc(int n){

        if(n <= 1) return;

        for(int i = 0; i < 2; i++){

            primeArray[i] = false;

        }

        for(int i = 2; i <= n; i++){

            primeArray[i] = true;

        }

        for(int i = 2; i * i <= n; i++){
            
            if(primeArray[i])
                for(int j = i * i; j <= n; j += i)
                    primeArray[j] = false;

        }

    }

    static void Solution() throws IOException{

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = 10000;

        Eratosfunc(n);

        for(int i = 1; i <= T; i++){

            for(int j = N.get(i) / 2; j > 1; j--){

                if(primeArray[j] && primeArray[N.get(i) - j]){
                  // 해당 짝수를 만들기 위해 최선은 반에서 같은 거리에 있는 소수들의 합이다.

                    bw.write(j + " " + (N.get(i) - j) + "\n");
                    break;

                }

            }
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

