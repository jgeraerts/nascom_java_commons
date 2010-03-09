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

    private static class A {
        private String stringProperty;
        private Integer intProperty;
        private String secondStringProperty;

        private A(String stringProperty) {
            this(stringProperty, null, null);
        }

        private A(String stringProperty, Integer intProperty) {
            this(stringProperty, intProperty, null);
        }

        private A(String stringProperty, Integer intProperty, String secondStringProperty) {
            this.stringProperty = stringProperty;
            this.intProperty = intProperty;
            this.secondStringProperty = secondStringProperty;
        }

        public String getStringProperty() {
            return stringProperty;
        }

        public Integer getIntProperty() {
            return intProperty;
        }

        public String getSecondStringProperty() {
            return secondStringProperty;
        }
    }

    private static class StringPropertyComparator implements Comparator<A> {

        @Override
        public int compare(A left, A right) {
            return left.getStringProperty().compareTo(right.getStringProperty());
        }
    }

    private static class IntPropertyComparator implements Comparator<A> {

        @Override
        public int compare(A left, A right) {
            return left.getIntProperty().compareTo(right.getIntProperty());
        }
    }

    private static class SecondStringPropertyComparator implements Comparator<A>{
        @Override
        public int compare(A left, A right) {
            return left.getSecondStringProperty().compareTo(right.getSecondStringProperty());
        }
    }

    @Test
    public void testCompare() {
        Comparator<A> c = new ComposedComparator<A>(new StringPropertyComparator(), new IntPropertyComparator());
        assertEquals(0, c.compare(new A("a", 1), new A("a", 1)));
        assertEquals(-1, c.compare(new A("a", 1), new A("b", 1)));
        assertEquals(-1, c.compare(new A("a", 1), new A("a", 2)));
        assertEquals(1, c.compare(new A("a", 1), new A("a", 0)));
        assertEquals(1, c.compare(new A("b", 1), new A("a", 0)));
    }

    @Test
    public void builderWithSingleComparator() {
        Comparator<A> c = ComposedComparator.build(new StringPropertyComparator());
        assertEquals(0, c.compare(new A("a"), new A("a")));
        assertEquals(-1, c.compare(new A("a"), new A("b")));
        assertEquals(1, c.compare(new A("b"), new A("a")));
    }

    @Test
    public void builderWithTwoComparators() {
        Comparator<A> c = ComposedComparator.build(new StringPropertyComparator(),new IntPropertyComparator());
        assertEquals(0, c.compare(new A("a", 1), new A("a", 1)));
        assertEquals(-1, c.compare(new A("a", 1), new A("b", 1)));
        assertEquals(-1, c.compare(new A("a", 1), new A("a", 2)));
        assertEquals(1, c.compare(new A("a", 1), new A("a", 0)));
        assertEquals(1, c.compare(new A("b", 1), new A("a", 0)));
    }

    @Test
    public void builderWithThreeComparators() {
        Comparator<A> c = ComposedComparator.build(new StringPropertyComparator(),new IntPropertyComparator(), new SecondStringPropertyComparator());
        assertEquals(0, c.compare(new A("a", 1, "a"), new A("a", 1, "a")));
        assertEquals(-1, c.compare(new A("a", 1, "a"), new A("a", 1, "b")));
        assertEquals(1, c.compare(new A("a", 1, "b"), new A("a", 1, "a")));

        assertEquals(-1, c.compare(new A("a", 1, "a"), new A("a", 2, "a")));
        assertEquals(1, c.compare(new A("a", 1, "a"), new A("a", 0, "a")));

        assertEquals(-1, c.compare(new A("a", 1, "a"), new A("b", 1, "a")));
        assertEquals(1, c.compare(new A("b", 1, "a"), new A("a", 0, "a")));
    }
}
