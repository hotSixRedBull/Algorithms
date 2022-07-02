// saw solution
class Solution {
    // We will use long instead of int to prevent overflow
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        // Start by sorting the inputs
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int n = horizontalCuts.length;
        int m = verticalCuts.length;
        
        // Consider the edges first
        long maxHeight = Math.max(horizontalCuts[0], h - horizontalCuts[n - 1]);
        for (int i = 1; i < n; i++) {
            // horizontalCuts[i] - horizontalCuts[i - 1] represents the distance between
            // two adjacent edges, and thus a possible height
            maxHeight = Math.max(maxHeight, horizontalCuts[i] - horizontalCuts[i - 1]);
        }
        
        // Consider the edges first
        long maxWidth = Math.max(verticalCuts[0], w - verticalCuts[m - 1]);
        for (int i = 1; i < m; i++){
            // verticalCuts[i] - verticalCuts[i - 1] represents the distance between
            // two adjacent edges, and thus a possible width
            maxWidth = Math.max(maxWidth, verticalCuts[i] - verticalCuts[i - 1]);
        }

        // Be careful of overflow, and don't forget the modulo!
        return (int) ((maxWidth * maxHeight) % (1000000007));
    }
}
/*
class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int modulo = 1_000_000_007;
        List<Integer> widths = new ArrayList();
        List<Integer> heights = new ArrayList();
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        if (horizontalCuts[0] > 0) {
            heights.add(horizontalCuts[0]);
        }
        for (int i=0; i<horizontalCuts.length-1; i++) {
            heights.add(horizontalCuts[i+1]-horizontalCuts[i]);
        }
        if (horizontalCuts[horizontalCuts.length-1] < h) {
            heights.add(h-horizontalCuts[horizontalCuts.length-1]);
        }
        System.out.println("heights: "+heights);
        
        if (verticalCuts[0] > 0) {
            widths.add(verticalCuts[0]);
        }
        for (int i=0; i<verticalCuts.length-1; i++) {
            widths.add(verticalCuts[i+1]-verticalCuts[i]);
        }
        if (verticalCuts[verticalCuts.length-1] < w) {
            widths.add(w-verticalCuts[verticalCuts.length-1]);
        }
        System.out.println("widths: "+widths);
        
        // int max = 0;
        // for (int width : widths) {
        //     for (int height : heights) {
        //         max = Math.max(max, width*height);
        //     }
        // }
        // return max;
        
        Collections.sort(widths);
        Collections.sort(heights);
        long calc = heights.get(heights.size()-1)%modulo*widths.get(widths.size()-1)%modulo;
        return (int) (calc%modulo);
        
    }
}
*/