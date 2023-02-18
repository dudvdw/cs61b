package gh2;

import deque.Deque;
import deque.LinkedListDeque;

//Note: This file will not compile until you complete the Deque implementations
public class HarpString {
    /** Constants. Do not change. In case you're curious, the keyword final
     * means the values cannot be changed at runtime. We'll discuss this and
     * other topics in lecture on Friday. */
    private static final int SR = 44100;      // Sampling Rate
    private static double decay = .996; // energy decay factor

    /* Buffer for storing sound data. */
    private Deque<Double> buffer;

    /* Create a guitar string of the given frequency.  */
    public HarpString(double frequency) {
        buffer = new LinkedListDeque<Double>();
        int capacity = (int) Math.round(SR / frequency) * 2;
        for (int i = 0; i < capacity; i++) {
            buffer.addLast(0.0);
        }
    }


    /* Pluck the guitar string by replacing the buffer with white noise. */
    public void pluck() {
        for (int i = 0; i < buffer.size(); i++) {
            double r = Math.random() - 0.5;
            buffer.removeFirst();
            buffer.addLast(r);
        }
    }

    /* Advance the simulation one time step by performing one iteration of
     * the Karplus-Strong algorithm.
     */
    public void tic() {
        double first = buffer.removeFirst();
        double second = buffer.get(0);
        double newPluck = -(first + second) / 2 * decay;
        buffer.addLast(newPluck);
    }

    public void heldDown() {
        decay = 0;
    }

    public void revert() {
        decay = 0.996;
    }

    /* Return the double at the front of the buffer. */
    public double sample() {
        return buffer.get(0);
    }
}
