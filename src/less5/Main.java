package less5;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static int mypow(int x, int n){
        if (n==0){
            return 1;
        }
        else if (n==1){
            return x;
        }

        return mypow(x,n-1)*x;
    }
    public static void main(String[] args) {
//Задача 1
        Scanner in = new Scanner(System.in);
        System.out.println("Введите  число и степень, в которую его нужно возвести");
        int x = in.nextInt();
        int n = in.nextInt();
        if (n < 0) {
            System.out.println(1.0/mypow(x,Math.abs(n)));
        }
        else
            System.out.println(mypow(x,n));

//Задача 2

        ArrayList<Obj> items = new ArrayList<>();
        final int MAX_WEIGHT = 10;


        items.add(new Obj("Документы", 1, 1000));
        items.add(new Obj("Аптечка", 7, 740));
        items.add(new Obj("Планшет", 5, 10000));
        items.add(new Obj("Бутер", 2, 200));


        Backpack bp = new Backpack(MAX_WEIGHT);

        bp.MakeAllSets(items);
        ArrayList<Obj> bestSet = bp.getObjs();


        if(bestSet == null){
            System.out.println("Не найдено вещей, общеим весом <="+MAX_WEIGHT);
        }
        else{
            System.out.println("Содержимое рюкзака(максимальный вес "+MAX_WEIGHT+"): ");
            System.out.println(bp.toString());
            System.out.println("Общий вес рюкзака: "+ bp.totalWeight(bestSet));
            System.out.println("Стоимость рюкзака: "+ bp.getBestCost());
        }
    }

}
