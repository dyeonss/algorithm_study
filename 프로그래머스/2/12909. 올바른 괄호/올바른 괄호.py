def solution(s):
    stack=[]
    
    for b in s:
        if b==')' and len(stack)>0 and stack[-1]=='(':
            stack.pop()
        else:
            stack.append(b)
    
    return True if len(stack)==0 else False