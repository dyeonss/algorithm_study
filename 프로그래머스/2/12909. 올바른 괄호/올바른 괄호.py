def solution(s):
    answer = True
    stack=[]
    
    for b in s:
        if b==')' and len(stack)>0 and stack[-1]=='(':
            stack.pop(-1)
        else:
            stack.append(b)
    
    return True if len(stack)==0 else False