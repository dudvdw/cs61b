package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testEqual() {
        AListNoResizing<Integer> aList = new AListNoResizing<>();
        BuggyAList<Integer> bList = new BuggyAList<>();

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
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> B = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0 || L.size() == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                B.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                assertEquals(L.size(), B.size());
                System.out.println("size: " + size);
            } else if (operationNumber == 2){
                assertEquals(L.getLast(), B.getLast());
                System.out.println("getLast(" + L.getLast() + ")");
            } else {
                int l = L.removeLast();
                int b = B.removeLast();
                assertEquals(l, b);
                System.out.println("removeLast(" + l + ")");
            }
        }
    }
}
