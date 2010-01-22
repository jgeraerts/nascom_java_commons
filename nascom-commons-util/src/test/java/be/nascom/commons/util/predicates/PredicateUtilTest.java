package be.nascom.commons.util.predicates;

import org.junit.Test;

import static be.nascom.commons.util.predicates.PredicateUtil.checkNotNullOrEmpty;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * User: jgeraerts
 * Date: Jan 22, 2010
 * Time: 10:08:31 AM
 */
public class PredicateUtilTest {
    @Test
    public void testCheckStringNotNullOrEmpty() throws Exception {
        assertFalse(checkNotNullOrEmpty(null));
        assertFalse(checkNotNullOrEmpty(""));
        assertTrue(checkNotNullOrEmpty("mekker"));

    }
}
