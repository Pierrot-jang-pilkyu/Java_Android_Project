package algorithm.backtracking;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Sudoku {
    static int [][]sudoku = new int[9][9];
    static int last_print = 0;
    static ArrayList<Node> blank_Num = new ArrayList<Node>();
    static ArrayList<String> result = new ArrayList<String>();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static class Node {
        public int x = 0;
        public int y = 0;

        Node(int _x, int _y){

            x = _x;
            y = _y;

        }
    }
    
    static void Input() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 9; i++){
            
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 0; j < 9; j++){

                sudoku[i][j] = Integer.parseInt(st.nextToken());

                if(sudoku[i][j] == 0)
                    blank_Num.add(new Node(i, j));

            }

        }


        br.close();

    }

    static boolean promising(int row, int column){

        for(int i = 0; i < 9 ; i++){    // check this row

            if(i != column)
                if(sudoku[row][i] == sudoku[row][column])
                    return false;
                
        }

        for(int i = 0; i < 9 ; i++){    // check this column

            if(i != row)
                if(sudoku[i][column] == sudoku[row][column])
                    return false;

        }

        // check 3X3 matrix of 9 pieces 

        int first_3 = (row / 3) * 3;
        int second_3 = (column / 3) * 3;

        for(int i = first_3; i < first_3 + 3; i++){

            for(int j = second_3; j < second_3 + 3; j++){

                if(i != row || j != column)
                    if(sudoku[i][j] == sudoku[row][column])
                        return false;

            }

        }

        return true;

    }

    static void sudokuComplete(int zero_index) throws IOException{

        
        if(zero_index == blank_Num.size()) { sudokuResult(); return; }
        
        Node tempNode = blank_Num.get(zero_index);
        int x = tempNode.x;
        int y = tempNode.y;
        
        for (int i = 1; i <= 9; i++) {

            if (sudoku[x][y] == 0){

                sudoku[x][y] = i;
    
                if (promising(x, y)) 
                    sudokuComplete(zero_index + 1);
    
                sudoku[x][y] = 0;

            }

        }

        

    }

    static void sudokuResult(){

        String temp = "";

        for(int i = 0; i < 9; i++){

            for(int j = 0; j < 9; j++){

                temp += Integer.toString(sudoku[i][j]) + " ";

            }

            temp += "\n";

        }

        result.add(temp);

        last_print = result.size();

    }

    static void printer() throws IOException{

        if(last_print == result.size())
            bw.write(result.get(0));
        else bw.write("Don't exist sudoku.\n");

    }

    

    static void Solution() throws IOException{

        sudokuComplete(0);

        printer();

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