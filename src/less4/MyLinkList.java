package less4;

import java.util.NoSuchElementException;

public class MyLinkList<T> {
    private MyLink first; // ссылка на первый элемент

    public MyLinkList() {
        first = null;
    }

    public boolean isEmpty(){
        return  (first == null);
    }

    public void insertFirst(T value){
        MyLink newLink = new MyLink(value, first);
        first = newLink;
    }

    public MyLink deleteFirst(){
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        MyLink link = first;
        first = first.next;
        return link;
    }


    public MyLink findByValue(T value){
        if (isEmpty())
            throw new NoSuchElementException();

        MyLink current = first;
        while ( current != null && !current.value.equals(value)){
            current = current.next;
        }
        return  current;
    }

    public MyLink findByIndex(int index){
        if (isEmpty())
            throw new NoSuchElementException();

        MyLink current = first;
        int ind=0;

        while ( current != null && ind != index){
            ind ++;
            current = current.next;
        }

        if (ind != index) {
            throw new IndexOutOfBoundsException();
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

            MyLink current = first;
            int ind = 0;
            while ( current.next != null  && ind != index){
                ind ++;
                current = current.next;
            }
            MyLink newLink = new MyLink(value, current.next);
            current.next = newLink;
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

        MyLink current = first;
        while ( current.next != null ){
            if (current.next.value.equals(value)){
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }

        return false;

    }

    @Override
    public String toString(){
        if (isEmpty()){
            return "[]";
        }

        MyLink current = first;

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
