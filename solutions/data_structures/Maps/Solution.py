class Solution:
    def maxLengthBetweenEqualCharacters(self, s: str) -> int:
        map = {}
        result = -1;
        for i,v in enumerate(s):
            prev = map.get(v)
            if not prev:
                map[v] = [i]
                continue
            else:
                prev.append(i)
            result = max(prev[-1]-prev[0]-1,result)
        return result