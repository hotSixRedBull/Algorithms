class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            StringBuilder sb = new StringBuilder();
            int index = 0;
            //local name
            for (; index<email.length(); index++) {
                if (email.charAt(index) == '+'
                    || email.charAt(index) == '@') {
                    break;
                }
                else if (email.charAt(index) == '.') {
                    continue;
                }
                sb.append(email.charAt(index));
            }
            while (email.charAt(index) != '@') {
                index++;
            }
            //domain
            for (; index<email.length(); index++) {
                sb.append(email.charAt(index));
            }
            set.add(sb.toString());
            //System.out.println(sb.toString());
        }
        return set.size();
    }
}
/*
Approach 1: Linear Iteration
Approach 2: Using String Split Method
*/