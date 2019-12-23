package less3;

import java.util.Scanner;

public class Main {

    public static void testStack(){
        int i=0;

        System.out.println("Тестируем стек");
        MyStack  stack = new MyStack(10);
        while (!stack.isFull()){
            i = (int) (Math.random()*10);
            stack.push(i);
            System.out.print(" "+i);
        }
        System.out.println("");
        System.out.println("Извлекаем два элемента: " +stack.pop()+ " "+ stack.pop());

    }

    public static void testQueue(){
        int i=0;

        System.out.println("Тестируем очередь");
        MyQueue queue = new MyQueue(10);
        while (!queue.isFull()){
            i = (int) (Math.random()*10);
            queue.add(i);
            System.out.print(" "+i);
        }
        System.out.println("");
        System.out.println("Извлекаем два элемента: " +queue.remove()+ " "+ queue.remove());
    }

    public static void testDeque(){
        int i;

        System.out.println("Тестируем дек. Четные слева, нечетные справа");

        MyDeque  deque = new MyDeque(10);
        while (!deque.isFull()){
            i = (int) (Math.random()*10);
            if (i % 2 ==0)
                deque.addLeft(i);
            else
                deque.addRight(i);
            System.out.print(" "+i);
        }
        System.out.println("");
        System.out.println("Извлекаем элемента слева и элемент справа: " +deque.removeLeft()+ " "+ deque.removeRight());
    }

// переворачиваем строку
    public static void reverseString(int methodtype){
        Scanner in = new Scanner(System.in);

        while(true){
            String str = in.nextLine();
            if (str.equals("")){
                break;
            }

            StringBuilder reversestr = new StringBuilder();

            if (methodtype ==0 ) {   // на основе стека
                MyStack stack = new MyStack(str.length());
                for (int i = 0; i < str.length(); i++) {
                    stack.push((int) str.charAt(i));
                }

                while (!stack.isEmpty()) {
                    reversestr.append((char) stack.pop());
                }
            }
            else if (methodtype == 1 ){  // на основе массива
                for (int i = str.length()-1; i >=0 ; i--) {
                    reversestr.append(str.charAt(i));
                }
            }
            else { // на основе функции класса
                reversestr = new StringBuilder(str).reverse();
            }

            System.out.println(reversestr);
        }
    }
    public static void main(String[] args) {
        testStack();
        testQueue();
        testDeque();

        reverseString(0);
    }

}
