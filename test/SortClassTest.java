import fourthTask.SortClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;

/**
 * Created by Алексей on 14.03.2017.
 */
public class SortClassTest implements Comparator<Object>{
    SortClass sc = new SortClass();
    Integer[] arr, sarr, iarr;
    String[] lines, slines, ilines;
    @Before
    public void setUp(){
        arr = new Integer[] {3, 6, 4, 11, 1, 0, 2};
        sarr = new Integer[] {0, 1, 2, 3, 4, 6, 11};
        iarr = new Integer[] {11, 6, 4, 3, 2, 1, 0};
        lines = new String[] {"ZZ", "a", "FFe"};
        slines = new String[] {"a", "FFe", "ZZ"};
        ilines = new String[] {"ZZ", "FFe", "a"};
    }
    @Test
    public void testQuick(){
        Assert.assertArrayEquals(iarr, sc.quickSort(arr, this));
        Assert.assertArrayEquals(sarr, sc.quickSort(arr));
    }
    @Test
    public void testMerge(){
        Assert.assertArrayEquals(iarr, sc.mergeSort(arr, this));
        Assert.assertArrayEquals(sarr, sc.mergeSort(arr));
    }
    @Override
    public int compare(Object a, Object b) {
        if((Integer)a - (Integer)b == 0)
            return 0;
        if((Integer)a - (Integer)b > 0)
            return -1;
        return 1;
    }
}
