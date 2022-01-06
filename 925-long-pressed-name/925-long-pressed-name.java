class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int targetIndex = 0;
        char prev = 'A';
        for (int i=0; i<typed.length(); i++) {
            if (targetIndex >= name.length()) {
                if (prev == typed.charAt(i)) {
                    continue;
                }
                else {
                    return false;
                }
            }
            else if (name.charAt(targetIndex) == typed.charAt(i)) {
                targetIndex++;
            }
            else if (prev == typed.charAt(i)) {
                continue;
            }
            else {
                return false;
            }
            prev = typed.charAt(i);
        }
        return targetIndex == name.length();
    }
}