# Z 알고리즘

## 개요
선형시간(O(n))에 문자열 패턴매칭을 할 수 있는 알고리즘.
특정 패턴 p에 대해서, 문자열 s에 p가 몇 번 등장하는 지, 또 어디에 있는 지를 확인할 수 있다.

## 응용
- 경계 확인

## 방법
z배열이라는 배열을 선형시간에 만들면 된다.
z배열은 z[k] = 문자열 s의 prefix와 일치하는 문자 개수.

예시로,
index	0	1	2	3	4	5	6	7	8	9
content	A	B	C	A	B	C	A	B	A	B
value	-	0	0	5	0	0	2	0	2	0

이 있다.

z[3]=5라면, s[0..4]와 s[3..7]이 같으며,
s[5]와 s[8]이 다르거나 
문자열의 길이가 8이라는 의미다.

s[0..4] == 'ABCAB'
s[3..7] == 'ABCAB'
s[5] == C
s[8] == A

z[6]=2라면, s[0..1]과 s[6..7]이 같으며,
s[2]와 s[8]이 다르거나 
문자열의 길이가 8이라는 의미다.

s[0..1] == 'AB'
s[6..7] == 'AB'
s[2] == C
s[8] == A

z[8]=2라면, s[0..1]과 s[8..9]가 같으며,
s[2]와 s[10]이 다르거나 
문자열의 길이가 10이라는 의미다.

s[0..1] == 'AB'
s[8..9] == 'AB'
s[2] == C
s[10]은 없다.

## code
### Java
- 원래라면 나중에 불리는 함수의 정의가 위로 올라와야 하지만, 이해를 위해 순서를 거꾸로 한다.
```
public class ZAlgorithm {

    public static void main(String args[]) {
        String text = "sdfsfeeeffefdfdgeeeggegc";
        string pattern = "eee";
        ZAlgorithm zAlgorithm = new ZAlgorithm();
        List<Integer> result = zAlgorithm.matchPattern(text.toCharArray(), pattern.toCharArray());
        result.forEach(System.out::println);
    }

    public List<Integer> matchPattern(char text[], char pattern[]) {
        char newString[] = new char[text.length + pattern.length + 1];
        int i = 0;
        for(char ch : pattern) {
            newString[i] = ch;
            i++;
        }
        newString[i] = '$';
        i++;
        for(char ch : text) {
            newString[i] = ch;
            i++;
        }
        List<Integer> result = new ArrayList<>();
        int Z[] = calculateZ(newString);

        for(i = 0; i < Z.length; i++) {
            if(Z[i] == pattern.length) {
                result.add(i - pattern.length - 1);
            }
        }
        return result;
    }

    private int[] calculateZ(char input[]) {
        int Z[] = new int[input.length];
        int left = 0;
        int right = 0;
        for(int k = 1; k < input.length; k++) {
            if(k > right) {
                left = right = k;
                while(right < input.length && input[right] == input[right - left]) {
                    right++;
                }
                Z[k] = right - left;
                right--;
            }
            else {
                // we are operating inside box
                int k1 = k - left;
                // if value does not stretches till right bound then just copy it.
                if(Z[k1] < right - k + 1) {
                    Z[k] = Z[k1];
                }
                else {
                    // otherwise try to see if there are more matches.
                    left = k;
                    while(right < input.length && input[right] == input[right - left]) {
                        right++;
                    }
                    Z[k] = right - left;
                    right--;
                }
            }
        }
        return Z;
    }
}


```
### JS
```

```