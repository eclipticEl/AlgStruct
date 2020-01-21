package less5;

import java.util.ArrayList;
public class Backpack {

    private double maxWeight;
    private double bestCost;

    private ArrayList<Obj> objs = new ArrayList<>();

    public Backpack(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public ArrayList<Obj> getObjs() {
        return objs;
    }

    public double getBestCost() {
        return bestCost;
    }

    public double totalWeight(ArrayList<Obj> objset){
        double sum = 0;

        for (Obj obj : objset) {
            sum += obj.getWeight();
        }

        return  sum;
    }

    public double totalCost(ArrayList<Obj> objset){
        double sum = 0;

        for (Obj obj : objset) {
            sum += obj.getPrice();
        }

        return  sum;
    }

    private void CheckSet(ArrayList<Obj> objset){
        if ((objs == null && totalWeight(objset) <= maxWeight) || (totalWeight(objset) <= maxWeight && totalCost(objset) > bestCost) ){
            objs = objset;
            bestCost = totalCost(objset);
        }
    }

    public void MakeAllSets(ArrayList<Obj> objset)
    {
        if (!objset.isEmpty()) {
            CheckSet(objset);
        }

        for (Obj obj : objset) {
            ArrayList<Obj> newSet = new ArrayList<>(objset);
            newSet.remove(obj);
            MakeAllSets(newSet);
        }
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        for (Obj obj : objs) {
            sb.append(obj.getName()+"(вес:" + obj.getWeight()+ ", ценность:"+ obj.getPrice()+ "); ");
        }
        return sb.toString();
    }
}
