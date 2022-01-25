class Solution {
    public int numPrimeArrangements(int n) {
        int primeCnt = 0;
        int notPrimeCnt = 1; // 1
        for (int i=2; i<=n; i++) {
            if (isPrime(i)) {
                primeCnt++;
            }
            else {
                notPrimeCnt++;
            }
        }
        // System.out.println("primeCnt: "+primeCnt+", notPrimeCnt: "+notPrimeCnt);
        long primeFactorialModulo = 1;
        for (int i=2; i<=primeCnt; i++) {
            primeFactorialModulo *= i; 
            primeFactorialModulo %= (long)(Math.pow(10,9)+7); 
        }
        long notPrimeFactorialModulo = 1;
        for (int i=2; i<=notPrimeCnt; i++) {
            notPrimeFactorialModulo *= i;
            notPrimeFactorialModulo %= (long)(Math.pow(10,9)+7); 
        }
        
        // System.out.println("primeFactorialModulo: "+primeFactorialModulo+", notPrimeFactorialModulo: "+notPrimeFactorialModulo);
        long ans = (primeFactorialModulo * notPrimeFactorialModulo) % (long)(Math.pow(10,9)+7); 
        return (int)ans;
    }
    
    public boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i=2; i<=Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}

/*
따로 계산해보자.
prime number 2 3 5
not prime number 1 4
2개를 배열하는 경우인 2
3개를 배열하는 경우인 3*2
두개를 곱한 것
*/