package examprep;

public class DLList {
    private class IntNode {
        public int item;
        public IntNode prev;
        public IntNode next;
        public IntNode(int item, IntNode prev, IntNode next){
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    private IntNode sentinel;
    private int size;

    public void addFirst(int x) {
        IntNode oldFirst = this.sentinel.next;
        IntNode first = new IntNode(x, this.sentinel, oldFirst);
        this.sentinel.next = first;
        oldFirst.prev = first;
        size++;
    }

    public void addLast(int x) {
        IntNode oldLast = this.sentinel.prev;
        IntNode last = new IntNode(x, oldLast, this.sentinel);
        this.sentinel.prev = last;
        oldLast.next = last;
        size++;
    }

    public void reverseDLList() {
        if (this.size == 0){
            return;
        }
        IntNode lPointer = this.sentinel.prev;
        IntNode rPointer = this.sentinel.next;
        int lIndex = 0;
        int rIndex = this.size - 1;
        while (lIndex < rIndex && lPointer != null && rPointer != null){
            int left = lPointer.item;
            lPointer.item = rPointer.item;
            rPointer.item = left;
            lIndex++;
            rIndex--;
            lPointer = lPointer.next;
            rPointer = rPointer.prev;
        }
    }
}
