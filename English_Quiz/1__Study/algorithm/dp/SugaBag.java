// Default Value : MN[3] = 1, MN[5] = 1 -> Using memoization DP !!!

package algorithm.dp;
import java.util.Scanner;

public class SugaBag {
    static int N_MAX = 5001;
    static int N, result;
    static int []MN = new int[N_MAX];  // MinNumber, Memoization

    static int min(int a, int b) { if( (char)a < (char)b ) return a; return b; }

    static void Input(){

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        sc.close();

        MN[0] = 0;
        MN[1] = -1;
        MN[2] = -1;
        MN[3] = 1;
        MN[4] = -1;
        MN[5] = 1;
    }

    static void Solution() {
        
        for(int i = 6; i <= N; i++){

            if((MN[i - 3] == -1) && (MN[i - 5] == -1)) { MN[i] = -1; continue; }
            MN[i] = min(MN[i - 3], MN[i - 5]) + 1;

        }

        result = MN[N];

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
