package L10;

import static L10.main.treeChar;

public class PineTree extends ChristmasTree {
    public PineTree(int height) {
        if (height < 1) {
            throw new IllegalArgumentException("Height must be greater than 1");
        }
        super(height);
    }

    @Override
    void generateTree() {
        tree = new String[height];
        for (int i = 0; i < height; i++) {
            int spaces = height - i - 1;
            int stars = (2 * i) + 1;
            String res = "  ".repeat(spaces) + treeChar.repeat(stars);
            tree[i] = res;
        }
    }
}
