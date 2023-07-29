//saw solution
class Solution {
    public double soupServings(int n) {
        int m = (int)Math.ceil(n / 25.0);
        Map<Integer, Map<Integer, Double>> dp = new HashMap<>();
        dp.put(0, new HashMap<>());
        dp.get(0).put(0, 0.5);

        for (int k = 1; k <= m; k++) {
            dp.put(k, new HashMap<>());
            dp.get(0).put(k, 1.0);
            dp.get(k).put(0, 0.0);
            for (int j = 1; j <= k; j++) {
                dp.get(j).put(k, calculateDP(j, k, dp));
                dp.get(k).put(j, calculateDP(k, j, dp));
            }
            if (dp.get(k).get(k) > 1 - 1e-5) {
                return 1;
            }
        }

        return dp.get(m).get(m);
    }

    private double calculateDP(int i, int j, Map<Integer, Map<Integer, Double>> dp) {
        return (dp.get(Math.max(0, i - 4)).get(j)
                + dp.get(Math.max(0, i - 3)).get(j - 1)
                + dp.get(Math.max(0, i - 2)).get(Math.max(0, j - 2))
                + dp.get(i - 1).get(Math.max(0, j - 3))) / 4;
    }
}
/*
class Solution {
    double result;
    public double soupServings(int n) {
        result = 0;
        // soupServings(n, n, 1);
        Stack<double[]> stk = new Stack();
        stk.add(new double[]{n,n,1});
        while (stk.size() > 0) {
            double[] cur = stk.pop();
            double a = cur[0];
            double b = cur[1];
            double depth = cur[2];
            if (a <= 0) {
                if (b <= 0) {
                    result += depth/2;
                }
                else {
                    result += depth;
                }
            }
            else if (b <= 0) {
                continue;
            }
            else {
                stk.add(new double[]{a-100, b, depth*0.25});
                stk.add(new double[]{a-75, b-25, depth*0.25});
                stk.add(new double[]{a-50, b-50, depth*0.25});
                stk.add(new double[]{a-25, b-75, depth*0.25});
            }
        }
        return result;
    }
    public void soupServings(int a, int b, double depth) {
        if (a <= 0) {
            if (b <= 0) {
                result += depth/2;
            }
            else {
                result += depth;
            }
        }
        else if (b <= 0) {
            return;
        }
        else {
            soupServings(a-100, b, depth*0.25);
            soupServings(a-75, b-25, depth*0.25);
            soupServings(a-50, b-50, depth*0.25);
            soupServings(a-25, b-75, depth*0.25);
        }
    }
}
*/