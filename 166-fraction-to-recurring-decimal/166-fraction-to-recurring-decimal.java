class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        String frontMatter = "";
        if ((numerator < 0 && denominator > 0 )|| (numerator > 0 && denominator < 0)) {
            frontMatter = "-";
        }
        long numeratorLong = numerator;
        long denominatorLong = denominator;
        numeratorLong = Math.abs(numeratorLong);
        denominatorLong = Math.abs(denominatorLong);
        long intPart = numeratorLong/denominatorLong;
        numeratorLong -= intPart*denominatorLong;
        
        ArrayList<String> al = new ArrayList<>();
        HashMap<Long, Integer> repeatMap = new HashMap<>();
        boolean isRepeat = false;
        int repeatStart = 0;
        while (numeratorLong != 0) {
            numeratorLong *= 10;
            long cur = numeratorLong/denominatorLong;
            if (repeatMap.containsKey(numeratorLong)) {
                isRepeat = true;
                repeatStart = repeatMap.get(numeratorLong);
                break;
            }
            else {
                repeatMap.put(numeratorLong, al.size());
            }
            numeratorLong -= cur*denominatorLong;
            al.add(Long.toString(Math.abs(cur)));
        }
        
        
        StringBuilder sb = new StringBuilder();
        if (isRepeat) {
            for (int i=0; i<repeatStart; i++) {
                sb.append(al.get(i));
            }
            sb.append("(");
            for (int i=repeatStart; i<al.size(); i++) {
                sb.append(al.get(i));
            }
            sb.append(")");
        }
        else {
            for (int i=0; i<al.size(); i++) {
                sb.append(al.get(i));
            }
        }
        if (sb.length() > 0) {
            return frontMatter+Long.toString(intPart)+"."+sb.toString();
        }
        else {
            return frontMatter+Long.toString(intPart);
        }
    }
}