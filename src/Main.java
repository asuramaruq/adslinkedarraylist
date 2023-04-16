public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> link=new MyLinkedList();
        link.addLast(1);
        link.addLast(2);
        link.addLast(3);
        link.addLast(4);
        link.addLast(5);
        System.out.println(link.indexOf(1));
        System.out.println();
        for(var element : link){
            System.out.print("<->"+element);
            System.out.print("<->");
        }
    }
}