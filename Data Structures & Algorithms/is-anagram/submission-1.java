class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sop = s.toCharArray();
        char[] top = t.toCharArray();

        Arrays.sort(sop);
        Arrays.sort(top);

        s = new String(sop);
        t = new String(top);

        return s.equals(t);
    }
}
