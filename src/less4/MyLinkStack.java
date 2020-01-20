package less4;

public class MyLinkStack<T> {
    private MyDoublyLinkList<T> stack = new MyDoublyLinkList<>();

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public void push(T value){
        stack.insertFirst(value);
    }

    public T pop(){
        return (T) stack.deleteFirst().value;
    }

    public T peek(){
        return (T) stack.getLast().value;
    }

    public String toString(){
        return stack.toString();
    }

}
