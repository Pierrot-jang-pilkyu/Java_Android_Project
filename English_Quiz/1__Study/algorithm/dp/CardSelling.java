// BeakJun No. 14501.

package algorithm.dp;

import java.util.Scanner;

public class CardSelling {
    static int N_MAX = 1000 + 1;
    static int N, result;
    static int []P = new int[N_MAX];
    static int []DP = new int[N_MAX];

    static void Input(){

        Scanner sc = new Scanner(System.in);

        /* String temp = sc.nextLine(); // 7
        N = Integer.parseInt(temp); */  // 1 2 3 4 5 6 7 -> input like this nextline() -> read 1 2 3 4 5 6 7

        N = sc.nextInt();
        sc.nextLine();                  // handling N next return in buffer. 

        for(int i = 1; i <= N; i++){

            P[i] = sc.nextInt();

        }sc.nextLine();                 // handling N th price input next return in buffer.

        sc.close();

        for(int i = 1; i <= N; i++){

            DP[i] = P[i];       // initialize.

        }

    }

    static int max(int a, int b) { if( a > b) return a; return b; }

    static void Solution(){

        for(int i = 1; i <= N; i++){

            for(int j = 1; j <= i; j++){

                DP[i] = max(DP[i - j] + P[j], DP[i]);

            }
        }

        result = DP[N];

        System.out.println(result);

    }

    static void Solve(){

        Input();

        Solution();

    }

    public static void main(String[] args) {
        
        Solve();

    }
}
