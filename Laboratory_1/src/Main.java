import java.lang.module.FindException;
 //x on [-1, 1.5]
public class Main {
    public static void main(String[] args){
        dih(-1, 1.5, 0.0000003);
    }

    public static void dih(double a, double b, double e){
        double ak = a;
        double bk = b;
        double xc = 0;
        double x1 = 0;
        double x2 = 0;
        int k = 0;
        while (Math.abs(ak - bk) > e){
            xc = (ak+bk)/2;
            x1 = xc - e/2;
            x2 = xc + e/2;
            if (Function.function(x1) > Function.function(x2)){
                ak = x2;
            }
            else bk = x1;
            k += 2;
        }
        System.out.println("Метод дихотомии: \n");
        System.out.println("Минимум: " + Math.abs((ak+bk))/2 + " Eps: " + Math.abs(a-b)/2 + " Число вычислений: " + k + '\n');
    }

}
