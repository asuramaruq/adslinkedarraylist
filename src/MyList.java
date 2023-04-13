public interface MyList<E>{
    void add(E element);
    E get(int index);
    void remove(int index);
    int size();
    void clear();
}
