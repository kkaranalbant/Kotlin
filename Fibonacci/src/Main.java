import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        long start = System.nanoTime() ;
        normalFibonacci(46) ;
        long finish = System.nanoTime() ;
        System.out.println(finish - start);
        start = System.nanoTime() ;
        fibonacciMemoization(46 , new HashMap<>()) ;
        finish = System.nanoTime() ;
        System.out.println(finish - start);
    }

    private static int fibonacciMemoization (int n , Map<Integer , Integer> memory) {
        if (n <= 1) {
            return n ;
        }
        if (memory.containsKey(n)) {
            return memory.get(n) ;
        }
        memory.put(n , fibonacciMemoization(n - 1 , memory) + fibonacciMemoization(n - 2 , memory)) ;
        return memory.get(n) ;
    }

    private static int normalFibonacci (int n) {
        if (n <= 1) return n ;
        return normalFibonacci(n-1) + normalFibonacci(n-2) ;
    }
}