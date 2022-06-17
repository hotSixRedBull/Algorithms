/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    HashMap<TreeNode, HashMap<Integer, Integer>> nodeMap;
    static int isRoot = 0;
    static int isParentCamera = 1;
    static int isParentCovered = 2;
    static int needCamera = 3;
    
    public int minCameraCover(TreeNode root) {
        nodeMap = new HashMap();
        return placeCameras(root, isRoot);
    }
    
    public int placeCameras(TreeNode cur, int state) {
        if (cur == null) {
            if (state == needCamera) {
                return 1;
            }
            return 0;
        }
        HashMap<Integer, Integer> cache = nodeMap.getOrDefault(cur, new HashMap());
        // System.out.println(cache);
        if (cache.containsKey(state)) {
            // System.out.println(String.format("state: cache, ret: %d", cache.get(state)));
            return cache.get(state);
        }
        if (state == isParentCamera) {
            int covered = 0;
            covered += placeCameras(cur.left, isParentCovered);
            covered += placeCameras(cur.right, isParentCovered);
            int camera = 1;
            camera += placeCameras(cur.left, isParentCamera);
            camera += placeCameras(cur.right, isParentCamera);
            int nextCamera = 0;
            nextCamera += placeCameras(cur.left, needCamera);
            nextCamera += placeCameras(cur.right, needCamera);
            int ret = Math.min(covered, Math.min(camera, nextCamera));
            cache.put(isParentCamera, ret);
            nodeMap.put(cur, cache);
            // System.out.println(String.format("state: isParentCamera, ret: %d", ret));
            return ret;
        }
        else if (state == isParentCovered) {
            int camera = 1;
            camera += placeCameras(cur.left, isParentCamera);
            camera += placeCameras(cur.right, isParentCamera);
            int leftCamera = 0;
            leftCamera += placeCameras(cur.left, needCamera);
            leftCamera += placeCameras(cur.right, isParentCovered);
            // System.out.println(String.format("state: isParentCovered, leftCamera: %d", leftCamera));
            int rightCamera = 0;
            rightCamera += placeCameras(cur.left, isParentCovered);
            rightCamera += placeCameras(cur.right, needCamera);
            // System.out.println(String.format("state: isParentCovered, rightCamera: %d", rightCamera));
            int ret = Math.min(camera, Math.min(leftCamera, rightCamera));
            cache.put(isParentCovered, ret);
            nodeMap.put(cur, cache);
            // System.out.println(String.format("state: isParentCovered, ret: %d", ret));
            return ret;
        }
        else if (state == needCamera) {
            int camera = 1;
            camera += placeCameras(cur.left, isParentCamera);
            camera += placeCameras(cur.right, isParentCamera);
            cache.put(needCamera, camera);
            nodeMap.put(cur, cache);
            // System.out.println(String.format("state: needCamera, camera: %d", camera));
            return camera;
        }
        else {
            int camera = 1;
            camera += placeCameras(cur.left, isParentCamera);
            camera += placeCameras(cur.right, isParentCamera);
            // System.out.println(String.format("state: root, camera: %d", camera));
            int leftCamera = 0;
            leftCamera += placeCameras(cur.left, needCamera);
            leftCamera += placeCameras(cur.right, isParentCovered);
            // System.out.println(String.format("state: root, leftCamera: %d", leftCamera));
            int rightCamera = 0;
            rightCamera += placeCameras(cur.left, isParentCovered);
            rightCamera += placeCameras(cur.right, needCamera);
            // System.out.println(String.format("state: root, rightCamera: %d", rightCamera));
            int ret = Math.min(camera, Math.min(leftCamera, rightCamera));
            cache.put(isParentCamera, ret);
            nodeMap.put(cur, cache);
            // System.out.println(String.format("state: root, ret: %d", ret));
            return ret;
        }
    }
}
/*
[0,0,null,0,0]
[0,0,null,0,null,0,null,null,0]
[0]
[0,null,0]
[0,0,null]
[0,0,0]
[0,0,null,null,0,0,null,null,0,0]
*/