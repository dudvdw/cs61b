package deque;

public class LinkedListDeque<T> {
    public class DequeNode {
        public T item;
        public DequeNode prev;
        public DequeNode next;
        public DequeNode(T item, DequeNode prev, DequeNode next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    private DequeNode sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new DequeNode(null, null, null);
        size = 0;
    }

//    public LinkedListDeque(T x) {
//        sentinel = new DequeNode(null, null, null);
//        sentinel.next = new DequeNode(x, sentinel, sentinel);
//        size = 1;
//    }

    public void addFirst(T item) {
        DequeNode oldFirst = sentinel.next;
        DequeNode first = new DequeNode(item, sentinel, oldFirst);
        if(sentinel.prev == null) {
            first = new DequeNode(item, sentinel, sentinel);
            sentinel.prev = first;
        }
        sentinel.next = first;

        if(oldFirst != null) {
            oldFirst.prev = first;
        }
        size++;
    }

    public void addLast(T item) {
        DequeNode oldLast = sentinel.prev;
        DequeNode last = new DequeNode(item, oldLast, sentinel);
        if (sentinel.next == null) {
            last = new DequeNode(item, sentinel, sentinel);
            sentinel.next = last;
        }
        sentinel.prev = last;

        if (oldLast != null) {
            oldLast.next = last;
        }
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(get(i) + " ");
        }
        System.out.println();
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        DequeNode first = sentinel.next;
        if (first == null) {
            return null;
        }
        if (size == 1) {
            sentinel.prev = null;
            sentinel.next = null;
        }
        if (size > 1) {
            DequeNode second = first.next;
            sentinel.next = second;
            second.prev = sentinel;
        }
        T result = first.item;
        first.prev = null;
        first.next = null;
        first.item = null;
        size--;
        return result;
    }

    public T removeLast() {
        if(size == 0) {
            return null;
        }
        DequeNode oldLast = sentinel.prev;
        if (oldLast == null) {
            return null;
        }
        if (size == 1) {
            sentinel.prev = null;
            sentinel.next = null;
        }
        if (size > 1) {
            DequeNode last = oldLast.prev;
            sentinel.prev = last;
            last.next = sentinel;
        }
        T result = oldLast.item;
        oldLast.prev = null;
        oldLast.next = null;
        oldLast.item = null;
        size--;
        return result;
    }

    public T get(int index) {
        DequeNode cur = sentinel.next;
        for (int i = 0; i < size; i++) {
            if (cur == null) {
                return null;
            }
            if (i == index) {
                return cur.item;
            }
            cur = cur.next;
        }
        return null;
    }

    public T getRecursiveHelper(int index, DequeNode x) {
        if (index == 0) {
            return x.item;
        } else if (index < size) {
            x = x.next;
            return getRecursiveHelper(index--, x);
        } else {
            return null;
        }
    }

    public T getRecursive(int index) {
        DequeNode cur = sentinel.next;
        return getRecursiveHelper(index, cur);
    }

//    public Iterator<T> iterator() {
//        Iterator<T> it =
//        return it;
//    }

//    public boolean equals(Object o) {
//        if (o instanceof T) {
//
//        }
//    }
}