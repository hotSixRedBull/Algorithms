class Solution {
    public String pushDominoes(String dominoes) {
        int[] leftR = new int[dominoes.length()];
        int[] rightL = new int[dominoes.length()];
        
        int closestR = 10001;
        for (int i=0; i<dominoes.length(); i++) {
            leftR[i] = closestR;
            if (dominoes.charAt(i) == 'R') {
                closestR = 0;
            }
            else if (dominoes.charAt(i) == 'L') {
                closestR = 10001;
            }
            if (closestR < 10000) {
                closestR++;
            }
        }
        // System.out.println(Arrays.toString(leftR));
        
        int closestL = 10001;
        for (int i=dominoes.length()-1; i>=0; i--) {
            rightL[i] = closestL;
            if (dominoes.charAt(i) == 'L') {
                closestL = 0;
            }
            else if (dominoes.charAt(i) == 'R') {
                closestL = 10001;
            }
            if (closestL < 10000) {
                closestL++;
            }
        }
        // System.out.println(Arrays.toString(rightL));
        
        char[] arr = dominoes.toCharArray();
        for (int i=0; i<dominoes.length(); i++) {
            if (arr[i] == '.') {
                if (leftR[i] < rightL[i]) {
                    arr[i] = 'R';
                }
                else if (leftR[i] > rightL[i]) {
                    arr[i] = 'L';
                }
            }
        }
        return new String(arr);
    }
}

/*
"RR.L"
".L.R...LR..L.."
"L"
"R"
"."
"..R.."
*/