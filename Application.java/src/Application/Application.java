package Application;

public class Application {
    public static void main(String[] args) {

        MyLinkedList<Double> list = new MyLinkedList<Double>();

        list.add(12.);
        list.add(13.);
        list.add(11.);
        list.add(14.);
        list.removeAt(2);
        list.add(11.);
        list.add(14.);

        System.out.println(list.get(0));
        list.removeAt(0);
        System.out.println(list);


    }
}
