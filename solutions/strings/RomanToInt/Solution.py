class Solution:
    def romanToInt(self, s: str) -> int:
        lookup = {"I":1,"V":5,"X":10,"L":50,"C":100,"D":500,"M":1000}
        ans = 0
        previousVal = -1
        for i in range(len(s)):
            currentVal = lookup[s[len(s)-1-i]]
            if previousVal > currentVal:
                currentVal *= -1
            ans = ans + currentVal
            previousVal = currentVal
        return ans