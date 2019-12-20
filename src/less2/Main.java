package less2;

public class Main {


    private static void testSorts(IntArray array,  int arrsize, int indSort){

        array.RandomInit(arrsize);
//        array.display();

        long beginTime = System.nanoTime();
        switch (indSort){
            case 0: array.sortBubble(); break;
            case 1: array.sortSelect(); break;
            case 2: array.sortInsert(); break;
        }
        float deltaTime = (System.nanoTime() - beginTime) * 0.000000001f;

//        array.display();

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

        testSorts(arr,arrsize,0);
        testSorts(arr,arrsize,1);
        testSorts(arr,arrsize,2);

    }
}
