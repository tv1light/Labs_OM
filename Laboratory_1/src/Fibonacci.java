
// 0  1  1   2 3 5 8
// n1 n2 temp

// 0  1  1  2   3 5 8 13 21 34 55
//    n1 n2 temp

public class Fibonacci {
    // any reasons to use recursion?
    public static int fibonacci(int n){
        int n1 = 0;
        int n2 = 1;
        int temp = 0;

        while (n-1 != 0){
            temp = n1 + n2;
            n1 = n2;
            n2 = temp;
            --n;
        }
        return n1;
    }
}
