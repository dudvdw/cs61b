package examprep;

public class SkipFibonacci {

    public static int skipFib(int n) {
        if (n == 0){
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        } else {
            return skipFib(n-3) + skipFib(n-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(skipFib(10));
    }
}
