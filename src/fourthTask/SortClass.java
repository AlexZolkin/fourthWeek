package fourthTask;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

/**
 * Created by Алексей on 12.03.2017.
 */
public class SortClass implements IAlgorithm {

    /*
    * Function for private usage
    * checks type of object given
    * used for correct default comparator work
    * */
    private String checkType(Object obj){
        if(obj instanceof Integer)
            return "Integer";
        else if(obj instanceof String)
            return "String";
        else if(obj instanceof Double)
            return "Double";
        return "Custom";
    }

    /*
    * quickSort realisation
    * non recursive!
    * takes an array and comparator(can be used with default comparator too)
    * */
    @Override
    public Object[] quickSort(Object[] array, Comparator<Object> comparator) {
        int i, j;
        int lb, ub;
        int leftBorderStack[] = new int[2048], upBorderStack[] = new int[2048];
        int stackPosition = 1;
        int poiterBasic;
        Object basic;
        Object temp;
        leftBorderStack[1] = 0;
        upBorderStack[1] = array.length - 1;
        do {
            lb = leftBorderStack[stackPosition];
            ub = upBorderStack[stackPosition];
            stackPosition--;
            do {
                poiterBasic = (lb + ub) >> 1;
                i = lb; j = ub; basic = array[poiterBasic];
                do {
                    if(comparator == null) {
                        while (comparator(array[i], basic)) i++;
                        while (comparator(basic, array[j])) j--;

                    } else{
                        while (comparator.compare(array[i], basic) < 0) i++;
                        while (comparator.compare(basic, array[j]) < 0) j--;
                    }
                    if (i <= j) {
                        temp = array[i];
                        array[i] = array[j];
                        array[j] = temp;
                        i++;
                        j--;
                    }
                } while (i <= j);
                if (i < poiterBasic) {
                    if (i < ub) {
                        stackPosition++;
                        leftBorderStack[stackPosition] = i;
                        upBorderStack[stackPosition] = ub;
                    }
                    ub = j;
                }
                else {
                    if (j > lb) {
                        stackPosition++;
                        leftBorderStack[stackPosition] = lb;
                        upBorderStack[stackPosition] = j;
                    }
                    lb = i;
                }
            } while (lb < ub);
        } while (stackPosition != 0);
        return array;
    }

    /*
    * quickSort override
    * takes a collection and uses default comparator
    * returns sorted array;
    * */
    @Override
    public Object[] quickSort(Collection<Object> collection) {
        Object[] array = collection.toArray();
        return quickSort(array, null);
    }

    /*
    * quickSort override
    * takes an array and uses default comparator
    * returns sorted array;
    * */
    @Override
    public Object[] quickSort(Object[] array) {
        return quickSort(array, null);
    }

    /*
    * quickSort override
    * takes a collection and a custom comparator
    * returns sorted array;
    * */
    @Override
    public Object[] quickSort(Collection<Object> collection, Comparator<Object> comparator) {
        Object[] array = collection.toArray();
        return quickSort(array, comparator);
    }

    /*
    * mergeSort realisation
    * non recursive!
    * takes an array and comparator(can be used with default comparator too)
    * */
    @Override
    public Object[] mergeSort(Object[] array, Comparator<Object> comparator) {
        int len = array.length;
        int n = 1;
        int shift;
        int two_size;
        Object[] arr2;
        while (n < len) {
            shift = 0;
            while (shift < len) {
                if (shift + n >= len) break;
                two_size = (shift + n * 2 > len) ? (len - (shift + n)) : n;
                arr2 = merge(Arrays.copyOfRange(array, shift, shift + n),
                        Arrays.copyOfRange(array, shift + n, shift + n + two_size),
                        comparator);
                for (int i = 0; i < n + two_size; ++i)
                    array[shift + i] = arr2[i]; // замена на отсортированное
                shift += n * 2;
            }
            n *= 2;
        }
        return array;
    }

    /*
    * function for private usage
    * sorts sub arrays
    * used in mergeSort in cycle
    * */
    private Object[] merge(Object[] arr_1, Object[] arr_2, Comparator<Object> comparator) {
        int len_1 = arr_1.length, len_2 = arr_2.length;
        int a = 0, b = 0, len = len_1 + len_2; // a, b - счетчики в массивах
        Object[] result = new Object[len];
        for (int i = 0; i < len; i++) {
            if (b < len_2 && a < len_1) {
                if (comparator == null){
                    if (comparator(arr_2[b], arr_1[a])) result[i] = arr_2[b++];
                    else result[i] = arr_1[a++];
                }else{
                    if (comparator.compare(arr_1[a], arr_2[b]) > 0) result[i] = arr_2[b++];
                    else result[i] = arr_1[a++];
                }

            } else if (b < len_2) {
                result[i] = arr_2[b++];
            } else {
                result[i] = arr_1[a++];
            }
        }
        return result;
    }

    /*
    * margeSort override
    * takes a collection and a custom comparator
    * returns sorted array
    * */
    @Override
    public Object[] mergeSort(Collection<Object> collection, Comparator<Object> comparator) {
        return mergeSort(collection.toArray(), comparator);
    }

    /*
    * margeSort override
    * takes a collection and uses default comparator
    * returns sorted array
    * */
    @Override
    public Object[] mergeSort(Collection<Object> collection) {
        return mergeSort(collection.toArray(), null);
    }

    /*
    * margeSort override
    * takes an array and uses default comparator
    * returns sorted array
    * */
    @Override
    public Object[] mergeSort(Object[] array) {
        return mergeSort(array, null);
    }

    /*
    * function for private usage
    * compares two object with an appropriate
    * default comparator
    * */
    private boolean comparator(Object a, Object b){
        if(checkType(a).equals("String"))
            return stringsComparator(a, b);
        return numbersComparator(a, b);
    }

    /*
    * function for private usage
    * compares two numbers
    * */
    private boolean numbersComparator(Object a, Object b){
        switch (checkType(a)){
            case "Integer":
                return (Integer)a < (Integer) b;
            case "Double":
                return (Double)a < (Double) b;
        }
        return false;
    }

    /*
    * function for private usage
    * compares 2 strings
    * ignores case
    * alphabetically
    * */
    private boolean stringsComparator(Object a, Object b){
        return (a.toString().compareToIgnoreCase(b.toString()) < 0);
    }




}
