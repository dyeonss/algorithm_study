def solution(s):
    answer = 0
    tmp=s
    for i in range(len(s)):
        tmp=tmp[1:]+tmp[0]
        stack=[]
        for i in range(len(tmp)):
            if len(stack)==0:
                stack.append(tmp[i])
            else:
                t,last=tmp[i], stack[-1]
                
                if (t==')' and last=='(') or (t=='}' and last=='{') or (t==']' and last=='['):
                    stack.pop()
                else:
                    stack.append(tmp[i])
        if len(stack)==0:
            answer+=1
        
    return answer