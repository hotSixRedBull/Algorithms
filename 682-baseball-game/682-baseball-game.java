class Solution {
    public int calPoints(String[] ops) {
        List<Integer> li = new ArrayList();
        int sum = 0;
        for (String op : ops) {
            int val = 0;
            switch(op) {
                case "D":
                    val = 2*li.get(li.size()-1);
                    sum += val;
                    li.add(val);
                    break;
                case "C":
                    sum -= li.get(li.size()-1);
                    li.remove(li.size()-1);
                    break;
                case "+":
                   val = li.get(li.size()-1)+li.get(li.size()-2);
                    sum += val;
                    li.add(val);
                    break;
                default:
                    val = Integer.parseInt(op);
                    sum += val;
                    li.add(val);
                    break;
            }
        }
        return sum;
    }
}