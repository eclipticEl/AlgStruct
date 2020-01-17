package less4;

/*
* звено списка
* */
public class MyDoubleRefLink<T> {

    T value;            //данные
    MyDoubleRefLink next;        //ссылка на следующий элемент данных
    MyDoubleRefLink prev;        //ссылка на следующий элемент данных


    public MyDoubleRefLink(T value) {
        this.value = value;
    }

    public MyDoubleRefLink(T value, MyDoubleRefLink next) {
        this.value = value;
        this.next = next;
    }

    public MyDoubleRefLink(T value, MyDoubleRefLink next, MyDoubleRefLink prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }

    @Override
    public String toString(){
        return value.toString();
    }
}
