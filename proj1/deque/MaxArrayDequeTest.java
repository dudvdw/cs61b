package deque;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Comparator;



public class MaxArrayDequeTest {
    @Test
    public void IntComparatorTest() {
        MaxArrayDeque<Integer> arr = new MaxArrayDeque<>(new IntComparator());
        arr.addLast(3);
        arr.addLast(5);
        arr.addLast(-7);
        arr.addLast(1);

        assertEquals((Integer) 5, arr.max());
        assertEquals((Integer) (-7), arr.max(new SquareComparator()));
    }

    @Test
    public void StringComparatorTest() {
        MaxArrayDeque<String> arr = new MaxArrayDeque<>(new StringComparator());
        arr.addLast("hello, world");
        arr.addLast("Hello, world.");

        assertEquals("hello, world", arr.max());
        assertEquals("Hello, world.", arr.max(new StringLengthComparator()));
    }


    private static class IntComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer i1, Integer i2) {
            return i1 - i2;
        }
    }

    private static class SquareComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer i1, Integer i2) {
            return i1*i1 - i2*i2;
        }
    }

    private static class StringComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            return s1.compareTo(s2);
        }
    }

    private static class StringLengthComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            return s1.length() - s2.length();
        }
    }
}