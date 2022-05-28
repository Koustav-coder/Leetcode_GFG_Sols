#User function Template for python3

class Solution:
    def isSuperSimilar(self, n, m, mat, x):
        if(x%m==0):
            return 1;
        else:
            for i in range(n):
                for j in range(m):
                    if mat[i][j]!=mat[i][(j+x)%m]:
                        return 0
            return 1

#{ 
#  Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
    t = int(input())
    for _ in range(t):
        n, m = [int(x) for x in input().split()]
        mat = [[0]*m for x in range(n)]
        arr = input().split()
        for i in range(n*m):
            mat[i//m][i%m] = int(arr[i])
        x=int(input())
        
        ob = Solution()
        print(ob.isSuperSimilar(n, m, mat, x))
# } Driver Code Ends