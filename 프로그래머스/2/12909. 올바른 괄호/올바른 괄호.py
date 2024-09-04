def solution(s):
    stack=[]
    
    for b in s:
        if b==')':
            if len(stack)==0:
                return False
            else:
                stack.pop()
        else:
            stack.append(b)
    
    return True if len(stack)==0 else False