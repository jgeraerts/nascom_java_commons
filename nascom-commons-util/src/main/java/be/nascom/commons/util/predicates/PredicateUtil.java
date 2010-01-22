package be.nascom.commons.util.predicates;

/**
 * User: jgeraerts
 * Date: Jan 22, 2010
 * Time: 9:49:42 AM
 */
public final class PredicateUtil {

    private PredicateUtil(){}

    public static boolean checkStringNotNullOrEmpty(CharSequence s){
        return GooglePredicates.notNullOrEmptyPredicate().apply(s);
    }

}
