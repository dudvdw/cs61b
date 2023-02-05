public class Lists1Exercises {
    /** Returns an IntList identical to L, but with
      * each element incremented by x. L is not allowed
      * to change. */
    public static IntList incrList(IntList L, int x) {
        /* Your code here. */
        IntList addL = new IntList(L.first + x, null);
        IntList pre = addL;
        while (L.rest != null) {
            L = L.rest;
            addL.rest = new IntList(L.first + x, null);
            addL = addL.rest;
        }
        return pre;
    }

    /** Returns an IntList identical to L, but with
      * each element incremented by x. Not allowed to use
      * the 'new' keyword. */
    public static IntList dincrList(IntList L, int x) {
        /* Your code here. */
        IntList p = L;
        while (p != null) {
            p.first += x;
            p = p.rest;
        }
        return L;
    }

    public static void printL (IntList L) {
        while (L != null) {
            System.out.print(L.first + " ");
            L = L.rest;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        IntList L = new IntList(5, null);
        L.rest = new IntList(7, null);
        L.rest.rest = new IntList(9, null);

        System.out.println(L.size());
        System.out.println(L.iterativeSize());

        // Test your answers by uncommenting. Or copy and paste the
        // code for incrList and dincrList into IntList.java and
        // run it in the visualizer.
         System.out.println(L.get(1));
         printL(L);
         printL(incrList(L, 3));
         printL(dincrList(L, 4));
    }
}