class Solution {
    public int romanToInt(String s) {
        int start = s.length()-1;
        int sum = 0;
        while (start >= 0) {
            switch (s.charAt(start)) {
                case 'I':
                    sum++;
                    break;
                case 'V':
                    if (start > 0
                       && s.charAt(start-1) == 'I') {
                        sum += 4;
                        start--;
                    }
                    else {
                        sum += 5;
                    }
                    break;
                case 'X':
                    if (start > 0
                       && s.charAt(start-1) == 'I') {
                        sum += 9;
                        start--;
                    }
                    else {
                        sum += 10;
                    }
                    break;
                case 'L':
                    if (start > 0
                       && s.charAt(start-1) == 'X') {
                        sum += 40;
                        start--;
                    }
                    else {
                        sum += 50;
                    }
                    break;
                case 'C':
                    if (start > 0
                       && s.charAt(start-1) == 'X') {
                        sum += 90;
                        start--;
                    }
                    else {
                        sum += 100;
                    }
                    break;
                case 'D':
                    if (start > 0
                       && s.charAt(start-1) == 'C') {
                        sum += 400;
                        start--;
                    }
                    else {
                        sum += 500;
                    }
                    break;
                case 'M':
                    if (start > 0
                       && s.charAt(start-1) == 'C') {
                        sum += 900;
                        start--;
                    }
                    else {
                        sum += 1000;
                    }
                    break;
            }
            start--;
        }
        return sum;
    }
}