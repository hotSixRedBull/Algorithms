class Fraction {
    public int a;
    public int b;
    public Fraction(int num1, int num2) {
        a = num1;
        b = num2;
    }
    public String toString() {
        return String.format("%d/%d", a, b);
    }
}
class Solution {
    List<Fraction> flist;
    public String fractionAddition(String expression) {
        flist = new ArrayList();
        for (int i=0; i<expression.length(); i++) {
            if (expression.charAt(i) == '/') {
                int numIndex1 = i-1;
                int pos = 1;
                int num1 = 0;
                // System.out.println(String.format("numIndex1: %d", numIndex1));
                while (numIndex1 >= 0) {
                    if (expression.charAt(numIndex1) == '+') {
                        break;
                    }
                    if (expression.charAt(numIndex1) == '-') {
                        num1 *= -1;
                        break;
                    }
                    // System.out.println(String.format("expression.charAt(numIndex1): %c", expression.charAt(numIndex1)));
                    int local = expression.charAt(numIndex1)-'0';
                    num1 += local*pos;
                    pos *= 10;
                    numIndex1--;
                }
                // System.out.println(num1);
                int numIndex2 = i+1;
                pos = 1;
                int num2 = 0;
                while (numIndex2 < expression.length()
                       && expression.charAt(numIndex2) != '+'
                       && expression.charAt(numIndex2) != '-') {
                    num2 *= 10;
                    num2 += expression.charAt(numIndex2)-'0';
                    numIndex2++;
                }
                flist.add(new Fraction(num1, num2));
                // System.out.println(String.format("add %d/%d", num1, num2));
            }
        }
        Fraction f = flist.get(0);
        for (int i=1; i<flist.size(); i++) {
            f = add(f, flist.get(i));
        }
        return f.toString();
    }
    public Fraction add(Fraction a, Fraction b) {
        if (a.b < b.b) {
            return add(b, a);
        }
        
        Fraction result = new Fraction(0, 0);
        //calc
        if (a.b % b.b == 0) {
            int mul = a.b/b.b;
            result.a = a.a+b.a*mul;
            result.b = a.b;
        }
        else {
            result.a = a.a*b.b + b.a*a.b;
            result.b = a.b*b.b;
        }
        //minimize
        // System.out.println(String.format("before: %d/%d",result.a, result.b));
        int max = result.b;
        for (int i=2; i<=max; i++) {
            if (i > result.b) {
                break;
            }
            while (result.a % i == 0
               && result.b % i == 0) {
                result.a /= i;
                result.b /= i;
            }
        }
        // System.out.println(String.format("after: %d/%d",result.a, result.b));
        if (result.a == 0) {
            result.b = 1;
        }
        return result;
    }
}

/*
"-5/2+10/3+7/9"
"7/3+5/2-3/10"
"5/3+1/3"
*/