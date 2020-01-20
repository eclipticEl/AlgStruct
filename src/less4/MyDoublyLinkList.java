package less4;

import java.util.NoSuchElementException;

public class MyDoublyLinkList<T> {
    private MyDoubleRefLink first; // ссылка на первый элемент
    private MyDoubleRefLink last; // ссылка на последний элемент

    public MyDoublyLinkList() {
        first = null;
    }

    public boolean isEmpty(){
        return  (first == null);
    }

    public void insertFirst(T value){
        MyDoubleRefLink newLink = new MyDoubleRefLink(value, first);

        if (isEmpty()){
            last = newLink;
        }
        else{
            first.prev = newLink;
        }

        first = newLink;
    }

    public void insertLast(T value) {
        MyDoubleRefLink newLink = new MyDoubleRefLink(value);
        if (isEmpty()) {
            first = newLink;
        } else {
            newLink.prev = last;
            last.next = newLink;
        }
        last = newLink;
    }

    public MyDoubleRefLink deleteFirst(){
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        MyDoubleRefLink link = first;
        first = first.next;
        if (isEmpty()) {
            last = null;
        } else {
            first.prev = null;
        }

        return link;
    }

    public  MyDoubleRefLink deleteLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        MyDoubleRefLink link = last;
        if (last.prev != null) {
            last.prev.next = null;
        } else {
            first = null;
        }
        last = last.prev;

        return link;
    }


    public MyDoubleRefLink findByValue(T value){
        if (isEmpty())
            throw new NoSuchElementException();

        MyDoubleRefLink current = first;
        while ( current != null && !current.value.equals(value)){
            current = current.next;
        }
        return  current;
    }

    public MyDoubleRefLink findByIndex(int index){
        if (isEmpty())
            throw new NoSuchElementException();

        MyDoubleRefLink current = first;
        int ind=0;

        while ( current != null && ind != index){
            ind ++;
            current = current.next;
        }

        return  current;

    }


    public void insert(int index, T value) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            insertFirst(value);
        } else {

            MyDoubleRefLink linkAfter = findByIndex(index);
            if (linkAfter == null){
                insertLast(value);
            }
            else {
                MyDoubleRefLink newLink = new MyDoubleRefLink(value, linkAfter, linkAfter.prev);
                linkAfter.prev.next = newLink;
                linkAfter.prev = newLink;
            }

        }
    }

    public boolean delete(T value){
        if (isEmpty()){
            return  false;
        }

        if(first.value.equals(value)){
            deleteFirst();
            return true;
        }

        MyDoubleRefLink link = findByValue(value);
        if (link != null) {
            link.prev.next = link.next;
            link.next.prev = link.prev;
            return true;
        }

        return false;
    }

    public MyDoubleRefLink getFirst() {
        return  first;
    }

    public MyDoubleRefLink getLast() {
        return last;
    }


    public void setFirst(MyDoubleRefLink first) {
        this.first = first;
    }

    public LinkIterator getIterator(){
        return new LinkIterator(this);
    }


    @Override
    public String toString(){
        if (isEmpty()){
            return "[]";
        }

        MyDoubleRefLink current = first;

        StringBuilder str = new StringBuilder("[");

        while (current != null){
            str.append(current.value.toString() + ",");
            current = current.next;
        }

        str.delete(str.length()-1 ,str.length());
        str.append("]");

        return str.toString();
    }
}
