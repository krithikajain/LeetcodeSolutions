class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []

        #run a loop to scan the arrays
        for token in tokens:
            # check for integers
            if token not in {"+","-","*","/"}:
                stack.append(int(token))
            else:
                a = stack.pop()
                b = stack.pop()

                if token == "+":
                    stack.append(b + a)
                elif token == "-":
                    stack.append(b - a)
                elif token == "*":
                    stack.append(b * a)
                else:
                    #division where it truncates towards 0
                    stack.append(int(b / a))
        #return TOS
        return stack[-1]
