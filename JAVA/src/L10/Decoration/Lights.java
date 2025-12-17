package L10.Decoration;
import java.text.BreakIterator;
import static L10.main.*;

public class Lights implements Decoration {
    @Override
    public String[] decorate(String[] tree) {
        for (int i = 0; i < tree.length; i++) {
            String row = tree[i];
            BreakIterator boundary = BreakIterator.getCharacterInstance();
            boundary.setText(row);
            int start = boundary.first();
            int firstVisIdx = -1;
            int firstVisEnd = -1;

            int lastVisIdx = -1;
            int lastVisEnd = -1;

            for (int end = boundary.next(); end != BreakIterator.DONE; start = end, end = boundary.next()) {
                String grapheme = row.substring(start, end);
                if (!grapheme.isBlank()) {
                    if (firstVisIdx == -1) {
                        firstVisIdx = start;
                        firstVisEnd = end;
                    }
                    lastVisIdx = start;
                    lastVisEnd = end;
                }
            }
            if (firstVisIdx == -1) continue;
            StringBuilder sb = new StringBuilder();
            sb.append(row, 0, firstVisIdx);
            sb.append(lightChar);
            if (firstVisIdx != lastVisIdx) {
                sb.append(row, firstVisEnd, lastVisIdx);
                sb.append(lightChar);
            }
            if (lastVisEnd < row.length()) {
                sb.append(row.substring(lastVisEnd));
            }
            tree[i] = sb.toString();
        }
        return tree;
    }
}
