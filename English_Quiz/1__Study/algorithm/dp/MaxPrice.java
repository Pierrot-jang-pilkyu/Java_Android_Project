// BeakJun No. 14501.

package algorithm.dp;

import java.util.Scanner;

public class MaxPrice {
    static int N_MAX = 15 + 1;
    static int N, result;
    static int []T = new int[N_MAX];
    static int []P = new int[N_MAX];
    static int []MP = new int[N_MAX];

    static void Input(){

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        for(int i = 1; i <= N; i++){

            T[i] = sc.nextInt();
            P[i] = sc.nextInt();

        }

        sc.close();

    }

    static int max(int a, int b) { if( a > b) return a; return b; }

    static int Scheduled(int i){

        if(i == N + 1) return 0;
        if(i > N + 1) return -987654321;

        if(MP[i] != 0) return MP[i];

        return MP[i] = max(Scheduled(i + 1), Scheduled(i + T[i]) + P[i]);

    }

    static void Solution(){

        result = Scheduled(1);

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

