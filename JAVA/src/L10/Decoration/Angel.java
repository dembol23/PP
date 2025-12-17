package L10.Decoration;
import static L10.main.*;
import java.text.BreakIterator;
public class Angel implements Decoration {
    @Override
    public String[] decorate(String[] tree) {
        if (tree.length == 0) return tree;
        String row = tree[0];
        BreakIterator boundary = BreakIterator.getCharacterInstance();
        boundary.setText(row);
        int start = boundary.first();
        for (int end = boundary.next(); end != BreakIterator.DONE; start = end, end = boundary.next()) {
            String grapheme = row.substring(start, end);
            if (!grapheme.isBlank()) {
                StringBuilder sb = new StringBuilder(row);
                sb.replace(start, end, angelChar);
                tree[0] = sb.toString();
                break;
            }
        }
        return tree;
    }
}
