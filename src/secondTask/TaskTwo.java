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

    /*
    * Changes "pi" to "3.14" in string given
    * */
    public String changePi(String str){
        String res = str;
        if(str.indexOf("pi") != -1)
            res = str.substring(0,str.indexOf("pi")) + "3.14" + str.substring(str.indexOf("pi") + 2, str.length());
        return str.equals(res) ? res : changePi(res);
    }

    /*
    * Counts number of "11" in array
    * */
    public int array11(int[] nums, int index){
        if(index == nums.length)
            return 0;
        return nums[index] == 11 ? 1 + array11(nums, index + 1) : array11(nums, index + 1);
    }

    /*
    * Separates equal chars in str with "*"
    * */
    public String pairStar(String str){
        if(str.length() == 1 || str.length() == 0)
            return str;
        String res = str.charAt(0) + "";
        if(str.charAt(0) == str.charAt(1))
            res = str.charAt(0) + "*";
        return res + pairStar(str.substring(1));
    }

}
