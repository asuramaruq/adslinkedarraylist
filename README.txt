List, ArrayList, Doubly LinkedList implementation

Both MyArrayList and MyLinkedList implement MyList interface that extends Iterable

The methods included are:
    void addFirst(E element); - adds element to the start of the list
    void addLast(E element); - adds element to the end of the list
    void add(E element, int index); - adds element to provided index and moves next elements on 1 further
    E get(int index); - returns the element on given index
    void remove(int index); - removes element in given index
    int size(); - returns size of the list
    void clear(); - recreates the list/deletes all the elements
    boolean contains(Object o); - checks if item exist in list
    int indexOf(Object o); - returns the index of the first found given object in list


In order to use them you have to create an instance of a needed class

Both MyArrayList and MyLinkedList can be iterated through foreach loop
