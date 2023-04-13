public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> arr=new MyArrayList();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        for(var element : arr){
            System.out.println(element);
        }
    }
}