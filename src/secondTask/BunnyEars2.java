package secondTask;

/**
 * Created by Алексей on 11.03.2017.
 */
public class BunnyEars2 {

    /*
    * even -> +=3
    * odd -> +=2
    * return total of a row
    * */
    public int bunnyEars2(int bunnies) {
        if(bunnies == 0) return 0;
        return bunnies % 2 == 0 ? 3 + bunnyEars2(bunnies - 1) : 2 + bunnyEars2(bunnies - 1);
    }

}
