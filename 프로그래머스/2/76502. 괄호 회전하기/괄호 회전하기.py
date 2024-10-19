def solution(s):
    answer = 0
    for _ in range(len(s)):
        stack=[]
        for i in range(len(s)):
            if len(stack)==0:
                stack.append(s[i])
            else:
                t,last=s[i], stack[-1]
                if (t==')' and last=='(') or (t=='}' and last=='{') or (t==']' and last=='['):
                    stack.pop()
                else:
                    stack.append(s[i])
        if len(stack)==0:
            answer+=1
        s=s[1:]+s[0]
    return answer