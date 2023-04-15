public interface MyList<E> extends Iterable<E>{
    void add(E element);
    E get(int index);
    void remove(int index);
    int size();
    void clear();
    boolean contains(Object o);
    void add(E element, int index);
    int indexOf(Object o);
}
