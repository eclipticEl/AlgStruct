package less3;

public class MyDeque {

    private int maxSize;    //размер  дека
    private int[] deque;    // дек
    private int front;      //маркер начала дека
    private int rear;       //маркер конца дека
    private int items;      //количество элементов в деке

    public  MyDeque(int size){
        maxSize = size;
        deque = new int[maxSize];
        front = 0;
        rear = -1;
        items = 0;
    }

    public boolean isEmpty(){
        return (items==0);
    }

    public  boolean isFull(){
        return (items==maxSize);
    }

    public int size(){
        return items;
    }

    public void addLeft(int value){
        if (front == 0)
            front = maxSize;
        deque[--front] = value;
        items++;
    }

    public int removeRight(){
        int tmp = deque[rear--];

        if (rear==-1)
            rear = maxSize-1;
        items--;
        return tmp;
    }

    public void addRight(int value){
        if (rear == maxSize-1)
            rear = -1;
        deque[++rear] = value;
        items++;
    }

    public int removeLeft(){
        int tmp = deque[front++];

        if (front==maxSize)
            front = 0;
        items--;

        return tmp;
    }

    public int peek(){
        return  deque[front];
    }

}
