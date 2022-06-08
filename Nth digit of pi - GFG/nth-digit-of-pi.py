#User function Template for python3

def sqrt(n, MAX):
    float_max = 10**16
    n_float = float((n*float_max)//MAX)/float_max
    curr = (int(float_max*math.sqrt(n_float))*MAX)//float_max
    n_MAX = n*MAX
    while True:
        prev = curr
        curr = (curr+n_MAX//curr)//2
        if curr == prev:
            break
    return curr
    
def power(n):
    if n==0:
        return 1
    ans = power(n//2)
    if n%2==0:
        return ans*ans
    return ans*ans*10
    
def pi(n):
    MAX = power(n+10)
    c = (640320**3)//24
    n = 1
    a_n = MAX
    a_summation = MAX
    b_summation = 0
    
    while a_n != 0:
        a_n *= -(6*n-5)*(2*n-1)*(6*n-1)
        a_n //= n*n*n*c
        a_summation += a_n
        b_summation += n*a_n
        n += 1
    ans = (426880*sqrt(10005*MAX,MAX)*MAX)//(13591409*a_summation+545140134*b_summation)
    
    return ans

class Solution:
        
    def nthDigOfPi(self, N):
        p=str(pi(N))
        
        return p[N-1]
#{ 
#  Driver Code Starts
#Initial Template for Python 3
import math

if __name__ == '__main__': 
    t = int (input ())
    for _ in range (t):
        N=int(input())
        
        ob = Solution()
        print(ob.nthDigOfPi(N))
# } Driver Code Ends