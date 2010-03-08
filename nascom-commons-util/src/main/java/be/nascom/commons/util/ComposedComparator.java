package be.nascom.commons.util;

import java.util.Comparator;

/**
 * User: jgeraerts
 * Date: Mar 8, 2010
 * Time: 4:55:12 PM
 */
public class ComposedComparator<A> implements Comparator<A> {
    private Comparator<A> a;
    private Comparator<A> b;

    public ComposedComparator(Comparator<A> a, Comparator<A> b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int compare(A left, A right) {
        int i = a.compare(left,right);
        return i != 0? i: b.compare(left,right);

    }
}
