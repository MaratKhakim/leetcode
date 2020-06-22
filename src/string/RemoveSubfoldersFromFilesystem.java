package string;

import java.util.*;

/**
 * Date 22.06.2020.
 *
 * 1233. Remove Sub-Folders from the Filesystem
 *
 * Given a list of folders, remove all sub-folders in those folders and return in any order the folders after removing.
 * If a folder[i] is located within another folder[j], it is called a sub-folder of it.
 *
 * The format of a path is one or more concatenated strings of the form: / followed by one or more lowercase English letters.
 * For example, /leetcode and /leetcode/problems are valid paths while an empty string and / are not.
 *
 * https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/
 */

public class RemoveSubfoldersFromFilesystem {
    public List<String> removeSubfolders(String[] folder) {
        Node root = new Node();
        List<String> list = new ArrayList<>();

        Arrays.sort(folder);

        for (String sub : folder) {
            String[] paths = sub.split("/");
            Node curr = root;

            for (String path : paths) {
                Node child = curr.children.get(path);

                if (child == null) {
                    child = new Node();
                    curr.children.put(path, child);
                }
                curr = child;

                if (curr.isEnd)
                    break;
            }

            if (!curr.isEnd)
                list.add(sub);

            curr.isEnd = true;
        }

        return list;
    }

    class Node {
        Map<String, Node> children;
        boolean isEnd;

        public Node () {
            children = new HashMap<>();
            isEnd = false;
        }
    }
}
