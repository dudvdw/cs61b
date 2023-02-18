package flik;

/** An Integer tester created by Flik Enterprises.
 * @author Josh Hug
 * */
public class Flik {
    /** @param a Value 1
     *  @param b Value 2
     *  @return Whether a and b are the same */

    // Java create an IntegerCache from -128 to 127,
    // when you create an Integer in this range, it will refer to the IntegerCache,
    // when the Integer out of range, it will create a new Integer in a new address
    // each time.
    public static boolean isSameNumber(int a, int b) {
        return a == b;
    }
}
