package practice;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ayokota on 8/4/20.
 */
public class AmazonFresh {

    public static int azfresh(String[][] combos, String[] shoppingCart) {
        int nextIndex = 0;
        for(String[] combo : combos) {
            int idx = azfreshHelper(combo, shoppingCart, 0, nextIndex, new HashSet<>());
            if(idx == -1)
                return 0;
            nextIndex = idx;
            for(int i = 0; i < combo.length; i++) {
                shoppingCart[idx--] = "";
            }
//            for(String x : shoppingCart)
//                System.out.print(x + ", ");
//            System.out.println();

        }

        return 1;
    }

    public static int azfreshHelper(String[] combo, String[] shoppingCart, int comboIndex, int shoppingCartIndex, Set<String> visitedKeys) {
        String key = comboIndex + ":" + shoppingCartIndex;
        if(visitedKeys.contains(key))
            return -1;

//        System.out.println(key);

        visitedKeys.add(key);

        if(shoppingCartIndex >= shoppingCart.length || comboIndex >= combo.length) {
            return -1;
        }

        if((combo[comboIndex] == shoppingCart[shoppingCartIndex] || combo[comboIndex].equals("anything"))
                && comboIndex == combo.length - 1) {
            return shoppingCartIndex;
        } else if (combo[comboIndex] == shoppingCart[shoppingCartIndex] || combo[comboIndex].equals("anything")) {
            return Math.max(azfreshHelper(combo, shoppingCart, comboIndex + 1, shoppingCartIndex + 1, visitedKeys),
                    azfreshHelper(combo, shoppingCart, 0, shoppingCartIndex + 1, visitedKeys));
        }

        return azfreshHelper(combo, shoppingCart, 0, shoppingCartIndex + 1, visitedKeys);
    }


    public static void main(String[] args) {
        String[][] combos1 = new String[][] {
                {"apple", "apple"},
                {"banana", "anything", "banana"}
        };
        System.out.println(azfresh(combos1, new String[] {"orange", "apple", "apple", "banana", "orange", "banana"}) == 1);
        System.out.println(azfresh(combos1, new String[] {"apple", "apple", "banana", "orange", "banana"}) == 1);

        System.out.println(azfresh(combos1, new String[]{"banana", "orange", "banana", "apple", "apple"}) == 0);
        System.out.println(azfresh(combos1, new String[]{"apple", "banana", "apple", "banana", "orange", "banana"}) == 0);

        String[][] combos2 = new String[][] {
                {"apple", "apple"},
                {"apple", "apple", "banana"}
        };
        System.out.println(azfresh(combos2, new String[]{"apple", "apple", "apple", "banana"}) == 0);

    }
}
