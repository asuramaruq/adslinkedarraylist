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
    public void add(E element){
        if(length==arr.length){//if user hit max capacity increase the size of array
            increaseCapacity();
        }
        arr[length++]=element;//adds next element
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
        Object[] newArr= new Object[length--];//decrementing size
        for(int i=0;i<arr.length;i++){
            if(i==index){
                continue;
            }
            newArr[k++]=arr[i];//copying all elements except chosen one
        }
        arr=newArr;//override
    }
    @Override
    public int size(){
        return length;//return size of array
    }
    @Override
    public void clear(){
        arr=new Object[10];
        length=0;
    }
}
