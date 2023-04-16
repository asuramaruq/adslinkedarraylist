import java.util.Iterator;

public class MyLinkedList<E> implements MyList<E>{
    private class MyNode{//the node class for storing the addresses for prev and next elements
        private E element;
        private MyNode next;
        private MyNode prev;
        public MyNode(E element){
            this.element=element;
        }
        public MyNode(E element, MyNode next, MyNode prev){
            this.element=element;
            this.next=next;
            this.prev=prev;
        }
    }
    private MyNode head;
    private MyNode tail;
    private int length;
    public MyLinkedList(){
        this.clear();
    }
    private void insertFirst(E element){//inserts the first element into empty list
        MyNode node=new MyNode(element);
        node.prev=null;
        node.next=null;
        head=node;
        tail=node;
        length++;
    }
    @Override
    public void addFirst(E element){//adds element to the start
        MyNode node=new MyNode(element);
        if(head==null){
            insertFirst(element);
            return;
        }
        node.next=head;
        node.prev=null;
        head.prev=node;
        head=node;
        length++;
    }
    @Override
    public void addLast(E element){//adds element to the end
        MyNode node=new MyNode(element);
        if(head==null){
            insertFirst(element);
            return;
        }
        node.prev=tail;
        node.next=null;
        tail.next=node;
        tail=node;
        length++;
    }
    @Override
    public void add(E element, int index){//adds at given index
        if(index>length||index<0){
            throw new IndexOutOfBoundsException();
        }
        MyNode node=new MyNode(element);
        MyNode temp=head;
        for(int i=0;i<index;i++){
            temp=temp.next;
        }
        MyNode prev=temp.prev;
        node.prev=prev;
        node.next=temp;
        prev.next=node;
        temp.prev=node;
        length++;
    }

    @Override
    public E get(int index){//returns the elements on index
        if(index>length||index<0){
            throw new IndexOutOfBoundsException();
        }
        MyNode temp=head;
        for(int i=0;i<index;i++){
            temp=temp.next;
        }
        return temp.element;
    }

    @Override
    public void remove(int index){//removes the element on index
        if(index>length||index<0){
            throw new IndexOutOfBoundsException();
        }
        MyNode temp=head;
        for(int i=0;i<index;i++){
            temp=temp.next;
        }
        MyNode prev=temp.prev;
        MyNode next=temp.next;
        prev.next=next;
        next.prev=prev;
        length--;
    }

    @Override
    public int size(){//returns size
        return length;
    }

    @Override
    public void clear(){//recreates the list
        this.head=null;
        this.tail=null;
        this.length=0;
    }

    @Override
    public boolean contains(Object o){//checks if object exists
        MyNode temp=head;
        for(int i=0;i<length&&temp.next!=null;i++){
            temp=temp.next;
            if(temp.element==o){
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Object o){//return the index of object if exist
        MyNode temp=head;
        for(int i=0;i<length&&temp.next!=null;i++,temp=temp.next){
            if(temp.element==o){
                return i;
            }
        }
        return -1;
    }
    @Override
    public Iterator<E> iterator(){
        return new MyLinkedList.MyIterator();
    }
    private class MyIterator implements Iterator<E>{
        MyNode cursor=head;
        @Override
        public boolean hasNext(){
            return cursor!=null;
        }
        @Override
        public E next(){
            E nextElement= cursor.element;
            cursor=cursor.next;
            return nextElement;
        }
    }
}