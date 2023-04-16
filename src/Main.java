public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> link=new MyArrayList();
        link.addLast(1);
        link.addLast(2);
        link.addLast(3);
        link.addFirst(5);
        for(var element : link){
            System.out.println(element);
        }
    }
}