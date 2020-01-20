package less4;

public class LinkIterator<T> {
    private MyDoubleRefLink current;
    private MyDoubleRefLink previous;
    private MyDoublyLinkList<T> list;

    public <T> LinkIterator(MyDoublyLinkList<T> tMyDoublyLinkList) {
        this.list = list;
        this.reset();
    }

    public void reset(){
        current = list.getFirst();
        previous = null;
    }

    public boolean atEnd(){
        return (current.next == null);
    }

    public void nextLink(){
        previous = current;
        current = current.next;
    }

    public MyDoubleRefLink getCurrent(){
        return current;
    }

    public void insertAfter(T value){
        MyDoubleRefLink newLink = new MyDoubleRefLink(value);
        if (list.isEmpty()){
            list.setFirst(newLink);
            current = newLink;
        } else {
            newLink.next = current.next;
            current.next = newLink;
            nextLink();
        }
    }

    public void insertBefore(T value){
        MyDoubleRefLink newLink = new MyDoubleRefLink(value);
        if(previous == null){
            newLink.next = list.getFirst();
            list.setFirst(newLink);
            reset();
        }
        else{
            newLink.next = previous.next;
            previous.next = newLink;
            current = newLink;
        }
    }

    public T deleteCurrent(){
        T val = (T) current.value;
        if (previous == null){
            list.setFirst(current.next);
            reset();
        } else {
            previous.next = current.next;
            if (atEnd()){
                reset();
            } else {
                current = current.next;
            }
        }

        return val;
    }

}
