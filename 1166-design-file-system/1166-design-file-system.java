class pathNode {
    String pathString;
    int val;
    List<pathNode> childs;
    public pathNode(String str, int v) {
        pathString = str;
        val = v;
        childs = new ArrayList();
    }
}

class FileSystem {
    pathNode root;
    
    public FileSystem() {
        root = new pathNode("", 0);
    }
    
    public boolean createPath(String path, int value) {
        //some validation on path would be here
        String[] splitted = path.split("/");
        pathNode cur = root;
        for (int i=1; i < splitted.length-1; i++) {
            String pathString = splitted[i];
            boolean matched = false;
            for (pathNode childNode : cur.childs) {
                if (pathString.equals(childNode.pathString)) {
                    cur = childNode;
                    matched = true;
                    break;
                }
            }
            if (matched == false) {
                return false;
            }
        }
        String newString = splitted[splitted.length-1];
        for (pathNode childNode : cur.childs) {
            if (newString.equals(childNode.pathString)) {
                return false;
            }
        }
        pathNode newNode = new pathNode(splitted[splitted.length-1], value);
        cur.childs.add(newNode);
        return true;
    }
    
    public int get(String path) {
        String[] splitted = path.split("/");
        pathNode cur = root;
        for (int i=1; i<splitted.length; i++) {
            String pathString = splitted[i];
            // System.out.println(pathString);
            // System.out.println(root.childs);
            boolean matched = false;
            for (pathNode childNode : cur.childs) {
                if (pathString.equals(childNode.pathString)) {
                    cur = childNode;
                    matched = true;
                    break;
                }
            }
            if (matched == false) {
                return -1;
            }
        }
        return cur.val;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */