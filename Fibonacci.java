import java.util.ArrayList;

public class Fibonacci {

    ArrayList<Long> cache;

    Fibonacci(int n) {
        cache = new ArrayList<>(n+1);
        cache.add(0,0L);
        cache.add(1,1L);
        cache.add(2,1L);
    }

    // O(2^n)
    long fibRecursiveWithCache(int n) {
        if( n == 1 || n == 2)
            return 1;

        if( cache.size() > n)
            return cache.get(n);

        long fibNMinusOne = fibRecursiveWithCache(n-1);

        long fibNMinusTwo = fibRecursiveWithCache(n-2);

        long res = fibNMinusOne + fibNMinusTwo;

        cache.add((n),res);

        return res;
    }

    long fibRecursive(int n) {
        if( n == 1 || n == 2)
            return 1;
        return fibRecursive(n-1) + fibRecursive(n-2);
    }

    double fibIterative(int n) {
        if(n == 1 || n == 2) return 1;
        double f1 = 1, f2 = 1, fibResult = 0;
        for(int i = 3; i <= n; i++) {
            fibResult = f1 + f2;
            f1 = f2;
            f2 = fibResult;
        }

        return fibResult;
    }

    public static void main(String[] args) {
        int N = 100;

//        long startTime = System.nanoTime();
//        long nThFib = FibRecursive(N);
//        long nThFib =FibIterative(N);
//        long endTime = System.nanoTime();
//
//        System.out.print("Time for Recursive func to finish: " + (endTime-startTime));

        Fibonacci fib = new Fibonacci(N);
        for(int i = 1; i < 100; i++) {
            System.out.print(fib.fibIterative(i) + "\t");
        }
    }
}
