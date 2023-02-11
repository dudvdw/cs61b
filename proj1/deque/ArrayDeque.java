package deque;

public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int start;
    private int last;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        nextFirst = 0;
        nextLast = 1;
        size = 0;
    }

    public void addFirst(T item) {
        items[nextFirst] = item;
        start = nextFirst;
        if (nextFirst == 0) {
            nextFirst = items.length - 1;
        } else {
            nextFirst--;
        }
        size++;

        if (nextFirst == nextLast) {
            resize(items.length * 2);
        }
    }

    public void addLast(T item) {
        items[nextLast] = item;
        last = nextLast;
        if (nextLast == items.length - 1) {
            nextLast = 0;
        } else {
            nextLast++;
        }
        size++;

        if (nextFirst == nextLast) {
            resize(items.length * 2);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void resize(int n) {
        T[] a = (T[]) new Object[n];

        for (int i = start; i < size; i++) {
            a[i-start] = items[i];
        }
        if (start != 0) {
            for (int i = 0; i < start; i++) {
                a[size-start] = items[i];
            }
        }
        start = 0;
        last = size - 1;
        items = a;
        nextFirst = items.length - 1;
        nextLast = size;
    }

    public void printDeque() {
        int n = 0;
        for (int i = start; i < start+size && i < items.length; i++) {
            n++;
            System.out.print(get(i) + " ");
        }
        if (n < size) {
            for (int i = 0; i < size-n; i++) {
                System.out.print(get(i) + " ");
            }
        }
        System.out.println();
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T result = items[start];
        items[start] = null;
        if (start == 0) {
            start++;
            nextFirst = 0;
        } else if (start == items.length - 1){
            start = 0;
            nextFirst = items.length - 1;
        } else {
            start++;
            nextFirst++;
        }
        size--;

        if (size >= 16 && size / items.length <= 0.25) {
            resize(items.length / 2);
        }
        return result;
    }

    public T removeLast() {
        if(size == 0) {
            return null;
        }
        T result = items[last];
        items[last] = null;
        if (last == 0) {
            last = items.length - 1;
            nextLast = 0;
        } else if (last == items.length - 1) {
            last = 0;
            nextLast = items.length - 1;
        } else {
            last--;
            nextLast--;
        }

        size--;
        return result;
    }

    public T get(int index) {
        if (index < items.length && items[index] != null) {
            return items[index];
        }
        return null;
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