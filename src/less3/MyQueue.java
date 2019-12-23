package less3;

public class MyQueue {
    private int maxSize;    //размер очереди
    private int[] queue;    // очередь
    private int front;      //маркер начала очереди
    private int rear;       //маркер конца очереди
    private int items;      //количество элементов в очереди

    public  MyQueue(int size){
        maxSize = size;
        queue = new int[maxSize];
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

    public void add(int value){
        if (rear == maxSize-1)
            rear = -1;
        queue[++rear] = value;
        items++;
    }

    public int remove(){
        int tmp = queue[front++];

        if (front==maxSize)
            front = 0;
        items--;

        return tmp;
    }

    public int peek(){
        return  queue[front];
    }

}
