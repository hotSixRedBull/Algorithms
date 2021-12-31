class Solution {
    public int maxProductDifference(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        Arrays.fill(visited, false);
        
        ArrayList<Integer> max = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            if (max.size() < 2 && !visited[i]) {
                max.add(i);
                visited[i] = true;
                max.sort(new Comparator<Integer>() {
                   @Override
                    public int compare(Integer i1, Integer i2) {
                        if (nums[i1] < nums[i2]) {
                            return 1;   
                        }
                        else if (nums[i1] > nums[i2]) {
                            return -1;
                        }
                        return 0;
                    }
                });
            }
            else if (max.size() == 2 && nums[max.get(1)] < nums[i] && !visited[i]) {
                max.add(i);
                visited[i] = true;
                max.sort(new Comparator<Integer>() {
                   @Override
                    public int compare(Integer i1, Integer i2) {
                        if (nums[i1] < nums[i2]) {
                            return 1;   
                        }
                        else if (nums[i1] > nums[i2]) {
                            return -1;
                        }
                        return 0;
                    }
                });
                visited[max.get(2)] = false;
                max.remove(2);
            }
        }
        
        ArrayList<Integer> min = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            if (min.size() < 2 && !visited[i]) {
                min.add(i);
                visited[i] = true;
                min.sort(new Comparator<Integer>() {
                   @Override
                    public int compare(Integer i1, Integer i2) {
                        if (nums[i1] > nums[i2]) {
                            return 1;   
                        }
                        else if (nums[i1] < nums[i2]) {
                            return -1;
                        }
                        return 0;
                    }
                });
            }
            else if (min.size() == 2 && nums[min.get(1)] > nums[i] && !visited[i]) {
                min.add(i);
                visited[i] = true;
                min.sort(new Comparator<Integer>() {
                   @Override
                    public int compare(Integer i1, Integer i2) {
                        if (nums[i1] > nums[i2]) {
                            return 1;   
                        }
                        else if (nums[i1] < nums[i2]) {
                            return -1;
                        }
                        return 0;
                    }
                });
                visited[min.get(2)] = false;
                min.remove(2);
            }
        }
        
        return nums[max.get(0)]*nums[max.get(1)] - nums[min.get(0)]*nums[min.get(1)];
    }
}