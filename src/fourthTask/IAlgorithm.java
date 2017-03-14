package fourthTask;

import java.util.Collection;
import java.util.Comparator;

/**
 * Created by Алексей on 12.03.2017.
 */
public interface IAlgorithm {
    /*
    * Functions for sorting
    * with default comparators
    * */
    Object[] quickSort(Collection<Object> collection);
    Object[] quickSort(Object[] array);
    Object[] mergeSort(Collection<Object> collection);
    Object[] mergeSort(Object[] array);

    /*
    * Uses custom comparators
    * */
    Object[] quickSort(Collection<Object> collection, Comparator<Object> comparable);
    Object[] quickSort(Object[] array, Comparator<Object> comparable);
    Object[] mergeSort(Collection<Object> collection, Comparator<Object> comparator);
    Object[] mergeSort(Object[] array, Comparator<Object> comparator);
}
