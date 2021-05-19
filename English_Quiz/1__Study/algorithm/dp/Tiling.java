package algorithm.dp;
import java.util.Scanner;


public class Tiling {
    static int N_MAX = 1001;
    static int N, result;
    static int []caseNum = new int[N_MAX];

    static void Input(){
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();

        sc.close();

        caseNum[0] = 0;
        caseNum[1] = 1;
        caseNum[2] = 2;
    }

    static void Solution() {

        for(int i = 3; i <= N; i++){

<<<<<<< HEAD
            caseNum[i] = ((caseNum[i - 1] + caseNum[i - 2]) % 10007);
=======
            caseNum[i] = caseNum[i - 1] + caseNum[i - 2];
>>>>>>> 5419b64f74f752cc97cc68dc1a64efe1f52f6798

        }
        result = caseNum[N];

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