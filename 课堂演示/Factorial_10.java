public class Factorial_10 {
    public static void main(String[] args) {
        long result = fun(10);
        System.out.println(result);
    }
    public static long fun(long n){
        if (n==1){
            return 1;
        }
        return n*fun(n-1);
    }
}
