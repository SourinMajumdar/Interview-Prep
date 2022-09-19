// Link: https://leetcode.com/problems/find-duplicate-file-in-system/
// Solution: Coding decoded

class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();        // Map<Content, List<Directory + File name>>

        for (String path : paths) {             // example: path = "root/a 1.txt(abcd) 2.txt(efgh)"
            String[] dir = path.split(" ");     // ["root/a", "1.txt(abcd)", "2.txt(efgh)"]
            String rootPath = dir[0];           // "root/a"

            for (int i = 1; i < dir.length; i++) {
                int openingBracket = dir[i].indexOf("(");
                int closingBracket = dir[i].indexOf(")");

                String content = dir[i].substring(openingBracket, closingBracket);    // "abcd" or "efgh" (content is enclosed in () so we extract that)
                if (!map.containsKey(content)) {            // if "abcd" not present in map keySet
                    map.put(content, new ArrayList<>());    // put "abcd" in keyset and a new list as value which will store rootpath and filenames for same content
                }

                // add that rootpath and filename in the value list corresponding to that content which exists already
                map.get(content).add(rootPath + "/" + dir[i].substring(0, openingBracket));    // ["root/a/1.txt", root/c/2.txt"] like that
            }
        }


        List<List<String>> ans = new ArrayList<>();

        for (String strKey : map.keySet()) {
            if (map.get(strKey).size() > 1) {        // value list size for a content (key) greater than 1 implies duplicacy of that content
                ans.add(map.get(strKey));            // add that list to the answer list
            }
        }

        return ans;

        // return map.values().stream().filter(g -> g.size() > 1).collect(Collectors.toList());
    }
}

// TC: O(n * m) + O(n)  => O(n * m); n is the length of paths and m is the maximum length of dir
// SC: O(n) (Ignoring the arraylist that we return)




