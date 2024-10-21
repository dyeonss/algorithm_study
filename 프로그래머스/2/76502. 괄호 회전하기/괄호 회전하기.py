from collections import deque
def solution(s):
    answer = 0
    q=deque(s)
    
    for _ in range(len(q)):
        stack=deque()
        for i in range(len(q)):
            if len(stack)==0:
                stack.append(q[i])
            else:
                t,last=q[i], stack[-1]
                if (t==')' and last=='(') or (t=='}' and last=='{') or (t==']' and last=='['):
                    stack.pop()
                else:
                    stack.append(q[i])
        if len(stack)==0:
            answer+=1
        q.append(q.popleft())
    return answer