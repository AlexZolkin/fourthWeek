package secondTask;

/**
 * Created by Алексей on 11.03.2017.
 */
public class Factorial {

    /*
    * Calculating factorial
    * */
    public int factorial(int n){
        if(n == 0 || n == 1)
            return 1;
        return n * factorial(n-1);
    }
}
