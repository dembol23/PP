package L10.Decoration;

import java.text.BreakIterator;
import static L10.main.*;

public class Chain implements Decoration {
    @Override
    public String[] decorate(String[] tree) {
        for (int i = 0; i < tree.length; i++) {
            String row = tree[i];
            BreakIterator boundary = BreakIterator.getCharacterInstance();
            boundary.setText(row);
            StringBuilder sb = new StringBuilder();
            int start = boundary.first();
            int currentVisualIndex = 0;
            for (int end = boundary.next(); end != BreakIterator.DONE; start = end, end = boundary.next()) {
                String grapheme = row.substring(start, end);
                if (!grapheme.isBlank()) {
                    if ((currentVisualIndex + i) % 3 == 0) {
                        sb.append(chainChar);
                    } else {
                        sb.append(grapheme);
                    }
                    currentVisualIndex++;
                } else {
                    sb.append(grapheme);
                }
            }
            tree[i] = sb.toString();
        }
        return tree;
    }
}