package less3;

public class MyPriorityQueue {
    private int maxSize;        //размер приоритетной очереди
    private int[] priorQueue;   // приоритетная очередь
    private int items;          // количество эл-тов

    public MyPriorityQueue(int i){
        maxSize = i;
        priorQueue = new int[maxSize];
        items = 0;
    }
    public void add(int value){
        int i;
        if(items==0)
            priorQueue[items++] = value;
        else{
            for(i=items-1; i>=0; i--){
                if( value > priorQueue[i] )
                    priorQueue[i+1] = priorQueue[i];
                else
                    break;
            }
            priorQueue[i+1] = value; // Вставка элемента
            items++;
        }
    }
    public int remove(){
        return priorQueue[--items];
    }
    public long peek(){
        return priorQueue[items-1];
    }

    public boolean isEmpty(){
        return (items==0);
    }
    public boolean isFull(){
        return (items == maxSize);
    }
    
}
