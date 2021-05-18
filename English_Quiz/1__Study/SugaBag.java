import java.util.Scanner;

class Pair<T1, T2> {
    private T1 first;
    private T2 second;

    public Pair(T1 f, T2 s){
        this.first = f;
        this.second = s;
    }

    public void set(T1 f, T2 s){
        this.first = f;
        this.second = s;
    }

    public T1 getfirst(){
        return this.first;
    }

    public T2 getsecond(){
        return this.second;
    }
}

public class SugaBag {
    static int result = 0;

    static void choice(Pair<Integer, Integer> n){
        if(result == 0){
            if(n.getfirst() < 3){
                if(n.getfirst() == 2) return;
                if(n.getfirst() == 1) return;
                if(n.getfirst() == 0){
                    result = n.getsecond();
                }
                if(n.getfirst() < 0) return;
            }
            else{
                Pair<Integer, Integer> temp = new Pair<>(0 ,0);
                temp.set(n.getfirst(), n.getsecond());

                n.set(n.getfirst() - 5, n.getsecond() + 1);
                choice(n);

                n.set(temp.getfirst() - 3, temp.getsecond() + 1);
                choice(n);
            }

        }
    }

    public static void main(String[] args) {

        
        Pair<Integer, Integer> n = new Pair<>(0 ,0);
        
        Scanner sc = new Scanner(System.in);

        n.set(sc.nextInt(), n.getsecond());

        choice(n);

        if(result == 0) System.out.println(-1);
        else System.out.println(result);

        sc.close();
        
    }
}
