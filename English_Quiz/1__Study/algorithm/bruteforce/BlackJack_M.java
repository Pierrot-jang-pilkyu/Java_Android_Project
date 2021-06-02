package algorithm.bruteforce;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BlackJack_M {
    static int N, M;
    static int []card_key;
    static HashMap<Integer, Integer> Cards = new HashMap<Integer, Integer>();
    static HashSet<Integer> result = new HashSet<Integer>();
    
    static void Input() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st1 = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st1.nextToken());

        M = Integer.parseInt(st1.nextToken());

        card_key = new int[N + 1];

        st1 = new StringTokenizer(br.readLine());

        for(int i = 1; i <= N; i++){

            card_key[i] = Integer.parseInt(st1.nextToken());

            Cards.put(card_key[i], 0);
    
        }

        br.close();

    }

    static void BlackJack(int n, int  add){

        if(add > M) return;
        if(n > 3){
            result.add(add);
            return;
        }

        int temp = add;

        for(int i = 1; i <= N; i++){

            if(Cards.get(card_key[i]) == 0){

                add += card_key[i];

                Cards.put(card_key[i], 1);

                BlackJack(n + 1, add);

                Cards.put(card_key[i], 0);

                add = temp;

            }
            
        }
    }

    static void Solution() throws IOException{

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        BlackJack(1, 0);

        ArrayList<Integer> temp = new ArrayList<Integer>(result);

        temp.sort(Comparator.naturalOrder());

        bw.write(temp.get(temp.size() - 1) + "\n");

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
