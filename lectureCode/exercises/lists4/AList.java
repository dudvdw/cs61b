/** Array based list.
 *  @author Josh Hug
 */

public class AList {
    private int[] a;
    private int size;
    /** Creates an empty list. */
    public AList() {
        a = new int [100];
        size = 0;
    }

    /** Inserts X into the back of the list. */
    public void addLast(int x) {
        if (a.length == size) {
            resize(size+1);
        }
        a[size] = x;
        size += 1;
    }

    /** Returns the item from the back of the list. */
    public int getLast() {
        return a[size-1];
    }
    /** Gets the ith item in the list (0 is the front). */
    public int get(int i) {
        return a[i];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    public void resize(int n) {
        int [] b = new int [n];
        System.arraycopy(a, 0, b, 0, Math.min(size, n));
        a = b;
        size = n;
    }

    /** Deletes item from back of the list and
      * returns deleted item. */
    public int removeLast() {
        int r = a[size-1];
        a[size-1] = 0;
        size -= 1;
        return r;
    }
} 