//bothersome
//saw solution
class Solution {

    public int nthUglyNumber(int n) {
        TreeSet<Long> uglyNumbersSet = new TreeSet<>(); // TreeSet to store potential ugly numbers
        uglyNumbersSet.add(1L); // Start with 1, the first ugly number
        // TreeSet automatically sorts elements in ascending order and does not
        // allow duplicate entries, just like a HashSet in python

        Long currentUgly = 1L;
        for (int i = 0; i < n; i++) {
            currentUgly = uglyNumbersSet.pollFirst(); // Get the smallest number from the set and remove it

            // Insert the next potential ugly numbers into the set
            uglyNumbersSet.add(currentUgly * 2);
            uglyNumbersSet.add(currentUgly * 3);
            uglyNumbersSet.add(currentUgly * 5);
        }

        return currentUgly.intValue(); // Return the nth ugly number
    }
}
/*
class Solution {
    public int nthUglyNumber(int n) {
        int nth = 1;
        int num = 1;
        int max = 97200000;
        //180000000
        if (n <= 1200) {
            num = 97200000;
            nth = 1100;
            max = 174960000;
        }
        else if (n <= 1300) {
            num = 174960000;
            nth = 1200;
            max = 306110016;
        }
        else if (n <= 1350) {
            num = 306110016;
            nth = 1300;
            max = 398580750;
        }
        else if (n <= 1400) {
            num = 398580750;
            nth = 1350;
            max = Integer.MAX_VALUE;
        }
        else if (n <= 1450) {
            num = 516560652;
            nth = 1400;
            max = Integer.MAX_VALUE;
        }
        else if (n <= 1490) {
            num = 671088640;
            nth = 1450;
            max = Integer.MAX_VALUE;
        }
        else if (n <= 1520) {
            num = 816293376;
            nth = 1490;
            max = Integer.MAX_VALUE;
        }
        else if (n <= 1530) {
            num = 955514880;
            nth = 1520;
            max = Integer.MAX_VALUE;
        }
        else if (n <= 1570) {
            num = 1093500000;
            nth = 1550;
            max = Integer.MAX_VALUE;
        }
        else if (n <= 1590) {
            num = 1209323520;
            nth = 1570;
            max = Integer.MAX_VALUE;
        }
        else if (n <= 1620) {
            num = 1209323520;
            nth = 1600;
            max = Integer.MAX_VALUE;
        }
        else if (n <= 1640) {
            num = 1771470000;
            nth = 1620;
            max = Integer.MAX_VALUE;
        }
        else if (n <= 1660) {
            num = 1944000000;
            nth = 1640;
            max = Integer.MAX_VALUE;
        }
        else if (n <= 1680) {
            num = 2125764000;
            nth = 1660;
            max = Integer.MAX_VALUE;
        }
        else {
            num = 2125764000;
            nth = 1660;
            max = Integer.MAX_VALUE;
        }
        while (num <= max && nth <= n) {
            if (isUgly(num)) {
                System.out.println(String.format("%d, %d", nth, num));
                if (nth == n) {
                    return num;
                }
                nth++;
            }
            else {
                System.out.println(String.format("checked, %d", num));
            }
            num++;
        }
        return -1;
    }
    public boolean isUgly(int num) {
        while (num > 1) {
            if (num % 2 == 0) {
                num /= 2;
            }
            else if (num % 3 == 0) {
                num /= 3;
            }
            else if (num % 5 == 0) {
                num /= 5;
            }
            else {
                break;
            }
        }
        return num == 1;
    }
}
*/