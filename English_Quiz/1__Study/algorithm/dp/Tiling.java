package algorithm.dp;
import java.util.Scanner;


public class Tiling {
    int n;
    int []caseNum = new int[1001];

    int tiling(int n) {
        if(n == 1) return caseNum[n] = 1;
        if(n == 2) return caseNum[n] = 2;

        if(caseNum[n] != 0) return caseNum[n];

        return caseNum[n] = ((tiling(n - 1) + tiling(n - 2)) % 10007);
    }

    public static void main(String[] args) {
        Tiling t = new Tiling();

        Scanner sc = new Scanner(System.in);
        t.n = sc.nextInt();
        
        System.out.println(t.tiling(t.n));
        
        sc.close();
    }
}