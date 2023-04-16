public interface MyList<E> extends Iterable<E>{
    void addFirst(E element);
    void addLast(E element);
    void add(E element, int index);
    E get(int index);
    void remove(int index);
    int size();
    void clear();
    boolean contains(Object o);
    int indexOf(Object o);
}
