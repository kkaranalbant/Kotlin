import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

    }

    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < items1.length; i++) {
            List<Integer> subResult = new ArrayList<>();
            subResult.add(items1[i][0]);
            subResult.add(items1[i][1] + getValue(items2, items1[i][0]));
            result.add(subResult);
        }
        for (int i = 0; i < items2.length; i++) {
            if (!containsKey(result, items2[i][0])) {
                List<Integer> subResult = new ArrayList<>();
                subResult.add(items2[i][0]);
                subResult.add(items2[i][1] + getValue(items1, items2[i][0]));
                result.add(subResult);
            }
        }
        sort(result);
        return result;
    }

    public int getValue(int[][] items, int key) {
        int result = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i][0] == key) {
                result = items[i][1];
                break;
            }
        }
        return result;
    }

    public boolean containsKey(List<List<Integer>> list, int key) {
        for (List<Integer> subList : list) {
            if (subList.get(0) == key) return true;
        }
        return false;
    }

    public void sort(List<List<Integer>> list) {
        int minIndex = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = minIndex; j < list.size(); j++) {
                if (list.get(minIndex).get(0) > list.get(j).get(0)) {
                    List<Integer> newMin = list.get(j);
                    list.set(j, list.get(minIndex));
                    list.set(minIndex, newMin);
                }
            }
            minIndex++;
        }
    }




    public List<List<Integer>> mergeSimilarItems2 (int[][] items1, int[][] items2) {
        TreeMap<Integer,Integer> map = new TreeMap<>() ;

        for (int i = 0 ; i < items1.length ; i++) {
                map.put(items1[i][0] , items1[i][1]) ;
        }
        for (int i = 0; i < items2.length; i++) {
            if (map.containsKey(items2[i][0])) {
                map.put(items2[i][0] , map.get(items2[i][0]) + items2[i][1]) ;
            }
        }
        List<List<Integer>> result = new ArrayList<>() ;
        for(Map.Entry<Integer , Integer> entry : map.entrySet()) {
            List<Integer> subList = new ArrayList<>() ;
            subList.add(entry.getKey());
            subList.add(entry.getValue()) ;
            result.add(subList) ;
        }
        return result ;
    }


}