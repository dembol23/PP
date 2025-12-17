package L10.Decoration;

import java.util.Random;

import static L10.main.*;

public class Bubbles implements Decoration {
    @Override
    public String[] decorate(String[] tree) {
        Random random = new Random();
        int counter = 0;
        int step = treeChar.length();
        for (int i = 0; i < tree.length; i++) {
            String row = tree[i];
            StringBuilder res = new StringBuilder();
            int j = 0;
            while (j < row.length()) {
                if (row.startsWith(treeChar, j)) {
                    if (++counter == 3) {
                        res.append(bubbleChar);
                        counter = random.nextInt(2);
                    } else {
                        res.append(treeChar);
                    }
                    j += step;
                } else {
                    res.append(row.charAt(j));
                    j++;
                }
            }
            tree[i] = res.toString();
        }
        return tree;
    }
}
