package tester;

import static org.junit.Assert.*;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import student.StudentArrayDeque;

public class TestArrayDequeEC {
    @Test
    public void randomizedTest() {
        StudentArrayDeque<Integer> S = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> A = new ArrayDequeSolution<>();

        int N = 500;
        for (int i = 0; i < N; i++) {
            int operationNumber = StdRandom.uniform(0, 5);
            if (operationNumber == 0 || A.size() == 0) {
                int randVal = StdRandom.uniform(0, N);
                S.addLast(randVal);
                A.addLast(randVal);
            } else if (operationNumber == 1) {
                int randVal = StdRandom.uniform(0, N);
                S.addFirst(randVal);
                A.addFirst(randVal);
            } else if (operationNumber == 2) {
                int randIndex = StdRandom.uniform(0, N) % A.size();
                assertEquals("get(" + randIndex + ")", S.get(randIndex), A.get(randIndex));
            } else if (operationNumber == 3) {
                int s = S.removeFirst();
                int a = A.removeFirst();
                assertEquals("removeFirst()", s, a);
            } else {
                int s = S.removeLast();
                int a = A.removeLast();
                assertEquals("removeLast()", s, a);
            }
        }
    }
}
