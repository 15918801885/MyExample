## coding test

Given a valid sentence without any spaces between the words and a dictionary of valid
English words, find all possible ways to break the sentence in individual dictionary words.

The following dictionary

`{ i, like, sam, sung, samsung, mobile, ice, cream, man go}`

### Test1

Example:

```
Input: "ilikesamsungmobile"
Output: i like sam sung mobile
        i like samsung mobile
```

### Test2

Example:

```
Input: "ilikeicecreamandmango"
Output: i like ice cream and man go
```

### Test3

If user provide a customized dictionary of valid English words as additional input, and the
program will only find in the user customized dictionary

Example:

The user customized dictionary

`{ i, like, sam, sung, mobile, icecream, man go, mango}`

```
Input: "ilikeicecreamandmango"
Output: i like icecream and man go
        i like icecream and mango
```

### Test4

If user provide a customized dictionary of valid English words as additional input, and the
program will find all the valid words in the both dictionaries

Example:

the user customized dictionary
`{ i, like, sam, sung, mobile, icecream, man go, mango}`

```
Input: "ilikeicecreamandmango"
Output: i like ice cream and man go
        i like ice cream and mango
        i like icecream and man go
        i like icecream and mango
```
