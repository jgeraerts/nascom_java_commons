package be.nascom.commons.util;

import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.assertEquals;

/**
 * User: jgeraerts
 * Date: Mar 8, 2010
 * Time: 4:39:23 PM
 */
public class ComposedCompararatorTest {

    private static class A{
        private String stringProperty;
        private Integer intProperty;

        private A(String stringProperty, Integer intProperty) {
            this.stringProperty = stringProperty;
            this.intProperty = intProperty;
        }

        public String getStringProperty() {
            return stringProperty;
        }

        public Integer getIntProperty() {
            return intProperty;
        }
    }

    private static class StringPropertyComparator implements Comparator<A>{

        @Override
        public int compare(A left, A right) {
            return left.getStringProperty().compareTo(right.getStringProperty());
        }
    }

    private static class IntPropertyComparator implements Comparator<A>{

        @Override
        public int compare(A left, A right) {
            return left.getIntProperty().compareTo(right.getIntProperty());
        }
    }


    @Test
    public void testCompare(){
        Comparator<A> c = new ComposedComparator<A>(new StringPropertyComparator(),new IntPropertyComparator());
        assertEquals(0,c.compare(new A("a",1),new A("a",1)));
        assertEquals(-1,c.compare(new A("a",1),new A("b",1)));
        assertEquals(-1,c.compare(new A("a",1),new A("a",2)));
        assertEquals(1,c.compare(new A("a",1),new A("a",0)));
        assertEquals(1,c.compare(new A("b",1),new A("a",0)));




    }
}
