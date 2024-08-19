def solution(x):
    li=list(str(x))
    if x%sum(int(i) for i in li)==0:
        return True
    return False