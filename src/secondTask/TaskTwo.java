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
    * every item +=2
    * */
    public int bunnyEars(int bunnies){
        if(bunnies == 0)
            return 0;
        if (bunnies == 1)
            return 2;
        return 2 + bunnyEars(bunnies - 1);
    }

    /*
    * every time += parameter
    * */
    public int triangle(int rows){
        if(rows == 0)
            return 0;
        if (rows == 1)
            return 1;
        return rows + triangle(rows - 1);
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
    * Count how many digits "8"
    * are there in number given
    * */
    public int count8(int n){
        if(n == 0)
            return 0;
        if(n % 100 == 88)
            return 2 + count8(n / 10);
        if(n % 10 == 8)
            return 1 + count8(n / 10);
        return count8(n / 10);
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
    * Removes "x"
    * from the string given
    * */
    public String noX(String str){
        if(str.length() == 0)
            return "";
        if (str.length() == 1 && str.equals("x"))
            return "";
        else if(str.length() == 1)
            return str;
        return str.charAt(0) == 'x' ? noX(str.substring(1)) :
                str.charAt(0) + noX(str.substring(1));
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
    * Found in the array given such pairs
    * x -> x*10
    * returns boolean
    * */
    public boolean array220(int[] nums, int index){
        if(index == nums.length - 1 || nums.length == 0)
            return false;
        return nums[index] * 10 == nums[index + 1] ? true : array220(nums, index + 1);
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

    /*
    * Count number of "abc" and "aba"
    * substrings in string given
    * */
    public int countAbc(String str){
        if(str.length() < 3)
            return 0;
        if(str.substring(0, 3).equals("aba"))
            return 1 + countAbc(str.substring(2));
        if(str.substring(0, 3).equals("abc"))
            return 1 + countAbc(str.substring(3));
        return countAbc(str.substring(1));
    }

    /*
    * count number of "hi"
    * */
    public int countHi(String str){
        if(str.length() == 2 && str.equals("hi"))
            return 1;
        if(str.length() <= 2)
            return 0;
        if(str.substring(0, 2).equals("hi"))
            return 1 + countHi2(str.substring(2));
        return countHi2(str.substring(1));
    }

    /*
    * Count "hi"
    * but not "xhi"
    * in string given
    * */
    public int countHi2(String str){
        if(str.length() == 2 && str.equals("hi"))
            return 1;
        if(str.length() <= 2)
            return 0;
        if(str.substring(0, 3).equals("xhi"))
            return countHi2(str.substring(3));
        if(str.substring(0, 2).equals("hi"))
            return 1 + countHi2(str.substring(2));
        if(str.substring(1, 3).equals("hi"))
            return 1 + countHi2(str.substring(3));
        return countHi2(str.substring(1));
    }

    /*
    * Count number of sub strings
    * in string given
    * */
    public int strCount(String str, String sub){
        if(str.length() < sub.length())
            return 0;
        if (str.substring(0, sub.length()).equals(sub))
            return 1 + strCount(str.substring(sub.length()), sub);
        return strCount(str.substring(1), sub);
    }

}
