package deque;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;
import static org.junit.Assert.*;


/** Performs some basic linked list tests. */
public class ArrayDequeTest {

    @Test
    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public void addIsEmptySizeTest() {

        ArrayDeque<String> lld1 = new ArrayDeque<String>();
        ArrayDeque<String> lld2 = new ArrayDeque<String>();

        assertTrue("A newly initialized LLDeque should be empty", lld1.isEmpty());
        lld2.addLast("front");
        lld1.addFirst("front");
        System.out.println("lld1 equals lld2 " + lld1.equals(lld2));
        lld2.addLast("front2");
        System.out.println("lld1 equals lld2 >>" + lld1.equals(lld2));

        // The && operator is the same as "and" in Python.
        // It's a binary operator that returns true if both arguments true, and false otherwise.
        assertEquals(1, lld1.size());
        assertFalse("lld1 should now contain 1 item", lld1.isEmpty());

        lld1.addLast("middle");
        assertEquals(2, lld1.size());

        lld1.addLast("back");
        assertEquals(3, lld1.size());




        System.out.println("Printing out deque: ");
        lld1.printDeque();
    }


    @Test
    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public void addRemoveTest() {

        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        // should be empty
        assertTrue("lld1 should be empty upon initialization", lld1.isEmpty());

        lld1.addFirst(10);
        // should not be empty
        assertFalse("lld1 should contain 1 item", lld1.isEmpty());

        lld1.removeFirst();
        // should be empty
        assertTrue("lld1 should be empty after removal", lld1.isEmpty());

        lld1.addFirst(0);
        int res = lld1.get(0);
        assertEquals(0, res);
    }

    @Test
    /* Tests removing from an empty deque */
    public void removeEmptyTest() {

        ArrayDeque<Integer> lld1 = new ArrayDeque<>();
        lld1.addFirst(3);

        lld1.removeLast();
        lld1.removeFirst();
        lld1.removeLast();
        lld1.removeFirst();

        int size = lld1.size();
        String errorMsg = "  Bad size returned when removing from empty deque.\n";
        errorMsg += "  student size() returned " + size + "\n";
        errorMsg += "  actual size() returned 0\n";

        assertEquals(errorMsg, 0, size);
    }

    @Test
    /* Check if you can create ArrayDeques with different parameterized types*/
    public void multipleParamTest() {

        ArrayDeque<String>  lld1 = new ArrayDeque<String>();
        ArrayDeque<Double>  lld2 = new ArrayDeque<Double>();
        ArrayDeque<Boolean> lld3 = new ArrayDeque<Boolean>();

        lld1.addFirst("string");
        lld2.addFirst(3.14159);
        lld3.addFirst(true);

        String s = lld1.removeFirst();
        double d = lld2.removeFirst();
        boolean b = lld3.removeFirst();
    }

    @Test
    /* check if null is return when removing from an empty ArrayDeque. */
    public void emptyNullReturnTest() {

        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();

        boolean passed1 = false;
        boolean passed2 = false;
        assertEquals("Should return null when removeFirst is called on an empty Deque,", null, lld1.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque,", null, lld1.removeLast());

    }

    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void bigLLDequeTest() {

        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        for (int i = 0; i < 100000; i++) {
            lld1.addLast(i);
        }

        for (double i = 0; i < 50000; i++) {
            assertEquals("Should have the same value", i, (double) lld1.removeFirst(), 0.0);
        }

        for (double i = 99999; i > 50000; i--) {
            assertEquals("Should have the same value", i, (double) lld1.removeLast(), 0.0);
        }

    }

    private static void printTimingTable(ArrayDeque<Integer> Ns, ArrayDeque<Double> times, ArrayDeque<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

//    public static void main(String[] args) {
//        timeAListConstruction();
//    }

    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE
        ArrayDeque<Integer> testList = new ArrayDeque<>();
        ArrayDeque<Double> timeList = new ArrayDeque<>();
        int n = 1000;

        for (int i = 0; i < 8; i++) {
            ArrayDeque<Integer> a = new ArrayDeque<>();

            Stopwatch sw = new Stopwatch();
            for (int j = 0; j < n; j++) {
                a.addLast(i);
            }
            double timeInSeconds = sw.elapsedTime();

            testList.addLast(n);
            timeList.addLast(timeInSeconds);
            n *= 2;
        }

        printTimingTable(testList, timeList, testList);
    }


    @Test
    public void testEqual() {
        LinkedListDeque<Integer> aList = new LinkedListDeque<>();
        ArrayDeque<Integer> bList = new ArrayDeque<>();

        for (int i = 4; i < 7; i++) {
            aList.addLast(i);
            bList.addLast(i);
        }

        for (int i = 0; i < 3; i++) {
            assertEquals(aList.size(), bList.size());

            int a = aList.removeLast();
            int b = bList.removeLast();

            assertEquals(a, b);
        }
    }

    @Test
    public void randomizedTest() {
        LinkedListDeque<Integer> L = new LinkedListDeque<>();
        ArrayDeque<Integer> B = new ArrayDeque<>();

        int N = 1000000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 6);
            if (operationNumber == 1) {
                // addLast
                int randVal = StdRandom.uniform(0, N);
                L.addLast(randVal);
                B.addLast(randVal);
//                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 0) {
                // addFirst
                int randVal = StdRandom.uniform(0, N);
                L.addFirst(randVal);
                B.addFirst(randVal);
//                System.out.println("addFirst(" + randVal + ")");
            } else if (L.size() == 0) {
                assertTrue(L.isEmpty());
                assertTrue(B.isEmpty());
            } else if (operationNumber == 2) {
                // size
                int size = L.size();
                assertEquals(L.size(), B.size());
//                System.out.println("size: " + size);
            } else if (operationNumber == 3){
                int randIndex = StdRandom.uniform(0, N) % L.size();
                assertEquals(L.get(randIndex), B.get(randIndex));
//                System.out.println("get(" + randIndex + ")");
            } else if (operationNumber == 4) {
                int l = L.removeFirst();
                int b = B.removeFirst();
                assertEquals(l, b);
//                System.out.println("removeFirst(" + l + ")");
            } else {
                int l = L.removeLast();
                int b = B.removeLast();
                assertEquals(l, b);
//                System.out.println("removeLast(" + l + ")");
            }
        }
    }
}
