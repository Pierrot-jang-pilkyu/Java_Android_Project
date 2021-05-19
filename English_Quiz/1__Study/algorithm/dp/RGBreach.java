package algorithm.dp;

import java.util.Scanner;

public class RGBreach {
    static int RED = 1, GREEN = 2, BLUE = 3;

    static int N_MAX = 1001;
    static int N, result;
    static int [][]CC = new int[N_MAX][4];      // ColorCost
    static int [][]MC = new int[N_MAX][4];      // MinCost, Memoization

    static int min(int a, int b) { if( a < b ) return a; return b; }

    static void Init(){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        for(int i = 1; i <= N; i++){
            for(int j = 1; j < 4; j++){
                CC[i][j] = sc.nextInt();
            }
        }

        sc.close();

        for(int i = 0; i < 4; i++){
            CC[0][i] = 0;
            MC[0][i] = 0;
        }
    }

    static void Solution(){

        for(int i = 1; i <= N; i++){
            // Default Value : CC[0][1] = CC[0][2] = CC[0][3] = 0, MC[0][1] = MC[0][2] = MC[0][3] = 0
            MC[i][RED] = min(MC[i - 1][GREEN], MC[i - 1][BLUE]) + CC[i][RED];
            MC[i][GREEN] = min(MC[i - 1][RED], MC[i - 1][BLUE]) + CC[i][GREEN];
            MC[i][BLUE] = min(MC[i - 1][RED], MC[i - 1][GREEN]) + CC[i][BLUE];

        }

        result = min(min(MC[N][RED], MC[N][GREEN]), MC[N][BLUE]);

        System.out.println(result);
    }

    static void Solve(){
        
        Init();

        Solution();
    }

    public static void main(String[] args) {
        
        Solve();

    }
}
