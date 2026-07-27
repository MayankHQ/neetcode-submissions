class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        sc = []
        for token in tokens:
            if token in "+-/*":
                b = sc.pop()
                a = sc.pop()

                match token:
                    case '+':
                        sc.append(a+b)
                    case '-':
                        sc.append(a-b)
                    case '/':
                        sc.append(int(a/b))
                    case '*':
                        sc.append(a*b)
            else:
                sc.append(int(token))
        return sc.pop()