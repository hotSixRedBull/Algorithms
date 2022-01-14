class Solution:
    def myAtoi(self, s: str) -> int:
        purestring = ""
        sign = ""
        for c in s:
            l = len(purestring)
            # print(f'c : {c}, string: {purestring}')
            if c == ' ' and l==0 and sign == "":
                continue
            #find sign
            elif (c == '-' or c == '+') and l==0:
                sign += c
                if len(sign) > 1:
                    break
            elif c.isdigit() == True:             
                purestring += c
            else:
                print('?')
                break
        result = 0
        if len(purestring) != 0:
            result = int(sign+purestring)
        if result <= -2147483648:
            result = -2147483648
        elif result >= 2147483648:
            result = 2147483647
        return result
'''
"   -42"
"  +  413"
'''