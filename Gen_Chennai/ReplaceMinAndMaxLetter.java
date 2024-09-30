import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * TestABCDE   --> TsetABCDs
 *
 * find the min count and max count letter - and replace each other in the string..
 *
 *
 * If more than one letter has same count, then consider less precedance in the sorted order for Max count and
 *  high precedence in the sorted order for Min count
 *
 * example - e and t has 2 count which is max. So, consider e
 *
 * a,b,c,d,s has 1 count which is min coutn, here consider s
 *
 * replace s and e, each other
 */
public class ReplaceMinAndMaxLetter {



    public static void main(String[] args) {
        String s = "TestABCDE".toLowerCase();
        Map<String, Integer> map = new TreeMap<>();
        int i = 0;
        while(i<s.toCharArray().length){
            if(map.containsKey(String.valueOf(s.toCharArray()[i]))){
                map.put(String.valueOf(s.toCharArray()[i]),
                        map.get(String.valueOf(s.toCharArray()[i]))+1);
            } else {
                map.put(String.valueOf(s.toCharArray()[i]), 1);
            }
            i++;
        }

        Map minMap = new HashMap(); //S,1
        Map maxMap = new HashMap(); //E, 2

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (minMap.isEmpty()) {
                minMap.put(entry.getKey(), entry.getValue()); // A,1
            } else {
                if (minMap.containsValue((entry.getValue()))) {
                    minMap = new HashMap<>();
                    minMap.put(entry.getKey(), entry.getValue()); //s,1
                } else if (entry.getValue() > Integer.parseInt(minMap.values().stream().findFirst().orElse(0).toString()) &&
                        maxMap.isEmpty()) {
                    maxMap.put(entry.getKey(), entry.getValue()); //e,2
                }
            }

        }

        String minKey = minMap.keySet().stream().findFirst().orElse("").toString(); //s
        String maxKey = maxMap.keySet().stream().findFirst().orElse("").toString(); //e
        String tempKey = "$";
        String s1 = s.replace(minKey, tempKey); //Te$tABCDE
        String s2 = s1.replace(maxKey, minKey); //Ts$tABCDs
        String s3 = s2.replace(tempKey, maxKey); //TsetABCDs

        System.out.println(s3);
    }
}
