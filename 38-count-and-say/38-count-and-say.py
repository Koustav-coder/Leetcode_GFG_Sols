class Solution:
    def countAndSay(self, n: int) -> str:
        if n == 1:
            return "1"
        prev = self.countAndSay(n-1)
        result = ""
        count = 1 # for prev[0]
        for i in range(1,len(prev)):
            if prev[i-1] != prev[i]:
                result += str(count) + prev[i-1] # sequence ended at i-1
                count = 0
            count += 1
        return result + str(count) + prev[-1] # count of last element