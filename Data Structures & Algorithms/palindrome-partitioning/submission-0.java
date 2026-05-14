class Solution {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>());
        return res;
    }

    private void backtrack(String s, int index, List<String> curr) {
        // base case: we've successfully partitioned the string in to palindromes 
        // and added the individual palindromes in to curr
        if (index == s.length()) {
            res.add(new ArrayList<>(curr));
            return;
        }

        // make partition from index to end of string
        for (int i = index; i < s.length(); i++) {
            // each partition is is a substring from "index" to "i"
            
            // if a partition is palindrome, add it to curr and recurse, finally backtrack
            if (isPalindrome(s, index, i)) {
                String substr = s.substring(index, i+1);
                curr.add(substr);
                backtrack(s, i+1, curr);
                curr.remove(curr.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
