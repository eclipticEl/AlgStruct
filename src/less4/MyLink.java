package less4;

/*
* звено списка
* */
public class MyLink<T> {

    T value;            //данные
    MyLink next;        //ссылка на следующий элемент данных

    public MyLink(T value) {
        this.value = value;
    }

    public MyLink(T value, MyLink next) {
        this.value = value;
        this.next = next;
    }

    @Override
    public String toString(){
        return value.toString();
    }
}
