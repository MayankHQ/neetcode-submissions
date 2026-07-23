class Solution {
    public boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            char left = s.charAt(start);
            char right = s.charAt(end);

            // Skip non-alphanumeric
            if (!Character.isLetterOrDigit(left)) {
                start++;
                continue;
            }
            if (!Character.isLetterOrDigit(right)) {
                end--;
                continue;
            }

            // If mismatch, try skipping one character (either left or right)
            if (Character.toLowerCase(left) != Character.toLowerCase(right)) {
                return isPalindromeRange(s, start + 1, end) || isPalindromeRange(s, start, end - 1);
            }

            start++;
            end--;
        }

        return true;
    }

    // Helper: checks if substring is palindrome between i and j inclusive
    private boolean isPalindromeRange(String s, int i, int j) {
        while (i < j) {
            char left = s.charAt(i);
            char right = s.charAt(j);

            // Skip non-alphanumeric (safe reuse of main logic)
            if (!Character.isLetterOrDigit(left)) {
                i++;
                continue;
            }
            if (!Character.isLetterOrDigit(right)) {
                j--;
                continue;
            }
            if (Character.toLowerCase(left) != Character.toLowerCase(right)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
