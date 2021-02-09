#reverse a string
def revstr(string):
    j = len(string)-1
    letters = [x for x in string]
    for i in range(j):
        if  i >= j: break
        tmp=letters[i]
        letters[i]=letters[j]
        letters[j]=tmp
        j -= 1
    return "".join(letters)


def test(*args):
    result = {}
    ans = []
    l = len(args)
    for t in args:
        flip = [x for x in t]
        flip.reverse()
        ans.append("".join(flip))
    for i in range(l):
        result[args[i]] = ans[i]
    for k,v in result.items():
        output=revstr(k)
        print(f"{k},\t {output}\n\t\t\t--> : {'success' if output==v else 'failure'}")


test("12345", "a","four score and     seven years ago", "cat", "12adsf23asdfs12", "12mice12", "  ", "")
