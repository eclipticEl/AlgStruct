package less2;

public class IntArray {
    private final int  MAXSIZE = 10000000;
    private int[] arr; // целочисленный массив
    private int size;  // размер массива

    public IntArray(){
        this.size = 0;
        this.arr = new int[MAXSIZE];
    }
/*
*инициализация масиива случайными числами
* */
    public void RandomInit(int size){
        for (int i = 0; i <size ; i++) {
            arr[i] = (int) (Math.random() * 10);
        }
        this.size = size;
    }

/*
* Добавление элемента в массив
* */
    public boolean addElement(int value){
        boolean res = true;
        if (size == MAXSIZE)
           res = false;
        else {
            arr[size] = value;
            size++;
        }
        return  res;
    }

/*
*линейный поиск элемента value в массиве
* */
    public int findElementInd(int value){
        int res = -1;
        for (int i = 0; i < size ; i++) {
            if (arr[i] == value){
                res = i;
                break;
            }
        }
        return  res;
    }


/*
*удаление элементов со значением value из массива
* */

    public boolean deleteElement(int value){
        int ind = findElementInd(value);
        boolean res = false;
        while (ind != -1){

            for (int j = ind+1; j <size ; j++) {
                arr[j-1] = arr[j];
            }
            size --;
            if (!res)
                res = true;
            ind = findElementInd(value);
        }

        return res;
    }

/*
* удаление элемента по индексу
* */
    public boolean deleteElementByInd(int index){
        if (index < size) {
            for (int j = index + 1; j < size; j++) {
                arr[j - 1] = arr[j];
            }
            size--;

            return true;
        }
        else
            throw new ArrayIndexOutOfBoundsException("Указанный индекс"+index+" выходит за пределы масиива длинной " + size);

    }

/*
* получить элемент массива по индексу
* */
    public int getElement(int index){
        if (index < size)
            return arr[index];
        else
            throw new ArrayIndexOutOfBoundsException("Указанный индекс"+index+" выходит за пределы масиива длинной " + size);
    }

/*
* Отобразить массив в консоль
* */

    public void display(){
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println("");
    }
/*
* Сортировка пузырьком
* */
    public void sortBubble(){
        for (int i = size-1; i >=1; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j]>arr[j+1]){
                    changeElement(j,j+1);
                }
            }
        }

    }
/*
* Сортировка выбором
* */

    public void sortSelect(){
        int mark;
        for (int i = 0; i < size ; i++) {
            mark = i;
            for (int j = i+1; j < size; j++) {
                if (arr[j]< arr[mark]){
                    mark = j;
                }
            }
            changeElement(i,mark);
        }
    }
/*
* Сортировка вставкой
* */
    public void sortInsert(){
        for (int i = 1; i <size ; i++) {
            int tmp = arr[i];
            int j = i;
            while (j>0 && arr[j-1]>=tmp){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = tmp;
        }
    }

/*
* вспомогательная функция обмена элементов масиива
* */
    private void changeElement(int ind1, int ind2){
        int tmp = arr[ind1];
        arr[ind1] = arr[ind2];
        arr[ind2] = tmp;
    }
}
