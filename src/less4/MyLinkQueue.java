package less4;

public class MyLinkQueue<T> {

    private MyDoublyLinkList<T> queue = new MyDoublyLinkList<>();

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    public void insert(T value){
        queue.insertLast(value);
    }

    public T delete(){
        return (T) queue.deleteFirst().value;
    }

    public T peek(){
        return (T) queue.getLast().value;
    }

    public String toString(){
        return queue.toString();
    }

}
