import java.io.BufferedReader;          // 1 line InputStream
import java.io.InputStream;             // 1 byte integer type InputStream
import java.io.InputStreamReader;       // 1 byte character type InputStream

import java.util.Scanner;

public class StreamTest {
    public static void main(String[] args) throws Exception {

        InputStream in = System.in;
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);

        String a = br.readLine();
        System.out.println(a);

        Scanner sc = new Scanner(System.in);

        int []test = new int[10];

        for(int i = 0; i < 10; i++){
            test[i] = sc.nextInt();
        }

        sc.close();

        for(int i = 0; i < 10; i++){
            System.out.println("test[" + i + "] : " + test[i]);
        }
    }
}