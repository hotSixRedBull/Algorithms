/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 *     public List<String> getUrls(String url) {}
 * }
 */

class Solution {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        String hostName = String.format("%s//%s",startUrl.split("/")[0], startUrl.split("/")[2]);
        // System.out.println(hostName);
        // System.out.println(htmlParser.getUrls(startUrl));
        Set<String> visited = new HashSet();
        Set<String> urlSet = new HashSet();
        Queue<String> q = new ArrayDeque();
        q.add(startUrl);
        visited.add(startUrl);
        while (q.size() > 0) {
            String cur = q.poll();
            urlSet.add(cur);
            List<String> adjs = htmlParser.getUrls(cur);
            // System.out.println(String.format("adjs: %s", adjs));
            for (String adj : adjs) {
                if (visited.contains(adj)
                   || adj.startsWith(hostName) == false) {
                    continue;
                }
                q.add(adj);
                visited.add(adj);
            }
        }
        List<String> urls = new ArrayList();
        for (String url : urlSet) {
            urls.add(url);
        }
        return urls;
    }
}