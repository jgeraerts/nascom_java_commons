package be.nascom.commons.util;

import java.util.Comparator;

/**
 * <p>
 * Comparator that combines the result of two other comparators. It is
 * useful to compare multiple fields of a bean so you can sort on property a and
 * then on property b
 * <p>
 * If a.compare results in nonzero it returns the value of a.compare
 * otherwise it returns b.compare
 *
 * @author Jo Geraerts
 *
 */
public class ComposedComparator<A> implements Comparator<A> {
    private Comparator<A> a;
    private Comparator<A> b;

    /**
     *
     * Constructor
     *
     * @param a Comparator a
     * @param b Comparator b
     */
    public ComposedComparator(Comparator<A> a, Comparator<A> b) {
        this.a = a;
        this.b = b;
    }

    public static <A> Comparator<A> build(Comparator<A>... c) {
        Builder<A> b = new Builder<A>();
        for (Comparator<A> comparator : c) {
            b.add(comparator);
        }
        return b.build();
    }

    /**      
     * @see java.util.Comparator#compare(Object, Object)
     */

    @Override
    public int compare(A left, A right) {
        int i = a.compare(left,right);
        return i != 0? i: b.compare(left,right);

    }

    private static class Builder<A> {
        Comparator<A> comparator;

        public Builder<A> add(Comparator<A> c) {
            if (this.comparator == null) this.comparator = c;
            else this.comparator = new ComposedComparator<A>(comparator, c);
            return this;
        }

        public Comparator<A> build() {
            return comparator;
        }
    }
}
