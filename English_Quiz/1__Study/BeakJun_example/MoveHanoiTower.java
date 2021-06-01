package BeakJun_example;

import java.io.*;
import java.util.ArrayList;

public class MoveHanoiTower {
    static int N, count = 0;
    static ArrayList<String> result = new ArrayList<String>();
    
    static void Input() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        br.close();

    }

    static void hanoi(int n, int source, int other, int destination){

        if(n == 0) return;
        
        
        // Leave out the biggest circular panel. Recursive others panel in hanoi funtion.
        hanoi(n - 1, source, destination, other);
        // Output moving the biggesr circular panel of remaining panels from source to destination.
        count++;
        result.add(Integer.toString(source) + " " + Integer.toString(destination) + "\n");
        // Move others panel to destination.
        hanoi(n - 1, other, source, destination);       
        
    }

    static void Solution() throws IOException{

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        hanoi(N, 1, 2, 3);

        bw.write(count + "\n");

        for(String _print : result){
            bw.write(_print + "");
        }

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
