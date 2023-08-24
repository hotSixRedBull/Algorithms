class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList();
        List<String> built = new ArrayList();
        int sum = 0;
        int cnt = 0;
        for (String s : words) {
            if (sum + cnt + s.length() > maxWidth) {
                int left = maxWidth-sum;
                String line = "";
                if (built.size() == 1) {
                    String blank = " ";
                    line = built.get(0) + blank.repeat(left);
                }
                else if (left % (built.size()-1) == 0) {
                    int each = left/(built.size()-1);
                    String blank = " ";
                    blank = blank.repeat(each);
                    line = built.get(0);
                    for (int i=1; i<built.size(); i++) {
                        line += blank + built.get(i);
                    }
                }
                else {
                    int remainder = left%(built.size()-1);
                    int each = (left-remainder)/(built.size()-1);
                    String blank = " ";
                    line = built.get(0);
                    blank = " ";
                    blank = blank.repeat(each);
                    for (int i=1; i<built.size(); i++) {
                        if (remainder > 0) {
                            line += " ";
                            remainder--;
                        }
                        line += blank + built.get(i);
                    }
                }
                result.add(line);
                built = new ArrayList();
                built.add(s);
                sum = s.length();
                cnt = 1;
            }
            else {
                built.add(s);
                sum += s.length();
                cnt++;
            }
        }
        String last = built.get(0);
        for (int i=1; i<built.size(); i++) {
            last += " " + built.get(i);
        }
        String blank = " ";
        last += blank.repeat(maxWidth-last.length());
        result.add(last);
        return result;
    }
}