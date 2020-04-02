package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Date 02.04.2020.
 *
 *  1268. Search Suggestions System
 *
 *  Given an array of strings products and a string searchWord.
 *  We want to design a system that suggests at most three product names from products after each character of searchWord is typed.
 *  Suggested products should have common prefix with the searchWord.
 *  If there are more than three products with a common prefix return the three lexicographically minimums products.
 *
 * Return list of lists of the suggested products after each character of searchWord is typed.
 *
 * https://leetcode.com/problems/search-suggestions-system/
 */

public class SearchSuggestionsSystem {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        List<List<String>> res = new ArrayList<>();
        Arrays.sort(products);

        for (int i = 0; i < searchWord.length(); i++) {
            String sub = searchWord.substring(0, i+1);
            List<String> list = new ArrayList<>();

            for (String product : products) {
                if (list.size() == 3)
                    break;

                if (product.startsWith(sub)) {
                    list.add(product);
                }
            }

            res.add(list);
        }

        return res;
    }
}
