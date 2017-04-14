class Solution(object):
    def countPrimes(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n <= 1:
            return 0
        primes = [True] * n
        primes[0] = primes[1] = False
        for p in range(2,int(n ** 0.5) + 1):
            if primes[p]:
                for i in range(2,int((n - 1)/ p) + 1):
                    primes[p * i] = False
        return sum(primes)