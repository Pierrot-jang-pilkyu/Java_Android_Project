package algorithm.bruteforce;
import java.util.Scanner;

public class Main {
    static int count = 0;


    static int hansu(int n){
        int first = 0;
        int second = 0;
        int third = 0;
        for(int i = 1; i <= n; i++){
            first = i / 100;
            second = (i % 100) / 10;
            third = i % 10;
            if(first == 0){
                count++;
            }
            else if((first - second) == (second - third))
                count++;
        }
        return count;
    }
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        sc.close();

        System.out.println(hansu(n));
    }
}
