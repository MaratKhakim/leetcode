package string;

import java.util.*;

/**
 *  609. Find Duplicate File in System
 *
 *  Given a list of directory info including directory path, and all the files with contents in this directory,
 *  you need to find out all the groups of duplicate files in the file system in terms of their paths.
 *
 * A group of duplicate files consists of at least two files that have exactly the same content.
 *
 * https://leetcode.com/problems/find-duplicate-file-in-system/
 */

public class FindDuplicateFileInSystem {
    public static List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String path : paths) {
            String[] files = path.split(" ");

            for (int i = 1; i < files.length; i++) {
                String file = files[i];
                String[] sep = file.split("\\(");
                String content = sep[1].substring(0, sep[1].length()-1);

                String fullPath = files[0]+"/"+sep[0];

                if (map.containsKey(content)) {
                    map.get(content).add(fullPath);
                } else {
                    List<String> list = new ArrayList<>();
                    list.add(fullPath);
                    map.put(content, list);
                }
            }
        }

        for(String key : map.keySet()) {
            List<String> list = map.get(key);

            if (list.size() > 1)
                res.add(map.get(key));
        }

        return res;
    }

    public static void main(String[] args) {
        String[] paths = {"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"};
        List<List<String>> result = findDuplicate(paths);

        for (List<String> list : result) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
