class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str: strs) {
            int len = str.length();
            sb.append(len).append('#').append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        int len = str.length();
        List<String> strs = new ArrayList<>();
        if (len == 0) {
            return strs;
        }

        int i = 0;
        while (i < len) {
            // get the word length
            int wordLen = 0;
            while (str.charAt(i) != '#') {
                wordLen = wordLen * 10 + str.charAt(i) - '0';
                i++;
            }

            // skip the '#'
            i++;

            // get next word of length "wordLen"
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < wordLen; j++, i++) {
                sb.append(str.charAt(i));
            }
            strs.add(sb.toString());
        }
        return strs;
    }
}
