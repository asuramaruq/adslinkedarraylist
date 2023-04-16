import java.util.Iterator;

public class MyLinkedList<E> implements MyList<E>{
    private class MyNode{
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
    private void insertFirst(E element){
        MyNode node=new MyNode(element);
        node.prev=null;
        node.next=null;
        head=node;
        tail=node;
        length++;
    }
    @Override
    public void addFirst(E element){
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
    public void addLast(E element){
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
    public void add(E element, int index){
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
    public E get(int index){
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
    public void remove(int index){
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
    public int size(){
        return length;
    }

    @Override
    public void clear(){
        this.head=null;
        this.tail=null;
        this.length=0;
    }

    @Override
    public boolean contains(Object o){//doesnt work for some reason
        E element=(E)o;
        MyNode temp=head;
        while(temp!=null){
            if(temp.element==element){
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Object o){//doesnt work
        E element=(E)o;
        MyNode temp=head;
        int i=-1;
        while(temp!=null){
            i++;
            if(temp.element==element){
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