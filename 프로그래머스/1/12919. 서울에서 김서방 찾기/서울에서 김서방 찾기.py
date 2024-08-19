def solution(seoul):
    answer = '김서방은 '
    
    for idx, s in enumerate(seoul):
        if s.find('Kim')!=-1:
            answer+=str(idx)+'에 있다'
            break
    return answer