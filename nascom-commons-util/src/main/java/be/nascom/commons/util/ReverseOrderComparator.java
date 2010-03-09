package be.nascom.commons.util;

import java.util.Comparator;

/**
 * <p>
 * Comparator that reverses the result of an original Comparator
 * <p> 
 * Given Comparator a and reverseOrderComparator b
 * <p>
 * a.compose -> 0 -> b.compose 0 <br/>
 * a.compose -> 1 -> b.compose -1 <br/>
 * a.compose -> -1 -> b.compose 1 <br/>
 *
 * @author Jo Geraerts
 *
 */
public class ReverseOrderComparator<A> implements Comparator<A> {
    private Comparator<A> comparator;

    /**
     * Constructor
     *
     * @param comparator Comparator to reverse
     */
    public ReverseOrderComparator(Comparator<A> comparator) {
        this.comparator = comparator;
    }

    /**
     * @see Comparator#compare(Object, Object) 
     */
    @Override
    public int compare(A left, A right) {
        return -1 * comparator.compare(left,right);
    }
}
