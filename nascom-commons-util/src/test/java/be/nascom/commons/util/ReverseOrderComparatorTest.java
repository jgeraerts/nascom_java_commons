package be.nascom.commons.util;

import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.assertEquals;

/**
 * User: jgeraerts
 * Date: Mar 9, 2010
 * Time: 10:02:17 AM
 */
public class ReverseOrderComparatorTest {

    private Comparator<Integer> intComparator = new Comparator<Integer>(){

        @Override
        public int compare(Integer left, Integer right) {
            return left.compareTo(right);
        }
    };

    @Test
    public void testCompareTo(){
        Comparator<Integer> reverse = new ReverseOrderComparator<Integer>(intComparator);
        assertEquals(1,reverse.compare(1,2));
        assertEquals(-1,reverse.compare(2,1));
        assertEquals(0,reverse.compare(1,1));
    }

}
