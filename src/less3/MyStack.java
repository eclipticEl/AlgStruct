package less3;

public class MyStack {
    private int maxSize;  // размер стека
    private int[] stack;  // стек
    private int top;      // указатель верхушки стека: -1- стек пустой

    public MyStack(int size){
        maxSize = size;
        stack = new int[maxSize];
        top = -1;
    }

    public boolean isEmpty(){
        return (top==-1);
    }

    public  boolean isFull(){
        return top == (maxSize-1);
    }

    public  void  push(int value){
        stack[++top] = value;
    }

    public  int pop(){
        return  stack[top--];
    }

    public int peek(){
        return stack[top];
    }

}
