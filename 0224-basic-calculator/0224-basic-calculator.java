class Solution {
    public int calculate(String s) {
        char[] arr = s.toCharArray();
        return calcExpression(arr, 0, arr.length);
    }
    public int calcExpression(char[] arr, int start, int end) {
        Integer acc = null;
        Integer next = null;
        boolean isAccExist = false;
        char op = 0;
        for (int i=start; i<end; i++) {
            if (arr[i] == ' ') {
                continue;
            }

            if (arr[i] == '(') {
                int score = 1;
                int iSave = i;
                while (score > 0) {
                    i++;
                    if (arr[i] == ')') {
                        score--;
                    }
                    else if (arr[i] == '(') {
                        score++;
                    }
                }
                if (op == 0) {
                    acc = calcExpression(arr, iSave+1, i);
                }
                else if (op == '+') {
                    acc += calcExpression(arr, iSave, i);
                }
                else if (op == '-') {
                    if (acc == null) {
                        acc = calcExpression(arr, iSave, i);
                        // acc *= -1;  
                    }
                    else {
                        next = calcExpression(arr, iSave, i);
                    }
                }
            }
            else if (arr[i] == '+'
            || arr[i] == '-') {
                if (next != null) {
                    if (op == '+') {
                        acc = acc + next;
                    }
                    else {
                        acc = acc - next;
                    }
                    next = null;
                }
                else {
                    if (op == '-') {
                        acc *= -1;
                    }
                }
                op = arr[i];
                if (acc != null) {
                    isAccExist = true;
                }
            }
            else {
                if (!isAccExist) {
                    if (acc == null) {
                        acc = 0;
                    }
                    acc *= 10;
                    acc += arr[i] - '0';
                }
                else {
                    if (next == null) {
                        next = 0;
                    }
                    next *= 10;
                    next += arr[i] - '0';
                }
            }
        }
        if (next != null) {
            if (op == '+') {
                acc = acc + next;
            }
            else {
                acc = acc - next;
            }
        }
        else {
            if (op == '-') {
                acc = acc*-1;
            }
        }
        return acc.intValue();
    }
}