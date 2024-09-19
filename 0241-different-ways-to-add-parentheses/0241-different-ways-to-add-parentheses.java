//skip
class Solution {

    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> results = new ArrayList<>();

        // Base case: if the string is empty, return an empty list
        if (expression.length() == 0) return results;

        // Base case: if the string is a single character, treat it as a number and return it
        if (expression.length() == 1) {
            results.add(Integer.parseInt(expression));
            return results;
        }

        // If the string has only two characters and the first character is a digit, parse it as a number
        if (
            expression.length() == 2 && Character.isDigit(expression.charAt(0))
        ) {
            results.add(Integer.parseInt(expression));
            return results;
        }

        // Recursive case: iterate through each character
        for (int i = 0; i < expression.length(); i++) {
            char currentChar = expression.charAt(i);

            // Skip if the current character is a digit
            if (Character.isDigit(currentChar)) continue;

            // Split the expression into left and right parts
            List<Integer> leftResults = diffWaysToCompute(
                expression.substring(0, i)
            );
            List<Integer> rightResults = diffWaysToCompute(
                expression.substring(i + 1)
            );

            // Combine results from left and right parts
            for (int leftValue : leftResults) {
                for (int rightValue : rightResults) {
                    int computedResult = 0;

                    // Perform the operation based on the current character
                    switch (currentChar) {
                        case '+':
                            computedResult = leftValue + rightValue;
                            break;
                        case '-':
                            computedResult = leftValue - rightValue;
                            break;
                        case '*':
                            computedResult = leftValue * rightValue;
                            break;
                    }

                    results.add(computedResult);
                }
            }
        }

        return results;
    }
}
/*
class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> ans = new ArrayList();
        Set<Character> operator = new HashSet();
        operator.add('+');
        operator.add('-');
        operator.add('*');
        operator.add('/');
        List<Integer> nums = new ArrayList();
        List<Character> ops = new ArrayList();
        int prev = 0;
        for (int i=0; i<expression.length(); i++) {
            if (operator.contains(expression.charAt(i))) {
                int num = Integer.parseInt(expression.substring(prev, i), 10);
                nums.add(num);
                ops.add(expression.charAt(i));
            }
        }
        calc(ans, nums, ops, pq, cur);
        return ans;
    }
    
    public void calc(List<Integer> ans, 
                     List<Integer> nums, 
                     List<Character> ops,
                     PriorityQueue<int[]> pq) {
        if (pq.size() == nums.size()-2) {
            //calc
            //add to ans
            return;
        }
        
    }
}


/*
2*3-4*5
(2*(3-(4*5))) = -34 
((2*3)-(4*5)) = -14 
((2*(3-4))*5) = -10 
(2*((3-4)*5)) = -10 
(((2*3)-4)*5) = 10

(숫자의 개수 - 1) ==> number of parenthesis

[0,6], [2,6], [4,6]
[0,6], [0,2], [4,6]
[0,6], [0,4], [2,4]
*/