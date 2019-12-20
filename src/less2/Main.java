package less2;

public class Main {


    private static void testSorts(IntArray array,  int arrsize, int indSort){
//инициализируем массив случайными числами
        array.RandomInit(arrsize);

// засекаем время выполинения сортировки
        long beginTime = System.nanoTime();
        switch (indSort){
            case 0: array.sortBubble(); break;
            case 1: array.sortSelect(); break;
            case 2: array.sortInsert(); break;
        }
        float deltaTime = (System.nanoTime() - beginTime) * 0.000000001f;

// формируем строку вывода времени выполнения и выводим на экран
        StringBuilder msg = new StringBuilder();
        switch (indSort){
            case 0: msg.append("Сортировка пузырьком. "); break;
            case 1: msg.append("Сортировка выбором. "); break;
            case 2: msg.append("Сортировка всавками. "); break;
        }

        msg.append("Время выполнения: " + deltaTime);
        System.out.println(msg);
    }

    public static void main(String[] args) {
        int arrsize = 1000000;
        IntArray arr = new IntArray();

//пузырек
        testSorts(arr,arrsize,0);
//выбором
        testSorts(arr,arrsize,1);
//вставками
        testSorts(arr,arrsize,2);

/* //тестирование методов

        arr.addElement(10);
        arr.addElement(7);
        arr.addElement(15);
        arr.addElement(7);
        arr.display();
        arr.deleteElement(7);
        arr.display();
        arr.deleteElementByInd(0);
        arr.display();

        System.out.println(arr.getElement(20));*/
    }
}
