package L10;

import L10.Decoration.Decoration;

import static L10.Decoration.DecorationFactory.getDecoration;

public abstract class ChristmasTree {
    int height;
    String[] tree;
    public ChristmasTree(int height) {
        this.height = height;
    }

    abstract void generateTree();

    void decorate(String name) {
        Decoration dec = getDecoration(name);
        tree = dec.decorate(tree);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < height; i++) {
            sb.append(tree[i]);
            sb.append("\n");
        }
        return sb.toString();
    }
}
