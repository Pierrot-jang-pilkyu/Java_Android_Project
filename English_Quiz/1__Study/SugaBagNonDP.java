import java.util.Scanner;

public class SugaBagNonDP {
    public static void main(String[] args) {
        int n, count = 0;

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        while(true){
            if(n < 0) {
                System.out.println(-1);
                return;
            }
            if(n % 5 == 0){
                count = n / 5;
                break;
            }
            n -= 3;
            count++;
        }
        System.out.println(count);

        sc.close();
         
    }
}
