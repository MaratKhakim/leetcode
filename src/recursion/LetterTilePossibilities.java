package recursion;

import java.util.HashSet;
import java.util.Set;

/**
 * Date 24.04.2020.
 *
 * 1079. Letter Tile Possibilities
 *
 * You have a set of tiles, where each tile has one letter tiles[i] printed on it.
 * Return the number of possible non-empty sequences of letters you can make.
 *
 * https://leetcode.com/problems/letter-tile-possibilities/
 */

public class LetterTilePossibilities {
    public int numTilePossibilities(String tiles) {
        Set<String> set = new HashSet();
        boolean[] seen = new boolean[tiles.length()];

        construct(tiles.toCharArray(), seen, new StringBuilder(), set);

        return set.size();
    }

    private void construct(char[] tiles, boolean[] seen, StringBuilder sb, Set<String> set) {
        String str = sb.toString();

        if (set.contains(str))
            return;

        if (sb.length() > 0)
            set.add(str);

        for (int i = 0; i < tiles.length; i++) {
            if (seen[i])
                continue;

            seen[i] = true;
            sb.append(tiles[i]);
            construct(tiles, seen, sb, set);
            sb.deleteCharAt(sb.length()-1);
            seen[i] = false;
        }
    }
}
