import static java.lang.Math.sqrt;

//x on [-1, 1.5]
public class Main {
    public static void main(String[] args){

        dih(-1, 1.5, 0.00000003);

        fib_method(-1, 1.5, 0.00000003);

        GoldenSection(-1, 1.5, 0.00000003);
    }

    public static void dih(double a, double b, double e){

        double xc;
        double x1;
        double x2;
        int k = 0;
        while (Math.abs(a - b) > e){
            xc = (a+b)/2;
            x1 = xc - e/2;
            x2 = xc + e/2;
            if (Function.function(x1) > Function.function(x2)){
                a = x2;
            }
            else b = x1;
            k += 2;
        }
        System.out.println("Метод дихотомии: \n");
        System.out.println("Минимум: " + Math.abs((a+b))/2 + " Число вычислений: " + k + '\n');
    }

    public static void fib_method(double a, double b, double eps){

        int n = 0;
        while ((b - a)/eps > Fibonacci.fibonacci(n+2)){
            n++;
        }
        double x1 = a + (double) Fibonacci.fibonacci(n - 2) * (b-a) /Fibonacci.fibonacci(n);
        double x2 = a + (double) Fibonacci.fibonacci(n - 1) * (b-a) /Fibonacci.fibonacci(n);
        int iterations = n+2;
        double y1 = Function.function(x1);
        double y2 = Function.function(x2);

        //Основной этап
        while (n >= 2){
            n--;
            if(y1 > y2){
                a = x1;
                x1 = x2;
                y1 = y2;
                x2 = a + (double) Fibonacci.fibonacci(n - 1) * (b-a) /Fibonacci.fibonacci(n);
                y2 = Function.function(x2);
            }
            else{
                b = x2;
                x2 = x1;
                y2 = y1;
                x1 = a + (double) Fibonacci.fibonacci(n - 2) * (b-a) /Fibonacci.fibonacci(n);
                y1 = Function.function(x1);
            }

        }
        System.out.println("Метод Фибоначчи: \n");
        System.out.println("Минимум: " + Math.abs((a+b))/2 +  " Число вычислений: " + iterations + '\n');
    }

     public static void GoldenSection(double a, double b, double eps)
     {
         double x1 =a+(b-a)*(3-sqrt(5))/2, x2 =a+(b-a)*(sqrt(5)-1)/2;
         double y1 = Function.function(x1);
         double y2 = Function.function(x2);
         int iterations = 2;
         while(b-a > eps)
         {
             if(y1<=y2)
             {
                 b = x2;
                 x2 = x1;
                 y2 = y1;
                 x1 = a +(b-a)*(3-sqrt(5))/2;
                 y1 = Function.function(x1);
             }
             else
             {
                 a = x1;
                 x1 = x2;
                 y1 = y2;
                 x2 = a+(b-a)*(sqrt(5)-1)/2;
                 y2 = Function.function(x2);
             }
             ++iterations;
         }
         System.out.println("Метод Золотого сечения: \n");
         System.out.println("Минимум: " + Math.abs((a+b))/2 +  " Число вычислений: " + iterations + '\n');
     }
}
