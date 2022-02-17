class Solution {
    public String licenseKeyFormatting(String s, int k) {
        String[] splitted = s.split("-");
        int size = 0;
        for (int i=0; i<splitted.length; i++) {
            size += splitted[i].length();
        }
        
        List<String> ansList = new ArrayList();
        int i = 0;
        String prev = "";
        if (
            splitted.length > i
            && size % k != 0
        ) {
            int firstGroupLen = size % k;
            String toPut = splitted[i++];
            while (i < splitted.length && toPut.length() == 0) {
                toPut = splitted[i++];
            }
            if (firstGroupLen > toPut.length()) {
                while (firstGroupLen > toPut.length()) {
                    String next = splitted[i++];
                    while (i < splitted.length && next.length() == 0) {
                        next = splitted[i++];
                    }
                    if (firstGroupLen-toPut.length() < next.length()) {
                        prev = next.substring(
                            firstGroupLen-toPut.length(),
                            next.length()
                        );
                        toPut += next.substring(
                            0, 
                            firstGroupLen-toPut.length()
                        );
                    }
                    else {
                        toPut += next;
                    }
                    if (toPut.length() == firstGroupLen) {
                        ansList.add(toPut.toUpperCase());
                        break;
                    }
                }
            }
            else if (firstGroupLen < toPut.length()) {
                ansList.add(toPut.substring(0, firstGroupLen).toUpperCase());
                prev = toPut.substring(firstGroupLen, toPut.length());
            }
            else {
                ansList.add(toPut.toUpperCase());
            }
        }
        for (; i<splitted.length; i++) {
            int len = prev.length() + splitted[i].length();
            // System.out.println("len: "+len);
            // System.out.println("prev: "+prev);
            if (len < k) {
                prev += splitted[i].toUpperCase();
                continue;
            }
            else if (len == k) {
                ansList.add(prev.toUpperCase()+splitted[i].toUpperCase());
                prev = "";
            }
            else {
                String toPut = prev.toUpperCase();
                int endIndex = k-toPut.length();
                if (endIndex < 0) {
                    prev = toPut.substring(k, toPut.length());
                    prev += splitted[i].toUpperCase();
                    toPut = toPut.substring(0, k).toUpperCase();
                }
                else {
                    toPut += splitted[i].substring(0, endIndex);
                    prev = splitted[i].substring(
                        endIndex, 
                        splitted[i].length()
                    ).toUpperCase();
                }
                ansList.add(toPut.toUpperCase());
                // System.out.println("toPut: "+toPut);
            }
            // System.out.println("next prev: "+prev);
        }
        while (prev.length() > k) {
            String toPut = prev.substring(0, k).toUpperCase();
            ansList.add(toPut);
            prev = prev.substring(k, prev.length());
        }
        if (prev.length() == k) {
            ansList.add(prev.toUpperCase());
            prev = "";
        }
        // System.out.println("ansList: "+ansList);
        String[] ansArr = ansList.toArray(new String[0]);
        return String.join("-", ansArr);
    }
}
/*
"2-4A0r7-4k"
4
"2-4A0r7-4k"
3
"aaaa"
2
"0123456789"
1
"a0001afds-"
4
*/