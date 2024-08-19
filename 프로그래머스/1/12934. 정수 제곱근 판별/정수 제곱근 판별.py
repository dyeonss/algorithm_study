def solution(n):
    answer = 0
    x=n**(1/2)

    if x%1==0:
        return (x+1)**2
    return -1