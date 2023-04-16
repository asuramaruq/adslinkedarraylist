import java.util.Iterator;

public class MyArrayList<E> implements MyList<E> {
    private Object[] arr;//the real array that holds the elements
    private int length=0;
    public MyArrayList(){//constructor creates a new array size 10 when called without value
        this(10);
    }//creates an array with capacity 10
    public MyArrayList(int n){//creates an array with size n
        arr=new Object[n];
    }//creates an array with n capacity
    private void increaseCapacity(){//increases the value of an array when user needs more elements
        int newSize=(int)(arr.length*2);//new size value = prev size value * 2
        Object[] newArr= new Object[newSize];
        for(int i=0;i<arr.length;i++){
            newArr[i]=arr[i];//loop through all the elements to not lose data
        }
        arr=newArr;//override main array with new one
    }
    @Override
    public void addFirst(E element){
        if(length==arr.length){
            increaseCapacity();
        }
        Object[] newArr=new Object[length+1];
        int k=1;
        for(int i=0;i<length;i++){
            newArr[k++]=arr[i];
        }
        newArr[0]=element;
        length++;
        arr=newArr;
    }
    @Override
    public void addLast(E element){
        if(length==arr.length){//if user hit max capacity increase the size of array
            increaseCapacity();
        }
        arr[length++]=element;//adds next element
    }
    @Override
    public void add(E element, int index){
        if(index>=arr.length){
            increaseCapacity();
        }
        if(arr[index]!=null){
            for(int i=arr.length-1;i>=index;i--){
                arr[i]=arr[i-1];
            }
        }
        arr[index]=element;
        length++;
    }
    @Override
    public E get(int index){
        if(index>=length){
            throw new IndexOutOfBoundsException();//throws exception if invalid index
        }
        return (E)arr[index];//returns element
    }
    @Override
    public void remove(int index){
        if(index>=length){
            throw new IndexOutOfBoundsException();//throws exceptions if invalid index
        }
        int k=0;
        Object[] newArr= new Object[length-1];
        for(int i=0;i<length;i++){
            if(i==index){
                continue;
            }
            newArr[k++]=arr[i];//copying all elements except chosen one
        }
        length--;
        arr=newArr;//override
    }
    @Override
    public int size(){
        return length;//return size of array
    }
    @Override
    public void clear(){//recreates an array
        arr=new Object[10];
        length=0;
    }
    @Override
    public boolean contains(Object o){
        for(int i=0;i<length;i++){
            if(arr[i]==o){
                return true;
            }
        }
        return false;
    }
    @Override
    public int indexOf(Object o){
        for(int i=0;i<length;i++){
            if(arr[i]==o){
                return i;
            }
        }
        return -1;
    }
    @Override
    public Iterator<E> iterator(){
        return new MyIterator();
    }
    private class MyIterator implements Iterator<E>{
        private int cursor;
        @Override
        public boolean hasNext(){
            return cursor<size();
        }
        @Override
        public E next(){
            return get(cursor++);
        }
    }
}
