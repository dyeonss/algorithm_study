def solution(n):
    answer = 0
    
    for i in range(1,n//2+1):
        sum=0
        d=i
        while sum<=n:
            sum+=d
            d+=1
            if sum==n:
                answer+=1
                
    return answer+1