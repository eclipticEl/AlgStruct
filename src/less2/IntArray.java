package less2;

public class IntArray {
    private final int  MAXSIZE = 10000000;
    private int[] arr; // целочисленный массив
    private int size;  // размер массива

    public IntArray(){
        this.size = 0;
        this.arr = new int[MAXSIZE];
    }

    public void RandomInit(int size){
        for (int i = 0; i <size ; i++) {
            arr[i] = (int) (Math.random() * 10);
        }
        this.size = size;
    }

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
    public boolean deleteElement(int value){
        int ind = -1;
        for (int i = 0; i < size; i++) {
            if (arr[i] == value){
                ind = i;
                break;
            }
        }
        if (ind != -1){
            for (int j = ind+1; j <size ; j++) {
                arr[j-1] = arr[j];
            }
            size --;
        }
        return (ind!=-1);
    }

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

    public int getElement(int index){
        if (index < size)
            return arr[index];
        else
            throw new ArrayIndexOutOfBoundsException("Указанный индекс"+index+" выходит за пределы масиива длинной " + size);
    }

    public void display(){
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println("");
    }

    public void sortBubble(){
        for (int i = size-1; i >=1; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j]>arr[j+1]){
                    changeElement(j,j+1);
                }
            }
        }

    }


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


    private void changeElement(int ind1, int ind2){
        int tmp = arr[ind1];
        arr[ind1] = arr[ind2];
        arr[ind2] = tmp;
    }



}
