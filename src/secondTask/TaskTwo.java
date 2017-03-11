package secondTask;

/**
 * Created by Алексей on 11.03.2017.
 */
public class TaskTwo {

    /*
    * Calculating factorial
    * */
    public int factorial(int n){
        if(n == 0 || n == 1)
            return 1;
        return n * factorial(n-1);
    }

    /*
    * even -> +=3
    * odd -> +=2
    * return total of a row
    * */
    public int bunnyEars2(int bunnies) {
        if(bunnies == 0) return 0;
        return bunnies % 2 == 0 ? 3 + bunnyEars2(bunnies - 1) : 2 + bunnyEars2(bunnies - 1);
    }

    /*
    * Count how many digits "7"
    * are there in number given
    * */
    public int count7(int n){
        if(n == 0) return 0;
        return n % 10 == 7 ? 1 + count7(n / 10) : count7(n / 10);
    }

    /*
    * Count number of occupancy's of "x"
    * in string given
    * */
    public int countX(String str) {
        if (str.length() == 0) return 0;
        return str.toLowerCase().charAt(str.length() - 1) == 'x' ? 1 + countX(str.substring(0,str.length() - 1)) :
                countX(str.substring(0,str.length() - 1));
    }


}
