class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        for (int a=0; a<accounts.size()*10; a++) {
            for (int i=0; i<accounts.size(); i++) {
                //sort
                Set<String> s = new HashSet<>();
                for (int j=1; j<accounts.get(i).size(); j++) {
                    s.add(accounts.get(i).get(j));
                }
                List<String> ret = new ArrayList<>();
                ret.add(accounts.get(i).get(0));
                String[] emails = s.toArray(new String[0]);
                Arrays.sort(emails);
                for (int j=0; j<emails.length; j++) {
                    ret.add(emails[j]);
                }
                accounts.set(i, ret);
                for (int j=i+1; j < accounts.size(); j++) {
                    if (areMergable(accounts.get(i), accounts.get(j))) {
                        accounts.set(i, merge(accounts.get(i), accounts.get(j)));
                        accounts.remove(j);
                        j--;
                    }
                }
            }
        }
        System.out.println(accounts.size());
        return accounts;
    }
    public boolean areMergable(List<String> arr1, List<String> arr2) {
        if (!arr1.get(0).equals(arr2.get(0))) {
            return false;
        }
        HashMap<String, Boolean> map = new HashMap<>();
        for (int i=1; i<arr1.size(); i++) {
            map.put(arr1.get(i), true);
        }
        
        for (int i=1; i<arr2.size(); i++) {
            if (map.containsKey(arr2.get(i))) {
                return true;
            }
        }
        return false;
    }
    public List<String> merge(List<String> arr1, List<String> arr2) {
        Set<String> s = new HashSet<>();
        for (int i=1; i<arr1.size(); i++) {
            s.add(arr1.get(i));
        }
        for (int i=1; i<arr2.size(); i++) {
            s.add(arr2.get(i));
        }
        List<String> ret = new ArrayList<>();
        ret.add(arr1.get(0));
        String[] emails = s.toArray(new String[0]);
        Arrays.sort(emails);
        for (int i=0; i<emails.length; i++) {
            ret.add(emails[i]);
        }
        return ret;
    }
}