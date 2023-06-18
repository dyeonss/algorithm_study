def solution(absolutes, signs):
    answer = 0;
    
    for i in range(len(signs)):
        if not signs[i]:
            answer=answer+(absolutes[i]*-1)
        else:
            answer=answer+absolutes[i]
    return answer