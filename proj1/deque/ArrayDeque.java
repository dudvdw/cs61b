package deque;

public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        nextFirst = 0;
        nextLast = 1;
        size = 0;
    }

    public int getStart() {
        if (nextFirst == items.length - 1) {
            return 0;
        }
        return nextFirst + 1;
    }

    public int getLast() {
        if (nextLast == 0){
            return items.length - 1;
        }
        return nextLast - 1;
    }

    public void addFirst(T item) {
        items[nextFirst] = item;
        if (nextFirst == 0) {
            nextFirst = items.length - 1;
        } else {
            nextFirst--;
        }
        size++;

        if (getStart() == nextLast) {
            resize(items.length * 2);
        }
    }

    public void addLast(T item) {
        items[nextLast] = item;
        if (nextLast == items.length - 1) {
            nextLast = 0;
        } else {
            nextLast++;
        }
        size++;

        if (getStart() == nextLast) {
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
        int start = getStart();

        for (int i = start; i < start+size && i < items.length; i++) {
            a[i-start] = items[i];
        }
        if (start >= nextLast) {
            for (int i = 0; i < start; i++) {
                a[size-start] = items[i];
            }
        }
        items = a;
        nextFirst = items.length - 1;
        nextLast = size;
    }

    public void printDeque() {
        int n = 0;
        int start = getStart();
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
        int start = getStart();
        T result = items[start];
        items[start] = null;
        if (start == 0) {
            nextFirst = 0;
        } else if (start == items.length - 1){
            nextFirst = items.length - 1;
        } else {
            nextFirst++;
        }
        size--;
        int usage = size * 100 / items.length;
        if (items.length >= 16 && usage <= 25) {
            resize(items.length / 2);
        }
        return result;
    }

    public T removeLast() {
        if(size == 0) {
            return null;
        }
        int last = getLast();
        T result = items[last];
        items[last] = null;
        if (last == 0) {
            nextLast = 0;
        } else if (last == items.length - 1) {
            nextLast = items.length - 1;
        } else {
            nextLast--;
        }

        size--;
        return result;
    }

    public T get(int index) {
        if (index < items.length) {
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