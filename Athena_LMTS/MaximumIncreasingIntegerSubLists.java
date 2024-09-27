import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MaximumIncreasingIntegerSubLists {

    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(9);
        integerList.add(5);
        integerList.add(23);
        integerList.add(45);
        integerList.add(78);
        integerList.add(63);
        integerList.add(7);
        integerList.add(81);
        OrderOfNSquareApproach(integerList);
        OrderOfNApproach(integerList);
    }

    private static void OrderOfNApproach(List<Integer> integerList) {
        List<List<Integer>> increasingSubsets = new ArrayList<>();
        List<Integer> currentSubset = new ArrayList<>();

        for (int i=0; i<integerList.size(); i++){
            if(currentSubset.isEmpty() || integerList.get(i)>currentSubset.get(currentSubset.size()-1)){
                currentSubset.add(integerList.get(i));
            } else {
                if(!currentSubset.isEmpty()){
                    increasingSubsets.add(currentSubset);
                }
                currentSubset = new ArrayList<>(Arrays.asList(integerList.get(i)));
            }
        }
        if(!currentSubset.isEmpty()){
            increasingSubsets.add(currentSubset);
        }

        System.out.println("Largest Sub set is "+increasingSubsets.stream().max(Comparator.comparing(List::size)).get());
    }

    private static void OrderOfNSquareApproach(List<Integer> integerList) {
        List<List<Integer>> integerSubSet = new ArrayList<>();

        int p1=0, p2 = 0;
        int i = 0,j=1;

        while(i<integerList.size()-1){
            List<Integer> subSet = new ArrayList<>();
            p1=integerList.get(i);
            subSet.add(p1);
            while (j<integerList.size()) {
                p2=integerList.get(j);
                if(p1<p2){
                    subSet.add(p2);
                    i++;
                    j++;
                    p1=p2;
                } else {
                    i=j;
                    j=i+1;
                    break;
                }
            }
            //System.out.println(subSet);
            integerSubSet.add(subSet);
        }
        //integerSubSet.forEach(subList -> System.out.println("Sublist: " + subList + ", Size: " + subList.size()));
        System.out.println("Largest Subset is "+integerSubSet.stream().max(Comparator.comparing(List::size)).get());
    }
}
