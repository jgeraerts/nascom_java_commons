package be.nascom.commons.util.predicates;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

/**
 * User: jgeraerts
 * Date: Jan 22, 2010
 * Time: 9:51:12 AM
 */
public class GooglePredicates {


    public static <T  extends CharSequence> Predicate<T> notNullOrEmptyPredicate() {
        return Predicates.and(Predicates.notNull(), notEmptyPredicate());
    }

    private static <T extends CharSequence> NotEmptyPredicate<T> notEmptyPredicate() {
        return new NotEmptyPredicate<T>();
    }

    private static class NotEmptyPredicate<T extends CharSequence> implements Predicate<T> {
        @Override
        public boolean apply(T s) {
            return s.length() > 0;
        }
    }
}
