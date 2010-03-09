package be.nascom.commons.util;

import java.util.Comparator;

/**
 * User: jgeraerts
 * Date: Mar 9, 2010
 * Time: 9:59:57 AM
 */
public class ReverseOrderComparator<A> implements Comparator<A> {
    private Comparator<A> comparator;

    public ReverseOrderComparator(Comparator<A> comparator) {
        this.comparator = comparator;
    }

    @Override
    public int compare(A left, A right) {
        return -1 * comparator.compare(left,right);
    }
}
