import math
def solution(n):
    answer = 0

    for i in range(1,int(math.sqrt(n))+1):
        if n%i==0:
            if i==n/i:
                answer+=i
            else:
                answer+=(i+(n/i))
            
    return answer