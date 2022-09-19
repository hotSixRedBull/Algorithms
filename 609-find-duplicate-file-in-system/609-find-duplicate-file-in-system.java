class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, List<String>> map = new HashMap();
        
        for (String path : paths) {
            String[] p = path.split(" ");
            String pathPrefix = p[0];
            for (int i=1; i<p.length; i++) {
                // System.out.println(p[i]);
                String[] splitted = p[i].split("\\(");
                String fileName = splitted[0];
                String content = splitted[1].substring(0, splitted[1].length()-1);
                // System.out.println(content);
                if (map.containsKey(content) == false) {
                    map.put(content, new ArrayList());
                }
                map.get(content).add(pathPrefix+"/"+fileName);
            }
        }
        
        List<List<String>> answer = new ArrayList();
        for (String key : map.keySet()) {
            if (map.get(key).size() > 1) {
                answer.add(map.get(key));
            }
        }
        return answer;
    }
}